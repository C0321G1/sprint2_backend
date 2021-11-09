package c0321g1_pawnshop_backend.service.employee;

import c0321g1_pawnshop_backend.dto.employee.EmployeeDto;
import c0321g1_pawnshop_backend.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface EmployeeService {

    //create by HauHP
    Map<String, Object> saveEmployee(EmployeeDto employeeDto, BindingResult bindingResult);

    //create by HauHP
    Optional<Employee> findById(Long id);

    //create by HauHP
    void editEmployee(EmployeeDto employeeDto);

    //ly huynh
    Page<Employee> findAllEmployee(Pageable pageable);

    List<String> findAllListAddresss();

    void deleteEmployee(Long id);

//    Optional<Employee> findEmployeeById(Long id);

    Page<Employee> searchEmployeeByNamePhoneAddress(Pageable pageable,String name,String phone,String address);

    void editEmployeeInfor(EmployeeDto employeeDto);

    //Creator: Nhung
    List<Employee> listEmployee();
}
