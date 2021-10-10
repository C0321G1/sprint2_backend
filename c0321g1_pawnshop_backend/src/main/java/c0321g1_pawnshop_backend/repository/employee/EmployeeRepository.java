package c0321g1_pawnshop_backend.repository.employee;

import c0321g1_pawnshop_backend.entity.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    //Creator: Nhung
    @Query(value = "SELECT employee.* FROM employee " +
            "join account on employee.account_id = account.account_id WHERE employee.flag = 0", nativeQuery = true)
    List<Employee> listEmployee();

    @Query(value = "select * from employee where employee.employee_id = ?1", nativeQuery = true)
    Optional<Employee> findEmployeeById(Long id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE `c0321g1_pawnshop2`.`employee` SET `address` = ?1, `birth_date` = ?2," +
            " `email` = ?3, `employee_code` = ?4, `flag` = ?5, `id_card` = ?6," +
            " `image` = ?7, `name` = ?8, `phone` = ?9, `salary` = ?10," +
            " `account_id` = ?11, `gender_id` = ?12 WHERE (`employee_id` = ?13)", nativeQuery = true)
    void editEmployee(String address, String birthDate, String email, String employeeCode, Long flag, String idCard,
                      String image, String name, String phone, String salary, Long accountId, Long genderId, Long employeeId);
}
