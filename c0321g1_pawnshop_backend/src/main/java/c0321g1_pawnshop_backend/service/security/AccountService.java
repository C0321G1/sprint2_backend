package c0321g1_pawnshop_backend.service.security;

import c0321g1_pawnshop_backend.entity.security.Account;

import javax.mail.MessagingException;
import java.util.List;
import java.util.Optional;

public interface AccountService {
    //create by HauHP
    void saveAccount(Account account);

    //create by HauHP
    void editAccount(Account account);

    //create by HauHP
    void saveRoleForAccount(Long accountId, Long roleId);

    //create by HauHP
    List<Account> getAccountList();

    //khue
    Optional<Account> findByUserNames(String userName);

    void changePassWord(String newPassword,Long accountId) throws MessagingException;

    void changeStatus(int Status, Long accountId);

}
