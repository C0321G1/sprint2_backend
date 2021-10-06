package c0321g1_pawnshop_backend.repository.statictis;

import c0321g1_pawnshop_backend.entity.contract.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StatisticRepository extends JpaRepository<Contract,Long> {
    @Query(value = " select * from contract ct  join status st on ct.status_id = st.status_id" +
            " join customer ctm on ct.customer_id = ctm.customer_id" +
            " join type_contract tct on ct.type_contract_id = tct.type_contract_id " +
            " join type_product tpd on ct.type_product_id = tpd.type_product_id" +
            " where (ct.start_date >= #?1# or ct.end_date <= #?2#) and ct.flag = 1 " , nativeQuery = true)
    List<Contract> listStatisticInterest(String startDate,String endDate);

    @Query(value = " select * from contract ct  join status st on ct.status_id = st.status_id" +
            " join customer ctm on ct.customer_id = ctm.customer_id" +
            " join type_contract tct on ct.type_contract_id = tct.type_contract_id " +
            " join type_product tpd on ct.type_product_id = tpd.type_product_id" +
            " where (ct.date_liquidation >= #?1# or ct.date_liquidation <= #?2#) and ct.flag = 1 " , nativeQuery = true)
    List<Contract> listStatisticLiquidation(String startDate,String endDate);


    @Query(value = " select * from contract ct  join status st on ct.status_id = st.status_id" +
            " join customer ctm on ct.customer_id = ctm.customer_id" +
            " join type_contract tct on ct.type_contract_id = tct.type_contract_id " +
            " join type_product tpd on ct.type_product_id = tpd.type_product_id" +
            " where (ct.date_liquidation >= #?1# or ct.date_liquidation <= #?2#) and ct.flag = 1 " , nativeQuery = true)
    List<Contract> listStatisticEp(String startDate,String endDate);
}
