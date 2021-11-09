package c0321g1_pawnshop_backend.dto.contract;

import c0321g1_pawnshop_backend.dto.customer.CustomerDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ContractDtoLiquid implements Validator {
    private Long contractId;
    private String contractCode;
    private String startDate;
    private String endDate;
    @NotBlank(message = "Ngày thanh lý không để trống!")
    private String dateLiquidation;
    private int flag;
    private String productName;
    private String productImage;
    @NotNull(message = "Tổng tiền không để trống!")
    @Max(value = 9999999, message = "Chiều dài kí tự nhỏ hơn 9 ")
    private int totalMoney;
    private int loan;
    private int profit;
    private StatusContractDto statusContract;
    private CustomerDto customer;
    private TypeProductDto typeProduct;
    private TypeContractDto typeContract;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ContractDtoLiquid contractDtoLiquid = (ContractDtoLiquid) target;
        LocalDate dateNow = LocalDate.now();
        LocalDate dateLiquid = LocalDate.parse(contractDtoLiquid.dateLiquidation);
        if (dateLiquid.compareTo(dateNow) != 0) {
            errors.rejectValue("dateLiquidation", "dateLiquidation.notMulti",
                    "Date liquidation not valid");
        }
        if (contractDtoLiquid.totalMoney <= contractDtoLiquid.loan) {
            errors.rejectValue("totalMoney", "totalMoney.loan",
                    "Total money must > loan");
        }
    }
}
