package c0321g1_pawnshop_backend.dto.contract;

import c0321g1_pawnshop_backend.dto.customer.CustomerDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ContractDto {
    private Long contractId;
    private String contractCode;
    private String startDate;
    private String endDate;
    private String dateLiquidation;
    private int flag;
    private String productName;
    private String productImage;
    private int totalMoney;
    private int loan;
    private int profit;
    private StatusContractDto statusContract;
    private CustomerDto customer;
    private TypeProductDto typeProduct;
    private TypeContractDto typeContract;
}
