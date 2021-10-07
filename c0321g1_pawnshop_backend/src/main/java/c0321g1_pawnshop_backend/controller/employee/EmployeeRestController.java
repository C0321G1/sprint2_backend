package c0321g1_pawnshop_backend.controller.employee;

import c0321g1_pawnshop_backend.entity.employee.Employee;
import c0321g1_pawnshop_backend.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value="employee")
public class EmployeeRestController {
    @Autowired
    private EmployeeService employeeService;

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
