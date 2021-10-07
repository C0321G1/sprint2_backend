package c0321g1_pawnshop_backend.repository.security;

import c0321g1_pawnshop_backend.entity.security.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    @Transactional
    @Modifying
    @Query(value = "INSERT into account (username,password,user_time) values (?1,?2,curdate());", nativeQuery = true)
    void saveAccount(String username, String password);

    @Query(value = "select * from account", nativeQuery = true)
    List<Account> getAccountList();

    @Query(value = "select * from account where account_id = ?1", nativeQuery = true)
    Optional<Account> findById(Long id);

    @Query(value = "select * from account where username = ?1", nativeQuery = true)
    Optional<Account> findByUsername(String username);

    @Transactional
    @Modifying
    @Query(value = "UPDATE account set username = ?1, password = ?2 where account_id = ?3 ", nativeQuery = true)
    void editAccount(String username, String password, Long id);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO `c0321g1_pawnshop2`.`account_role` (`account_id`, `role_id`) " +
            "VALUES (?1, ?2);", nativeQuery = true)
    void saveRoleForAccount(Long accountId, Long role);
}
