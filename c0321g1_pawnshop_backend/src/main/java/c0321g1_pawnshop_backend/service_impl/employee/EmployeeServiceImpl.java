package c0321g1_pawnshop_backend.service_impl.employee;

import c0321g1_pawnshop_backend.dto.employee.EmployeeDto;
import c0321g1_pawnshop_backend.dto.security.AccountDto;
import c0321g1_pawnshop_backend.entity.employee.Employee;
import c0321g1_pawnshop_backend.entity.security.Account;
import c0321g1_pawnshop_backend.repository.employee.EmployeeRepository;
import c0321g1_pawnshop_backend.repository.security.AccountRepository;
import c0321g1_pawnshop_backend.repository.security.RoleRepository;
import c0321g1_pawnshop_backend.service.employee.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private RoleRepository roleRepository;

    private Long initAccountId(Account account) {
        List<Account> accountList = accountRepository.getAccountList();
        for (Account value : accountList) {
            if (value.getUsername().equals(account.getUsername())) {
                return value.getAccountId();
            }
        }
        return null;
    }

    @Override
    public void saveEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        Account account = new Account();
        AccountDto accountDto = employeeDto.getAccountDto();
        BeanUtils.copyProperties(employeeDto, employee);
        BeanUtils.copyProperties(accountDto, account);
        account.setAccountId(initAccountId(account));
        accountRepository.saveAccount(employeeDto.getAccountDto().getUsername(),employeeDto.getAccountDto().getPassword());
        accountDto.setAccountId(this.initAccountId(account));
        roleRepository.saveRole(this.initAccountId(account));
        employeeRepository.saveEmployee(employeeDto.getAddress(), employeeDto.getBirthDate(),
                employeeDto.getEmail(),employeeDto.getEmployeeCode(),employeeDto.getFlag(),
                employeeDto.getIdCard(), employeeDto.getImage(), employeeDto.getName(),
                employeeDto.getPhone(), employeeDto.getSalary(), account.getAccountId(),
                employeeDto.getGenderDto().getGenderId());
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return employeeRepository.findEmployeeById(id);
    }

    @Override
    public void editEmployee(EmployeeDto employeeDto) {
        accountRepository.editAccount(employeeDto.getAccountDto().getUsername(),employeeDto.getAccountDto().getPassword(),employeeDto.getAccountDto().getAccountId());
        employeeRepository.editEmployee(employeeDto.getAddress(), employeeDto.getBirthDate(),
                employeeDto.getEmail(),employeeDto.getEmployeeCode(),employeeDto.getFlag(),
                employeeDto.getIdCard(), employeeDto.getImage(), employeeDto.getName(),
                employeeDto.getPhone(), employeeDto.getSalary(), employeeDto.getAccountDto().getAccountId(),
                employeeDto.getGenderDto().getGenderId(), employeeDto.getEmployeeId());
    }
}
