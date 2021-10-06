package c0321g1_pawnshop_backend.repository.pawn_registration;

import c0321g1_pawnshop_backend.entity.pawn_registration.PawnRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PawnRegistrationRepository extends JpaRepository<PawnRegistration,Long> {
}
