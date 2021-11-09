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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

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
    public Map<String, Object> saveEmployee(EmployeeDto employeeDto, BindingResult bindingResult) {
        Map<String, Object> result = new HashMap<>();

        List<String> errors = new ArrayList<>();
        boolean isError = false;
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(ob -> {
                errors.add(ob.getDefaultMessage());
            });
            result.put("status", false);
            result.put("msg", "Add new employee failed.");
            result.put("errors", errors);
            isError = true;
        }
        if (checkCode(employeeDto)) {
            result.put("status", false);
            result.put("msgExistCode", "Mã nhân viên đã tồn tại, vui lòng nhập lại");
            isError = true;
        }
        if (checkUsername(employeeDto)) {
            result.put("status", false);
            result.put("msgExistUsername", "Tên đăng nhập đã tồn tại, vui lòng nhập lại");
            isError = true;
        }
        if (isError) {
            return result;
        }

        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);

        Account account = new Account();
        AccountDto accountDto = employeeDto.getAccountDto();

        BeanUtils.copyProperties(accountDto, account);

        account.setAccountId(initAccountId(account));
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        accountRepository.saveAccount(employeeDto.getAccountDto().getUsername(), account.getPassword());
        accountDto.setAccountId(this.initAccountId(account));
        roleRepository.saveRole(this.initAccountId(account));
        employeeRepository.saveEmployee(employeeDto.getAddress(), employeeDto.getBirthDate(),
                employeeDto.getEmail(), employeeDto.getEmployeeCode(), employeeDto.getFlag(),
                employeeDto.getIdCard(), employeeDto.getImage(), employeeDto.getName(),
                employeeDto.getPhone(), employeeDto.getSalary(), this.initAccountId(account),
                employeeDto.getGenderDto().getGenderId());
        result.put("status", true);
        result.put("msg", "Tạo mới thành công !");
        return result;
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return employeeRepository.findEmployeeById(id);
    }

    @Override
    public void editEmployee(EmployeeDto employeeDto) {
        employeeDto.getAccountDto().setPassword(passwordEncoder.encode(employeeDto.getAccountDto().getPassword()));
        accountRepository.editAccount(employeeDto.getAccountDto().getUsername(), employeeDto.getAccountDto().getPassword(), employeeDto.getAccountDto().getAccountId());
        employeeRepository.editEmployee(employeeDto.getAddress(), employeeDto.getBirthDate(),
                employeeDto.getEmail(), employeeDto.getEmployeeCode(), employeeDto.getFlag(),
                employeeDto.getIdCard(), employeeDto.getImage(), employeeDto.getName(),
                employeeDto.getPhone(), employeeDto.getSalary(), employeeDto.getAccountDto().getAccountId(),
                employeeDto.getGenderDto().getGenderId(), employeeDto.getEmployeeId());
    }

    private boolean checkCode(EmployeeDto employeeDto) {
        List<Employee> employeeList = employeeRepository.findAll();
        for (Employee e : employeeList) {
            if (employeeDto.getEmployeeCode().equals(e.getEmployeeCode())) {
                return true;
            }
        }
        return false;
    }

    private boolean checkUsername(EmployeeDto employeeDto) {
        List<Employee> employeeList = employeeRepository.findAll();
        for (Employee e : employeeList) {
            if (employeeDto.getAccountDto().getUsername().equals(e.getAccount().getUsername())) {
                return true;
            }
        }
        return false;
    }

    //ly huynh

    @Override
    public Page<Employee> findAllEmployee(Pageable pageable) {
        return employeeRepository.findAllEmployee(pageable);
    }

    @Override
    public List<String> findAllListAddresss() {
        return employeeRepository.findAllListEmployee();
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteEmployee(id);
    }

//    @Override
//    public Optional<Employee> findEmployeeById(Long id) {
//        return employeeRepository.findEmployeeById(id);
//    }

    @Override
    public Page<Employee> searchEmployeeByNamePhoneAddress(Pageable pageable, String name, String phone, String address) {
        return employeeRepository.searchEmployeeByNamePhoneAddress(pageable, "%" + name + "%", "%" + phone + "%", "%" + address + "%");
    }
    @Override
    public void editEmployeeInfor(EmployeeDto employeeDto) {
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

    //Creator: Nhung
    @Override
    public List<Employee> listEmployee() {
        return employeeRepository.listEmployee();
    }
}
