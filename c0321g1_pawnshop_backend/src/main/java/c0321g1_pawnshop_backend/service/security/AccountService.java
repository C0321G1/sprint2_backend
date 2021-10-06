package c0321g1_pawnshop_backend.service.security;

import c0321g1_pawnshop_backend.entity.security.Account;

import java.util.Optional;

public interface AccountService {

    Optional<Account> findByUserNames(String userName);

    void changePassWord(String newPassword,Long accountId);

    void changeStatus(int Status, Long accountId);
}
