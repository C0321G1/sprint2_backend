package c0321g1_pawnshop_backend.repository.contract;

import c0321g1_pawnshop_backend.entity.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Long> {
    //vu code
    @Query(value = "SELECT  contract.*,customer.*,status_contract.*,type_contract.* from  contract" +
            " join customer on customer.customer_id = contract.customer_id" +
            " join status_contract on status_contract.status_id = contract.status_id" +
            " join type_contract on type_contract.type_contract_id = contract.type_contract_id " +
            "where customer.name like %?1% and status_contract.name" +
            " like %?2% and type_contract.name" +
            " like %?3% and contract.product_name " +
            "like %?4% and (contract.start_date between ?5 and ?6) and flag =1", nativeQuery = true)
    Page<Contract> searchContract(Pageable pageable, String customer, String statusContract, String typeContract, String productName, String startDateForm, String startDateTo);

    @Transactional
    @Modifying
    @Query(value = "update contract " +
            "set flag = 0 " +
            "where contract_id =?1 ", nativeQuery = true)
    void deleteContract(Long contractId);

    @Query(value = "select * from contract " +
            "where flag = 0 ", nativeQuery = true)
    Page<Contract> getListContract(Pageable pageable);

    //khanh code
    @Query(value = "select * from contract " +
            "join customer on customer.customer_id = contract.customer_id " +
            "join status_contract on status_contract.status_id =contract.status_id " +
            "where customer.name like %?1% and status_contract.status_id like %?2%" +
            " order by start_date desc limit 10", nativeQuery = true)
    Page<Contract> searchTenContract(Pageable pageable, String customer, String statusContract);


    @Query(value = "SELECT contract.contract_id, customer.name, contract.product_name,contract.loan,contract.profit,contract.start_date,contract.end_date,type_contract.nane,status_contract.name " +
            "from contract" +
            " join customer on customer.customer_id =contract.customer_id " +
            "join type_contract on type_contract.type_contract_id = contract.type_contract_id" +
            " join status_contract on status_contract.status_id = contract.status_id " +
            "where contract.contract_id =?1", nativeQuery = true)
    Contract findByContractId(Long contractId);
}
