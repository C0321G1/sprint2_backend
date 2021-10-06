package c0321g1_pawnshop_backend.service_impl.security;

import c0321g1_pawnshop_backend.entity.security.Account;
import c0321g1_pawnshop_backend.repository.security.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByUserNames(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: "+ username));
        return UserDetailsImpl.build(account);
    }
}
