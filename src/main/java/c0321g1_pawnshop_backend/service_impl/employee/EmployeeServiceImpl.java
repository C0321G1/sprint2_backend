package c0321g1_pawnshop_backend.service_impl.employee;

import c0321g1_pawnshop_backend.dto.employee.EmployeeDto;
import c0321g1_pawnshop_backend.entity.employee.Employee;
import c0321g1_pawnshop_backend.repository.employee.EmployeeRepository;
import c0321g1_pawnshop_backend.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.saveEmployee(employee.getAddress(), employee.getBirthDate(),
                employee.getEmail(),employee.getEmployeeCode(),employee.getFlag(),
                employee.getIdCard(), employee.getImage(), employee.getName(),
                employee.getPhone(), employee.getSalary(), employee.getAccount().getAccountId(),
                employee.getGender().getGenderId());
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return employeeRepository.findEmployeeById(id);
    }

    @Override
    public void editEmployee(Employee employee) {
        employeeRepository.editEmployee(employee.getAddress(), employee.getBirthDate(),
                employee.getEmail(),employee.getEmployeeCode(),employee.getFlag(),
                employee.getIdCard(), employee.getImage(), employee.getName(),
                employee.getPhone(), employee.getSalary(), employee.getAccount().getAccountId(),
                employee.getGender().getGenderId(), employee.getEmployeeId());
    }
}
