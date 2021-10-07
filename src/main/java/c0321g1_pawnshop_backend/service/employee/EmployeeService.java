package c0321g1_pawnshop_backend.service.employee;

import c0321g1_pawnshop_backend.dto.employee.EmployeeDto;
import c0321g1_pawnshop_backend.entity.employee.Employee;
import org.springframework.validation.BindingResult;

import java.util.Map;
import java.util.Optional;

public interface EmployeeService {

    //create by HauHP
    void saveEmployee(Employee employee);

    //create by HauHP
    Optional<Employee> findById(Long id);

    //create by HauHP
    void editEmployee(Employee employee);
}
