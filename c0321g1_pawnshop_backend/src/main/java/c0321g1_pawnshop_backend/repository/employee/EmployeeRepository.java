package c0321g1_pawnshop_backend.repository.employee;

import c0321g1_pawnshop_backend.entity.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    //Creator: Nhung
    @Query(value = "SELECT employee.image,employee.name,account.username,account.status FROM employee " +
            "join account on employee.account_id = account.account_id WHERE employee.flag = 0", nativeQuery = true)
    List<Employee> listEmployee();
}
