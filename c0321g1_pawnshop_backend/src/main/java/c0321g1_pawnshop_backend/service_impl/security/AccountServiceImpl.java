package c0321g1_pawnshop_backend.service_impl.security;

import c0321g1_pawnshop_backend.entity.security.Account;
import c0321g1_pawnshop_backend.repository.security.AccountRepository;
import c0321g1_pawnshop_backend.service.security.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Override
    public void saveAccount(Account account) {
        accountRepository.saveAccount(account.getUsername(), account.getPassword());
    }

    @Override
    public void editAccount(Account account) {
        accountRepository.editAccount(account.getUsername(), account.getPassword(), account.getAccountId());
    }

    @Override
    public void saveRoleForAccount(Long accountId, Long roleId) {
        accountRepository.saveRoleForAccount(accountId, roleId);
    }

    @Override
    public List<Account> getAccountList() {
        return accountRepository.getAccountList();
    }
}
