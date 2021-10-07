package c0321g1_pawnshop_backend.entity.contract;

import c0321g1_pawnshop_backend.entity.customer.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne
    @JoinColumn(name = "statusId",referencedColumnName = "statusId")
    private StatusContract statusContract;

    @ManyToOne
    @JoinColumn(name = "customerId",referencedColumnName = "customerId")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "typeProductId",referencedColumnName = "typeProductId")
    private TypeProduct typeProduct;

    @ManyToOne
    @JoinColumn(name = "typeContractId",referencedColumnName = "typeContractId")
    private TypeContract typeContract;

}
