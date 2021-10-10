package c0321g1_pawnshop_backend.controller.employee;

import c0321g1_pawnshop_backend.dto.employee.EmployeeDto;
import c0321g1_pawnshop_backend.entity.customer.Gender;
import c0321g1_pawnshop_backend.entity.employee.Employee;
import c0321g1_pawnshop_backend.service.customer.GenderService;
import c0321g1_pawnshop_backend.service.employee.EmployeeService;
import c0321g1_pawnshop_backend.service.security.AccountService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "employee")
public class EmployeeRestController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private GenderService genderService;

    //Creator: Nhung
    @GetMapping("listEmployee")
    public ResponseEntity<List<Employee>> getListEmployee() {
        List<Employee> employeeList = employeeService.listEmployee();
        if (employeeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

//    @PatchMapping("/employee")
//    public ResponseEntity<Void> editEmployee(@RequestBody @Valid EmployeeDto employeeDto) {
//        Employee employee = new Employee();
//        BeanUtils.copyProperties(employeeDto, employee);
//        this.accountService.editAccount(employee.getAccount());
//        this.employeeService.editEmployee(employee);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

    @PatchMapping("edit")
    public ResponseEntity<Void> editEmployee(@RequestBody @Valid EmployeeDto employeeDto, BindingResult bindingResult) {
        this.employeeService.editEmployee(employeeDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("gender")
    public ResponseEntity<List<Gender>> getListGender() {
        List<Gender> genderList = genderService.findAll();
        if (genderList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(genderList, HttpStatus.OK);
    }
}
