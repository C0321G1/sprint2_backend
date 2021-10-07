package c0321g1_pawnshop_backend.repository.employee;

import c0321g1_pawnshop_backend.entity.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    //    create by HauHP
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO `c0321g1_pawnshop2`.`employee` ( `address`, `birth_date`, `email`," +
            " `employee_code`, `flag`, `id_card`, `image`, `name`, `phone`, `salary`, `account_id`, `gender_id`)" +
            " VALUES ( ?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9, ?10, ?11, ?12);", nativeQuery = true)
    void saveEmployee(String address, String birthDate, String email, String employeeCode, Long flag, String idCard,
                      String image, String name, String phone, String salary, Long accountId, Long genderId);

    //    create by HauHP
    @Query(value = "select * from employee where employee.employee_id = ?1", nativeQuery = true)
    Optional<Employee> findEmployeeById(Long id);

    //    create by HauHP
    @Transactional
    @Modifying
    @Query(value = "UPDATE `c0321g1_pawnshop2`.`employee` SET `address` = ?1, `birth_date` = ?2," +
            " `email` = ?3, `employee_code` = ?4, `flag` = ?5, `id_card` = ?6," +
            " `image` = ?7, `name` = ?8, `phone` = ?9, `salary` = ?10," +
            " `account_id` = ?11, `gender_id` = ?12 WHERE (`employee_id` = ?13);\n", nativeQuery = true)
    void editEmployee(String address, String birthDate, String email, String employeeCode, Long flag, String idCard,
                      String image, String name, String phone, String salary, Long accountId, Long genderId, Long employeeId);
}
