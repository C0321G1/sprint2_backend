package c0321g1_pawnshop_backend.repository.contract;

import c0321g1_pawnshop_backend.entity.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    /* Long*/
    @Query(value = "select *\n" +
            "from contract\n" +
            "where type_contract_id=1 and flag=1 and end_date<curdate()", nativeQuery = true)
    Page<Contract> findProductLiquidation(Pageable pageable);

    /* Long*/
    @Query(value="select * from contract where contract_code=?1", nativeQuery = true)
    Contract searchContractByCode(String contractCode);

    /*long*/
    @Query(value="select * from contract where contract_id = ?;",nativeQuery = true)
    Contract getContractById(Long contractId);

    /*long*/
    @Query(value="select *\n" +
            "from contract inner join type_product on contract.type_product_id = type_product.type_product_id\n" +
            "where type_contract_id=1 and flag=1 and end_date<curdate() and product_name like %?1% \n" +
            "and loan<=?2 and type_product.name like %?3%;",nativeQuery=true)
    Page<Contract> searchContractLiquidation(String productName,String loan,String nameTypeProduct,Pageable pageable);
}
