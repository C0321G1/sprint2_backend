package c0321g1_pawnshop_backend.dto.security;

import c0321g1_pawnshop_backend.dto.employee.EmployeeDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {
    private Long accountId;
    private String password;
    private String username;
    private String userTime;
    private EmployeeDto employee;
}
