package c0321g1_pawnshop_backend.service_impl.employee;

import c0321g1_pawnshop_backend.entity.employee.Employee;
import c0321g1_pawnshop_backend.repository.employee.EmployeeRepository;
import c0321g1_pawnshop_backend.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    //Creator: Nhung
    @Override
    public List<Employee> listEmployee() {
        return employeeRepository.listEmployee();
    }
}
