package c0321g1_pawnshop_backend.service_impl.security;

import c0321g1_pawnshop_backend.entity.security.Account;
import c0321g1_pawnshop_backend.repository.security.AccountRepository;
import c0321g1_pawnshop_backend.service.security.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    PasswordEncoder encoder;

    @Override
    public Optional<Account> findByUserNames(String userName) {
        return accountRepository.findByUserNames(userName);
    }

    @Override
    public void changePassWord(String newPassword,Long accountId) {
        accountRepository.changePassWord(encoder.encode(newPassword), accountId);
    }
}
