package c0321g1_pawnshop_backend.repository.security;

import c0321g1_pawnshop_backend.entity.security.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {

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
    @Query(value = "UPDATE `account` " +
            "SET `account`.status = ?1" +
            "WHERE `account`.username = ?2 ", nativeQuery = true)
    void changeStatus(int Status, Long accountId);
}
