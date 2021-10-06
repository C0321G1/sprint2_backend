package c0321g1_pawnshop_backend.service_impl.pawn_registration;

import c0321g1_pawnshop_backend.repository.pawn_registration.PawnRegistrationRepository;
import c0321g1_pawnshop_backend.service.pawn_registration.PawnRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PawnRegistrationServiceImpl implements PawnRegistrationService {
    @Autowired
    private PawnRegistrationRepository pawnRegistrationRepository;
}
