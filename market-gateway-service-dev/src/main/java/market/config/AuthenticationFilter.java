package market.config;

import io.jsonwebtoken.Claims;
import lombok.AllArgsConstructor;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
@RefreshScope
@AllArgsConstructor
public class  AuthenticationFilter implements GatewayFilter {
    private RouterValidator routerValidator;
    private JwtUtil jwtUtil;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();

        if (this.isAuthMissing(request)) {

            if (routerValidator.isSecured.test(request)) {
                return this.onError(exchange, "Authorization header is missing in request",
                        HttpStatus.UNAUTHORIZED);
            }
        }

        if (!this.isAuthMissing(request)) {

            final String token = this.getAuthHeader(request);

            if (!jwtUtil.validateToken(token)) {
                return this.onError(exchange, "Authorization header is invalid",
                        HttpStatus.UNAUTHORIZED);
            }

            if (routerValidator.isLimitedAccess.test(request)) {

                if (!routerValidator.checkAccess(request, token)) {
                    return this.onError(exchange, "No rights to view this page",
                            HttpStatus.FORBIDDEN);
                }
            }
            this.populateRequestWithHeaders(exchange, token);
        }


        return chain.filter(exchange);
    }

    private void populateRequestWithHeaders(ServerWebExchange exchange, String token) {
        Claims claims = jwtUtil.extractAllClaimsFromToken(token);
        exchange.getRequest().mutate()
                .header("id", String.valueOf(claims.get("id")))
                .header("role", String.valueOf(claims.get("role")))
                .build();
    }

    private String getAuthHeader(ServerHttpRequest request) {
        return request.getHeaders().getOrEmpty("Authorization").get(0);
    }

    private Mono<Void> onError(ServerWebExchange exchange, String err, HttpStatus httpStatus) {
        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(httpStatus);
        return response.setComplete();
    }

    private boolean isAuthMissing(ServerHttpRequest request) {
        return !request.getHeaders().containsKey("Authorization");
    }
}
