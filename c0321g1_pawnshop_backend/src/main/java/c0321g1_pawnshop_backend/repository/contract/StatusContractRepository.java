package c0321g1_pawnshop_backend.repository.contract;

import c0321g1_pawnshop_backend.entity.contract.StatusContract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusContractRepository extends JpaRepository<StatusContract,Long> {
}
