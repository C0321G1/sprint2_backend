package c0321g1_pawnshop_backend.repository.security;

import c0321g1_pawnshop_backend.entity.security.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {
}
