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
public class ContractEditDto {
    private Long contractId;
    @NotEmpty
    private String startDate;

    @NotEmpty
    private String endDate;

    @NotEmpty
    @Size(min = 6, max = 50)
    private String productName;

    @NotNull
    @Min(50000)
    @Max(1000000000)
    private int loan;
    private int profit;
    private StatusContractDto statusContract;
    private CustomerDto customer;
    private TypeContractDto typeContract;
}
