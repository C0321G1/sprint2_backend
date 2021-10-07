package c0321g1_pawnshop_backend.controller.employee;

import c0321g1_pawnshop_backend.dto.employee.EmployeeDto;
import c0321g1_pawnshop_backend.entity.employee.Employee;
import c0321g1_pawnshop_backend.entity.security.Account;
import c0321g1_pawnshop_backend.repository.security.AccountRepository;
import c0321g1_pawnshop_backend.service.employee.EmployeeService;
import c0321g1_pawnshop_backend.service.security.AccountService;
import c0321g1_pawnshop_backend.service_impl.security.AccountServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping
public class EmployeeRestController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private AccountService accountService;

    // HauHP
    @PostMapping(value = "/employee")
    public ResponseEntity<Void> createEmployee(@RequestBody @Valid EmployeeDto employeeDto) {
        System.out.println(employeeDto.getAccount().getUsername());
        System.out.println(employeeDto.getAccount().getPassword());
        System.out.println(employeeDto.getAccount().getUserTime());

        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        System.out.println(employee.getEmail()+" day la email");
        System.out.println("sau khi copy"+ employee.getAccount().getUsername());
        this.accountService.saveAccount(employee.getAccount());
        this.accountService.saveRoleForAccount(employee.getAccount().getAccountId(), (long) 1);
        this.employeeService.saveEmployee(employee);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // HauHP
    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id) {

        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Optional<Employee> employeeOptional = employeeService.findById(id);
        if (!employeeOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employeeOptional.get(), HttpStatus.OK);
    }

    // HauHP
    @PatchMapping("/employee")
    public ResponseEntity<Void> editEmployee(@RequestBody @Valid EmployeeDto employeeDto) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        this.accountService.saveAccount(employee.getAccount());
        this.employeeService.editEmployee(employee);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
