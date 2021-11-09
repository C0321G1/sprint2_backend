package c0321g1_pawnshop_backend.repository.pawn_registration;

import c0321g1_pawnshop_backend.entity.pawn_registration.PawnRegistration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface PawnRegistrationRepository extends JpaRepository<PawnRegistration,Long> {
    Page<PawnRegistration> findAll(Pageable pageable);
}