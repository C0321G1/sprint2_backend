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
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("employee")
public class EmployeeRestController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private AccountService accountService;

    // HauHP
    @PostMapping(value = "create")
    public ResponseEntity<String> createEmployee(@RequestBody @Valid EmployeeDto employeeDto, BindingResult bindingResult) {
        List<Account> accountList = accountService.getAccountList();
        // check username exist
        for (Account value : accountList) {
            if (value.getUsername().equals(employeeDto.getAccountDto().getUsername())) {
                return new ResponseEntity<>("exist username",HttpStatus.BAD_REQUEST);
            }
        }
        if (bindingResult.hasErrors()){
            return new ResponseEntity<>("error validate",HttpStatus.BAD_REQUEST);
        }
        this.employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>("ok",HttpStatus.CREATED);
    }

    // HauHP
    @GetMapping("{id}")
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
    @PatchMapping("edit")
    public ResponseEntity<Void> editEmployee(@RequestBody @Valid EmployeeDto employeeDto, BindingResult bindingResult) {
        this.employeeService.editEmployee(employeeDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
