package market.config;

import lombok.AllArgsConstructor;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static market.config.UrlServices.*;

@Configuration
@AllArgsConstructor
@EnableHystrix
public class  GatewayConfig {

    private final AuthenticationFilter authenticationFilter;

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes()
                .route("MARKET-AUTHORIZATION", route -> route.path("/api/auth/**")
//                        .filters(f -> f.filter(authenticationFilter))
                        .uri(AUTH_SERVICE.getUrl()))
//
                .route("MARKET-EMAIL", route -> route.path("/api/email/**")
//                        .filters(f -> f.filter(authenticationFilter))
                        .uri(EMAIL_SERVICE.getUrl()))

                .route("MARKET-ADS", route -> route.path("/api/ads/**")
//                        .filters(f -> f.filter(authenticationFilter))
                        .uri(ADS_SERVICE.getUrl()))

                .route("MARKET-CHAT", route -> route.path("/api/chat/**")
//                        .filters(f -> f.filter(authenticationFilter))
                        .uri(CHAT_SERVICE.getUrl()))
//
                .route("MARKET-PROFILES", route -> route.path("/api/profiles/**")
//                        .filters(f -> f.filter(authenticationFilter))
                        .uri(PROFILE_SERVICE.getUrl()))
//
                .route("MARKET-PAYMENT", route -> route.path("/api/payment/**")
//                        .filters(f -> f.filter(authenticationFilter))
                        .uri(PAYMENT_SERVICE.getUrl()))
//
                .route("MARKET-NOTIFICATION", route -> route.path("/api/notification/**")
//                        .filters(f -> f.filter(authenticationFilter))
                        .uri(NOTIFICATION_SERVICE.getUrl()))

                .route("MARKET-STORAGE", route -> route.path("/api/file/**")
//                        .filters(f -> f.filter(authenticationFilter))
                        .uri(FILE_STORAGE_SERVICE.getUrl()))

                .build();
    }


}
