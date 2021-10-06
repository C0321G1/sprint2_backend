package c0321g1_pawnshop_backend.service.employee;

import c0321g1_pawnshop_backend.entity.employee.Employee;
import c0321g1_pawnshop_backend.repository.employee.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Optional<Employee> findById(Long id) {
        return employeeRepository.findByIdEmployee(id);
    }
}
