package c0321g1_pawnshop_backend.service.employee;

import c0321g1_pawnshop_backend.entity.employee.Employee;

import java.util.Optional;

public interface EmployeeService {
    Optional<Employee> findById(Long id);
}
