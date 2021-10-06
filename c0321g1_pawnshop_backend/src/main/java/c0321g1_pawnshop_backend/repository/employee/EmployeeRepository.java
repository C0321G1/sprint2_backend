package c0321g1_pawnshop_backend.repository.employee;

import c0321g1_pawnshop_backend.entity.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
