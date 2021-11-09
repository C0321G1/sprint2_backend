package c0321g1_pawnshop_backend.dto.customer;

import c0321g1_pawnshop_backend.entity.customer.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerDto implements Validator {
    private Long customerId;
    @NotEmpty(message = "Vui lòng nhập mã khách hàng.")
    @Pattern(regexp = "^KH-[0-9]*$", message = "Nhập không đúng định dạng.")
    private String customerCode;
    @NotEmpty(message = "Vui lòng nhập tên khách hàng.")
    private String name;
    @NotEmpty(message = "Vui lòng nhập CMND khách hàng.")
    private String idCard;
    private int flag;
    @NotEmpty(message = "Vui lòng nhập số điện thoại khách hàng.")
    private String phone;
    @NotEmpty(message = "Vui lòng chọn ảnh khách hàng.")
    private String image;
    @NotEmpty(message = "Vui lòng nhập email khách hàng.")
    private String email;
    @NotEmpty(message = "Vui lòng nhập địa chỉ khách hàng.")
    private String address;
    @NotEmpty(message = "Vui lòng nhập ngày sinh khách hàng.")
    private String birthDate;
    private Gender gender;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }



}