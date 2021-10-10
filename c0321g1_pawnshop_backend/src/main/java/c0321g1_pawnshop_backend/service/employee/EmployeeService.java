package c0321g1_pawnshop_backend.service.employee;

import c0321g1_pawnshop_backend.dto.employee.EmployeeDto;
import c0321g1_pawnshop_backend.entity.employee.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    //Creator: Nhung
    List<Employee> listEmployee();

    void editEmployee(EmployeeDto employeeDto);

    Optional<Employee> findById(Long id);
}
