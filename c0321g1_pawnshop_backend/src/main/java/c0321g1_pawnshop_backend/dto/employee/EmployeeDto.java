package c0321g1_pawnshop_backend.dto.employee;

import c0321g1_pawnshop_backend.dto.customer.GenderDto;
import c0321g1_pawnshop_backend.dto.security.AccountDto;
import c0321g1_pawnshop_backend.entity.customer.Gender;
import c0321g1_pawnshop_backend.entity.security.Account;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private Long employeeId;
    @NotEmpty
    @Min(1)
    @NotNull
    private String salary;
    @NotEmpty
    @NotNull
    private String idCard;
    @NotEmpty
    private String name;
    @NotEmpty
    private String employeeCode;
    @NotEmpty
    private String birthDate;
    @NotEmpty
    private String address;
    @NotEmpty
    @Email
    private String email;
    private String image;
    @NotEmpty
    private String phone;
    private Long flag;
    private AccountDto accountDto;
    private GenderDto genderDto;
}
