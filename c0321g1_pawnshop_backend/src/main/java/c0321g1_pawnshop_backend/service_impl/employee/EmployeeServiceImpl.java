package c0321g1_pawnshop_backend.service_impl.employee;

import c0321g1_pawnshop_backend.dto.employee.EmployeeDto;
import c0321g1_pawnshop_backend.entity.employee.Employee;
import c0321g1_pawnshop_backend.repository.employee.EmployeeRepository;
import c0321g1_pawnshop_backend.repository.security.AccountRepository;
import c0321g1_pawnshop_backend.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    @Autowired
    private EmployeeRepository employeeRepository;

    //Creator: Nhung
    @Override
    public List<Employee> listEmployee() {
        return employeeRepository.listEmployee();
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return employeeRepository.findEmployeeById(id);
    }

    @Override
    public void editEmployee(EmployeeDto employeeDto) {
        Optional<Employee> employee = findById(employeeDto.getEmployeeId());

        if (!employee.get().getAccount().getPassword().equals(employeeDto.getAccountDto().getPassword())) {
            String passEncode = passwordEncoder.encode(employeeDto.getAccountDto().getPassword());
            accountRepository.editAccount(employeeDto.getAccountDto().getUsername(),passEncode,employeeDto.getAccountDto().getAccountId());
        }
//        accountRepository.saveQuery(account.getUsername(), passEncode, null);
        employeeRepository.editEmployee(employeeDto.getAddress(), employeeDto.getBirthDate(),
                employeeDto.getEmail(),employeeDto.getEmployeeCode(),employeeDto.getFlag(),
                employeeDto.getIdCard(), employeeDto.getImage(), employeeDto.getName(),
                employeeDto.getPhone(), employeeDto.getSalary(), employeeDto.getAccountDto().getAccountId(),
                employeeDto.getGenderDto().getGenderId(), employeeDto.getEmployeeId());
    }
}
