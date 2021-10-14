package c0321g1_pawnshop_backend.dto.contract;

import c0321g1_pawnshop_backend.entity.contract.StatusContract;
import c0321g1_pawnshop_backend.entity.contract.TypeContract;
import c0321g1_pawnshop_backend.entity.contract.TypeProduct;
import c0321g1_pawnshop_backend.entity.customer.Customer;
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
    private String contractCode;
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
    private StatusContract statusContract;
    private Customer customer;
    private TypeProduct typeProduct;
    private TypeContract typeContract;
}
