package c0321g1_pawnshop_backend.dto.contract;

import c0321g1_pawnshop_backend.dto.customer.CustomerDto;
import c0321g1_pawnshop_backend.entity.contract.PeriodContract;
import c0321g1_pawnshop_backend.entity.contract.StatusContract;
import c0321g1_pawnshop_backend.entity.contract.TypeContract;
import c0321g1_pawnshop_backend.entity.contract.TypeProduct;
import c0321g1_pawnshop_backend.entity.customer.Customer;
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
    private PeriodContractDto periodContract;
    private CustomerDto customer;
    private TypeProductDto typeProduct;
    private TypeContractDto typeContract;

}
