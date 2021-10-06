package c0321g1_pawnshop_backend.controller.employee;

import c0321g1_pawnshop_backend.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping
public class EmployeeRestController {
    @Autowired
    private EmployeeService employeeService;
}
