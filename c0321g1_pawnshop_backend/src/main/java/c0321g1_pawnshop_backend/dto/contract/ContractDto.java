package c0321g1_pawnshop_backend.dto.contract;

import c0321g1_pawnshop_backend.dto.customer.CustomerDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ContractDto {
    private Long contractId;
    @NotEmpty
    @Pattern(regexp = "^HD-\\d{4}$")
    private String contractCode;

    @NotEmpty
    private String startDate;

    @NotEmpty
    private String endDate;

    private String dateLiquidation;
    private int flag;

    @NotEmpty
    @Size(min = 6, max = 50)
    private String productName;

    private String productImage;
    private int totalMoney;

    @NotNull
    @Min(50000)
    @Max(1000000000)
    private int loan;

    private int profit;
    private StatusContractDto statusContract;
    private CustomerDto customer;
    private TypeProductDto typeProduct;
    private TypeContractDto typeContract;
}
