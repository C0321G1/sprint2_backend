package c0321g1_pawnshop_backend.repository.finance;

import c0321g1_pawnshop_backend.entity.finance.Finance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinanceRepository extends JpaRepository<Finance,Long> {
}
