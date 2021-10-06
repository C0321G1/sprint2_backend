package c0321g1_pawnshop_backend.repository.contract;

import c0321g1_pawnshop_backend.entity.contract.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ContractRepository extends JpaRepository<Contract,Long> {

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
}
