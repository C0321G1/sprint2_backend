package c0321g1_pawnshop_backend.repository.security;

import c0321g1_pawnshop_backend.entity.security.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    @Transactional
    @Modifying
    @Query(value = "INSERT into account (username,password,user_time,status) values (?1,?2,curdate(),0);", nativeQuery = true)
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

    //khue

    @Query(value = "select * from account where username = ?1", nativeQuery = true)
    Optional<Account> findByUserNames(String userName);

    @Transactional
    @Modifying
    @Query(value = "UPDATE `account` " +
            "SET `account`.password = ?1 , `account`.user_time = curdate() " +
            "WHERE `account`.account_id = ?2 ", nativeQuery = true)
    void changePassWord(String newPassword, Long accountId);

    @Transactional
    @Modifying
    @Query(value = "insert into account_role (account_role.account_id, account_role.role_id) " +
            "value ( ?1 , ?2 )", nativeQuery = true)
    void setAccountRole(Long accountId, Long roleId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE account SET account.status =?1 WHERE account.account_id =?2", nativeQuery = true)
    void changeStatus(int Status, Long accountId);


}
