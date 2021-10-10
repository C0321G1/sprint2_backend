package c0321g1_pawnshop_backend.repository.contract;

import c0321g1_pawnshop_backend.entity.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ContractRepository extends JpaRepository<Contract,Long> {
    //vu code
//    @Query(value = "SELECT contract.* , customer from  contract" +
//            " inner join customer on customer.customer_id = contract.customer_id" +
//            " inner join status_contract on status_contract.status_id = contract.status_id" +
//            " inner join type_contract on type_contract.type_contract_id = contract.type_contract_id " +
//            "where ((customer.name <> '' and customer.name like ?1) " +
//            " and (contract.product_name <> ''and contract.product_name like ?2)" +
//            " and (status_contract.name <> '' and status_contract.name like ?3)" +
//            " and (type_contract.name <> '' and type_contract.name like ?4) " +
//            " ) and (contract.flag = 1 )", nativeQuery = true)
    @Query(value = "SELECT * from  contract\n" +
            "             inner join customer on customer.customer_id = contract.customer_id" +
            "             inner join status_contract on status_contract.status_id = contract.status_id" +
            "             inner join type_contract on type_contract.type_contract_id = contract.type_contract_id " +
            "            where (customer.name like ?1)" +
            "            and ( contract.product_name like ?2)" +
            "            and ( status_contract.name like ?3)" +
            "            and ( type_contract.name like ?4) " +
            "and contract.flag = 1", nativeQuery = true)


    Page<Contract> searchContract( String customer,String productName, String statusContract, String typeContract,Pageable pageable);

    @Transactional
    @Modifying
    @Query(value = "update contract " +
            "set flag = 0 " +
            "where contract_id =?1 ", nativeQuery = true)
    void deleteContract(Long id);

    @Query(value = "select * from contract " +
            "where flag = 1 ", nativeQuery = true)
    Page<Contract> getListContract(Pageable pageable);

    //khanh code
    @Query(value = "select * from contract " +
            "join customer on customer.customer_id = contract.customer_id " +
            "join status_contract on status_contract.status_id =contract.status_id " +
            "where customer.name like %?1% and status_contract.name like %?2%" +
            " order by start_date desc limit 10", nativeQuery = true)
    List<Contract> searchTenContract( String customer, String statusContract);


    @Query(value = "SELECT * from contract" +
            " join customer on customer.customer_id =contract.customer_id " +
            "join type_contract on type_contract.type_contract_id = contract.type_contract_id" +
            " join status_contract on status_contract.status_id = contract.status_id " +
            "where contract.contract_id =?1", nativeQuery = true)
    Contract findByContractId(Long id);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO contract ( start_date, end_date," +
            "product_name,loan,profit," +
            "customer_id,status_id, type_contract_id)" +
            "VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8)", nativeQuery = true)
    void updateContract( String startDate, String endDate, String productName, int loan, int profit, Long customerId, Long statusId, Long typeContractId);

    @Query(value= " select * from contract where flag =1 order by start_date desc limit 10;", nativeQuery=true)
    List<Contract> page10Contract();
}
//countQuery = " select count(*)from contract where flag =1 order by start_date desc limit ?1,10;