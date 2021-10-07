package c0321g1_pawnshop_backend.repository.contract;

import c0321g1_pawnshop_backend.entity.contract.StatusContract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StatusContractRepository extends JpaRepository<StatusContract,Long> {
    //Vu code
    @Query(value = "select * from status_contract", nativeQuery = true)
    List<StatusContract> getStatusContractList();
}
