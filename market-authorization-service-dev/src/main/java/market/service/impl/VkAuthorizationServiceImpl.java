package market.service.impl;

import com.github.scribejava.apis.vk.VKOAuth2AccessToken;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.AccessTokenRequestParams;
import com.github.scribejava.core.oauth.OAuth20Service;
import market.dto.AccountResponseDto;
import market.dto.SignInVkRequestDto;
import market.exception.VkAuthException;
import market.service.AccountService;
import market.service.VkAuthorizationService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

@Service
public class VkAuthorizationServiceImpl implements VkAuthorizationService {

    private final OAuth20Service auth20Service;
    private final AccountService accountService;

    @Value("${vk.client.resource}")
    private String vkResourceUrl;

    @Value("${vk.client.scope}")
    private String scope;

    public VkAuthorizationServiceImpl(OAuth20Service auth20Service, AccountService accountService) {
        this.auth20Service = auth20Service;
        this.accountService = accountService;
    }

    @Override
    public String createAuthorizationUrl() {
        return auth20Service.createAuthorizationUrlBuilder().scope(scope).build();
    }

    @Override
    public AccountResponseDto authorizationByVk(String code) {
        SignInVkRequestDto user = null;
        try {
            user = authorizationByCode(code);
        } catch (IOException | ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        AccountResponseDto accountResponseDto;
        if (user != null) {
            if (!accountService.existByEmail(user.email())) {
                accountResponseDto = accountService.createAccount(
                        user.firstName(), user.lastName(), user.email(), UUID.randomUUID().toString(), false);
            } else {
                accountResponseDto = accountService.findByEmail(user.email());
            }
        } else {
            throw new EntityNotFoundException("User not found by code: " + code);
        }
        return accountResponseDto;
    }

    @Override
    public SignInVkRequestDto authorizationByCode(String code) throws IOException, ExecutionException, InterruptedException {
        OAuth2AccessToken accessToken = auth20Service.getAccessToken(AccessTokenRequestParams.create(code)
                .scope(scope));

        if (!(accessToken instanceof VKOAuth2AccessToken) ||
                (((VKOAuth2AccessToken) accessToken).getEmail() == null)) {
//            почта лежит вместе с токеном, а не в market.response.getBody()
//            почта может быть не привязан к аккаунту
            throw new VkAuthException("email not linked to VK account");
        }

        final OAuthRequest request = new OAuthRequest(Verb.GET, vkResourceUrl);
        auth20Service.signRequest(accessToken, request);
        try (Response response = auth20Service.execute(request)) {
            if (response.isSuccessful()) {
                // формат market.response.getBody()
                // {"market.response":[{"id":732833411,"first_name":"testvk","last_name":"testvk","can_access_closed":true,"is_closed":false}]}

                JSONObject jsonObject = new JSONObject(response.getBody());
                jsonObject = jsonObject.getJSONArray("market.response").getJSONObject(0);
                return new SignInVkRequestDto(jsonObject.getString("first_name"),
                        jsonObject.getString("last_name"), (((VKOAuth2AccessToken) accessToken).getEmail()));
            }
        }
        throw new VkAuthException("Failed VK authorization");
    }
}


//    @Value("${jwt.token.expiration}")
//    private final long jwtExpiration;
//    @Override
//    public AccountDto authorizationByVk(AuthVkUser user) {
//        AccountDto accountDto;
//        if (!accountService.existByEmail(user.email())) {
//            accountDto = accountService.createAccount(
//                    user.firstName(), user.lastName(), user.email(), UUID.randomUUID().toString(), false);
//        } else {
//            accountDto = accountService.findByEmail(user.email());
//        }
//        return accountDto;
//    }