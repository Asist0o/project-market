package market.config;

import io.jsonwebtoken.Claims;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.function.Predicate;

@Component
public class RouterValidator {

    @Autowired
    private JwtUtil jwtUtil;

    public static final List<String> openApiEndPoints = List.of(
            "/auth/register",
            "/auth/login"
    );

    private final Map<String, List<String>> rolesEndpoints = Map.of(
            "ADMIN", List.of("/api/admin", "/api/founder"));

    private final Collection<List<String>> urls = rolesEndpoints.values().stream().toList();


    public Predicate<ServerHttpRequest> isSecured =
            request -> openApiEndPoints
                    .stream()
                    .noneMatch(uri -> request.getURI().getPath().contains(uri));


    public Predicate<ServerHttpRequest> isLimitedAccess =
            request -> urls.stream().anyMatch(uri -> request.getURI().getPath().contains((CharSequence) uri));

    public boolean checkAccess(ServerHttpRequest request, String token) {
        boolean check = false;
        String role = jwtUtil.extractAuthorities(token);
        String url = String.valueOf(urls.stream().filter(uri -> request.getURI().getPath().contains((CharSequence) uri)));Set<Map.Entry<String, List<String>>> entrySet = rolesEndpoints.entrySet();
        for (Map.Entry<String, List<String>> pair : entrySet) {
            if (pair.getValue().contains(url)) {
                if (role.equals(pair.getKey())) {
                    check = true;
                }
            }
        }
        return check;
    }
}




