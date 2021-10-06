package c0321g1_pawnshop_backend.dto.customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerDto {
    private Long customerId;
    private String customerCode;
    private String name;
    private String idCard;
    private int flag;
    private String phone;
    private String image;
    private String email;
    private String address;
    private String birthDate;
    private GenderDto gender;
}
