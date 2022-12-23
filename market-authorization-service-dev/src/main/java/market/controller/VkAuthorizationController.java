package market.controller;

import lombok.AllArgsConstructor;
import market.dto.AccountResponseDto;
import market.response.Response;
import market.service.VkAuthorizationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@AllArgsConstructor
@RestController
@RequestMapping("api/vk/")
public class VkAuthorizationController {

    private final VkAuthorizationService vkAuthorizationService;

    @GetMapping("vk/oauth")
    public void vkAuthorization(HttpServletResponse response) throws IOException {
        response.sendRedirect(vkAuthorizationService.createAuthorizationUrl());
    }

    @GetMapping("vk/sign")
    public Response<AccountResponseDto> vkSigIn(@RequestParam(value = "code") String code) {
        return Response.success(vkAuthorizationService.authorizationByVk(code), HttpStatus.OK);
    }
}
