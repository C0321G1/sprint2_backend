package c0321g1_pawnshop_backend.controller.employee;

import c0321g1_pawnshop_backend.dto.employee.EmployeeDto;
import c0321g1_pawnshop_backend.entity.employee.Employee;
import c0321g1_pawnshop_backend.entity.security.Account;
import c0321g1_pawnshop_backend.service.employee.EmployeeService;
import c0321g1_pawnshop_backend.service.security.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
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
    public Map<String, Object> createEmployee(@RequestBody @Valid EmployeeDto employeeDto, BindingResult bindingResult) {
//        List<Account> accountList = accountService.getAccountList();
//        // check username exist
//        for (Account value : accountList) {
//            if (value.getUsername().equals(employeeDto.getAccountDto().getUsername())) {
//                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//            }
//        }
//        if (bindingResult.hasErrors()){
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//        this.employeeService.saveEmployee(employeeDto, bindingResult);
        return this.employeeService.saveEmployee(employeeDto, bindingResult);
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
        List<Account> accountList = accountService.getAccountList();
        int dem = 0;
        // check username exist
        for (Account value : accountList) {
            if (value.getUsername().equals(employeeDto.getAccountDto().getUsername())) {
                dem++;
            }
        }
        if(dem==0){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.employeeService.editEmployee(employeeDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //ly huynh

    @GetMapping(value = "/list")
    public ResponseEntity<Page<Employee>> findAllEmployees(@PageableDefault(value = 5) Pageable pageable) {
        try {
            Page<Employee> employeePage = employeeService.findAllEmployee(pageable);
            if (employeePage.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(employeePage, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping(value = "/listAddress")
    public ResponseEntity<List<String>> findAllAddressEmployees() {
        try {
            List<String> addressList = employeeService.findAllListAddresss();
            if (addressList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(addressList, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping(value = "/search")
    public ResponseEntity<Page<Employee>> searchEmployees(@PageableDefault(value = 5) Pageable pageable,
                                                          Optional<String> name,
                                                          Optional<String> phone,
                                                          Optional<String> address) {
        try {
            String keyName = name.orElse("").trim();
            String keyPhone = phone.orElse("").trim();
            String keyAdress = address.orElse("").trim();
            Page<Employee> employeePage = employeeService.searchEmployeeByNamePhoneAddress(pageable, keyName, keyPhone, keyAdress);
            if (employeePage.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(employeePage, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

//    @GetMapping(value = "/{id}")
//    public ResponseEntity<Employee> findEmployeeById(@PathVariable Long id) {
//        try {
//            Optional<Employee> optionalEmployee = employeeService.findEmployeeById(id);
//            if (!optionalEmployee.isPresent()) {
//                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//            }
//            return new ResponseEntity<>(optionalEmployee.get(), HttpStatus.OK);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Void> deleteEmployeeById(@PathVariable Long id) {
        try {
            Optional<Employee> optionalEmployee = employeeService.findById(id);
            if (!optionalEmployee.isPresent()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            employeeService.deleteEmployee(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    // thuy
    @PatchMapping("edit-infor")
    public ResponseEntity<Void> editEmployeeInfo(@RequestBody @Valid EmployeeDto employeeDto, BindingResult bindingResult) {
        this.employeeService.editEmployeeInfor(employeeDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //Creator: Nhung
    @GetMapping("listEmployee")
    public ResponseEntity<List<Employee>> getListEmployee() {
        List<Employee> employeeList = employeeService.listEmployee();
        if (employeeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }
}
