package c0321g1_pawnshop_backend.repository.statictis;

import c0321g1_pawnshop_backend.entity.finance.Finance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatisticRepository extends JpaRepository<Finance,Long> {
}
