package market.service;

import market.dto.AccountResponseDto;
import market.dto.SignInVkRequestDto;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public interface VkAuthorizationService {

    String createAuthorizationUrl();

    AccountResponseDto authorizationByVk(String code);

    SignInVkRequestDto authorizationByCode(String code) throws IOException, ExecutionException, InterruptedException;
}
