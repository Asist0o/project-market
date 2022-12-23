package market.util;
import market.dto.AccessPairDto;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;


@Component
public class CookieUtil {

    public void setCookieInResponse(HttpServletResponse httpServletResponse, AccessPairDto pair) {
        Cookie accessCookie = new Cookie("accessCookie", pair.accessToken());
        accessCookie.setMaxAge(30 * 24 * 60 * 60);
        accessCookie.setHttpOnly(true);
        accessCookie.setPath("/");
        accessCookie.setSecure(true);

        Cookie refreshCookie = new Cookie("refreshCookie", pair.refreshToken());
        refreshCookie.setMaxAge(30 * 24 * 60 * 60);
        refreshCookie.setHttpOnly(true);
        refreshCookie.setPath("/");
        refreshCookie.setSecure(true);

        httpServletResponse.addCookie(accessCookie);
        httpServletResponse.addCookie(refreshCookie);
    }
}
