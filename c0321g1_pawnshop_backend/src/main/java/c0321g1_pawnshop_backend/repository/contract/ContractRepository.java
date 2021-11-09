package c0321g1_pawnshop_backend.repository.contract;

import c0321g1_pawnshop_backend.entity.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

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
            "from contract " +
            "where type_contract_id=1 and flag=1 and end_date<curdate() and status_id=1", nativeQuery = true)
    Page<Contract> findProductLiquidation(Pageable pageable);

    /* Long*/
    @Query(value = "select * from contract where contract_code=?1", nativeQuery = true)
    Contract searchContractByCode(String contractCode);

    /*long*/
    @Query(value = "select * from contract where contract.contract_id =?1", nativeQuery = true)
    Contract getContractById(Long id);

    /*long*/
    @Query(value = "select * from contract " +
            "inner join type_product on contract.type_product_id = type_product.type_product_id" +
            " where (type_contract_id=1 and flag=1 and end_date<curdate() and status_id=1 and (product_name like %?1%) " +
            " and (type_product.name like %?2%) and loan<=?3)", nativeQuery = true)
    Page<Contract> searchContractLiquidation(String nameProduct, String nameTypeProduct, Integer loan, Pageable pageable);

    /*long*/
    @Modifying
    @Transactional
    @Query(value = "update contract" +
            " set status_id = ?2 where contract_id =?1", nativeQuery = true)
    Integer setStatusById(Long id, Long statusId);


    /*long*/
    @Modifying
    @Transactional
    @Query(value =  " update contract" +
            " set date_liquidation=?1,total_money=?2,customer_id=?3,status_id=3,type_contract_id=2" +
            " where contract_id=?4", nativeQuery = true)
    Integer upDateLiquidationContract(String dateLiquidation, int totalMoney, Long customerId, Long contractId);

    //Linh code
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO contract (contract_code, start_date, end_date," +
            "product_name, product_image, loan, profit," +
            "customer_id, type_product_id, status_id, type_contract_id, flag, date_liquidation, total_money)" +
            "VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9, ?10, ?11, ?12, ?13, ?14)", nativeQuery = true)
    void saveContract(String contractCode, String startDate, String endDate, String productName, String productImage, int loan, int profit, Long customerId, Long typeProductId, Long statusId, Long typeContractId, int flag, String dateLiquidation, int totalMoney);

    //Linh code
    @Query(value = "select * from contract", nativeQuery = true)
    List<Contract> getContractList();

    //    creator: vinhdn. Get list contract

    @Query(value = "select * from `contract` where type_contract_id = ?1 and status_id=1", nativeQuery = true)
    Page<Contract> getListContract(Pageable pageable, int type_contract_id);

    //    creator: vinhdn. search contract
    @Query(value = "select c.*,cus.name,cus.email from `contract` as c join customer as cus " +
            "on c.customer_id = cus.customer_id where" +
            "`c`.contract_code like %?1% and cus.name like %?2% and " +
            "`c`.product_name like %?3% and `c`.start_date like %?4% and c.type_contract_id = ?5 and c.status_id=1" +
            "order by c.contract_id asc",
            nativeQuery = true)
    Page<Contract> searchContract(Pageable pageable, String contractCode,
                                  String customerName, String productName, String startDate, int type_contract_id);

    //    creator: vinhdn. payment contract
    @Modifying
    @Transactional
    @Query(value = "update contract set status_id=?1,total_money = ?2 where contract_id = ?3", nativeQuery = true)
    void paymentContract(int statusId, int totalMoney, Long contractId);

//vu code
//vu code
@Query(value = "SELECT * from  contract\n" +
        " inner join customer on customer.customer_id = contract.customer_id" +
        " inner join status_contract on status_contract.status_id = contract.status_id" +
        " inner join type_contract on type_contract.type_contract_id = contract.type_contract_id " +
        " where ((customer.name like %?1%) " +
        "  and ( contract.product_name like %?2%) " +
        "  and ( status_contract.name like %?3%)" +
        "  and ( type_contract.name like %?4%)) " +
        "  and (contract.start_date between ?5 and ?6) and contract.flag = 1", nativeQuery = true)

Page<Contract> searchContractHistory(String customer, String productName, String statusContract, String typeContract, String startDateFrom, String startDateTo, Pageable pageable);
    @Transactional
    @Modifying
    @Query(value = "update contract " +
            "set flag = 0 " +
            "where contract_id =?1 ", nativeQuery = true)
    void deleteContract(Long id);

    @Query(value = "select * from contract " +
            "where flag = 1 ", nativeQuery = true)
    Page<Contract> getListContractHistory(Pageable pageable);

//khanh code

    @Query(value = "SELECT * from contract" +
            " join customer on customer.customer_id =contract.customer_id " +
            "join type_contract on type_contract.type_contract_id = contract.type_contract_id" +
            " join status_contract on status_contract.status_id = contract.status_id " +
            "where contract.contract_id =?1", nativeQuery = true)
    Contract findByContractId(Long id);

    @Query(value = " select * from contract where flag =1 order by start_date desc limit 10;", nativeQuery = true)
    List<Contract> page10Contract();

    @Query(value = "select email from contract join customer on customer.customer_id = contract.customer_id  where DATE(contract.end_date)  = curdate()+1;", nativeQuery = true)
    List<String> getAllEmailToSend();

    @Query(value = "select * from contract " +
            "join customer on customer.customer_id = contract.customer_id " +
            "join status_contract on status_contract.status_id =contract.status_id " +
            "where customer.name like %?1% and status_contract.name like %?2%" +
            " order by start_date desc limit 10", nativeQuery = true)
    List<Contract> searchTenContract(String customer, String statusContract);
}
