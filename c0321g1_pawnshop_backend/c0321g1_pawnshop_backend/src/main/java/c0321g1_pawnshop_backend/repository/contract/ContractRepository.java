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

    @Query(value = "select * from `contract` where flag = ?1", nativeQuery = true)
    Page<Contract> getListContract(Pageable pageable, int flag);

    //    creator: vinhdn. search contract
    @Query(value = "select c.*,cus.name,cus.email from `contract` as c join customer as cus " +
            "on c.customer_id = cus.customer_id where" +
            "`c`.contract_code like %?1% and cus.name like %?2% and " +
            "`c`.product_name like %?3% and `c`.start_date like %?4% and c.flag = ?5 " +
            "order by c.contract_id asc",
            nativeQuery = true)
    Page<Contract> searchContract(Pageable pageable, String contractCode,
                                  String customerName, String productName, String startDate, int flag);

    //    creator: vinhdn. payment contract
    @Modifying
    @Transactional
    @Query(value = "update contract set flag = ?1,total_money = ?2 where contract_id = ?3", nativeQuery = true)
    void paymentContract(int flag, int totalMoney, Long contractId);
}
