package c0321g1_pawnshop_backend.repository.employee;

import c0321g1_pawnshop_backend.entity.employee.Employee;
import c0321g1_pawnshop_backend.entity.news.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    @Query(value = "SELECT * FROM employee where employee_id = ?1 and flag = 0", nativeQuery = true)
    Optional<Employee> findByIdEmployee(Long id);
}
