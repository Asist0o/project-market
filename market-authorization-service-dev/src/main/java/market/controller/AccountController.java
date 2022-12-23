package market.controller;

import lombok.AllArgsConstructor;
import market.dto.AccountResponseDto;
import market.dto.page.PageContentResponseDto;
import market.response.Response;
import market.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/admin/accounts")
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/page")
    public Response<PageContentResponseDto<AccountResponseDto>> get(@RequestParam(name = "pageNumber", defaultValue = "1")
                                                                            int pageNumber,
                                                                    @RequestParam(name = "pageSize", defaultValue = "20")
                                                                            int pageSize,
                                                                    @RequestParam(value = "emailSnippet", required = false)
                                                                            String emailSnippet) {
        return Response.success(
                accountService.findAllAccounts(pageNumber, pageSize, emailSnippet), HttpStatus.OK);
    }
}
