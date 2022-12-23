package market.service.impl.specification;

import market.entity.Account;
import org.springframework.data.jpa.domain.Specification;

public class AccountSpecification {

    public static Specification<Account> hasEmailLike(String emailSnippet) {
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.<String>get("email"), "%" + emailSnippet + "%"));
    }
}
