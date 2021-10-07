package c0321g1_pawnshop_backend.service.security;

import c0321g1_pawnshop_backend.entity.security.Account;

public interface AccountService {
    //create by HauHP
    void saveAccount(Account account);

    //create by HauHP
    void editAccount(Account account);

    //create by HauHP
    void saveRoleForAccount(Long accountId, Long roleId);
}
