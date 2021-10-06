package c0321g1_pawnshop_backend.repository.contract;

import c0321g1_pawnshop_backend.entity.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface ContractRepository extends JpaRepository<Contract, Long> {

   /* Long*/
    @Modifying
    @Query(value = "insert into contract (contract_code,product_name,customer_id,date_liquidation,\n" +
            "type_contract_id,status_id,flag,total_money,loan,profit)\n" +
            "values (:contractCode,:productName,:customerId,:dateLiquidation,:typeContractId,:statusId," +
            ":flag,:totalMoney,:loan,:profit);", nativeQuery = true)
    @Transactional
    Integer createLiquidateContract(@Param("contractCode") String contractCode,
                                    @Param("productName") String productName,
                                    @Param("customerId") Long customerId,
                                    @Param("dateLiquidation") String dateLiquidation,
                                    @Param("typeContractId") Long typeContractId,
                                    @Param("statusId") Long statusId,
                                    @Param("flag") int flag,
                                    @Param("totalMoney") int totalMoney,
                                    @Param("loan") int loan,
                                    @Param("profit") int profit);

    @Query(value = "select product_name,type_product_id,loan\n" +
            "from contract\n" +
            "where type_contract_id=1 and flag=1 and end_date<curdate()", nativeQuery = true)
    Page<Contract> findProductLiquidation();

}
