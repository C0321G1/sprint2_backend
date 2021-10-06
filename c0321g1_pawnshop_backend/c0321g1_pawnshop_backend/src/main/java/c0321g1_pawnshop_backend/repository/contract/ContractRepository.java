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

//    creator: vinhdn. Get list contract

    @Query(value = "select * from `contract`", nativeQuery = true)
    Page<Contract> getListContract(Pageable pageable);

    //    creator: vinhdn. search contract
    @Query(value = "select * from `contract` join `customer` " +
            "on `contract`.customer_id = `customer`.customer_id where" +
            "`contract`.contract_code like %?1% and `customer`.name like %?2% and " +
            "`contract`.product_name like %?3% and `contract`.start_date like %?4%",
            nativeQuery = true)
    Page<Contract> searchContract(Pageable pageable, String contractCode,
                                  String customerName, String productName, String startDate);

    //    creator: vinhdn. payment contract
    @Modifying
    @Transactional
    @Query(value = "update contract set type_contract_id = 2,total_money = ?1 where contract_id = ?2", nativeQuery = true)
    void paymentContract(int totalMoney, Long contractId);
}
