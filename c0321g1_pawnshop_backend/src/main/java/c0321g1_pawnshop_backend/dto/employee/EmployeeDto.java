package c0321g1_pawnshop_backend.dto.employee;

import c0321g1_pawnshop_backend.dto.customer.GenderDto;
import c0321g1_pawnshop_backend.dto.security.AccountDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private Long employeeId;
    private String salary;
    private String idCard;
    private String name;
    private String employeeCode;
    private String birthDate;
    private String address;
    private String email;
    private String image;
    private String phone;
    private int flag;
    private AccountDto account;
    private GenderDto gender;
}
