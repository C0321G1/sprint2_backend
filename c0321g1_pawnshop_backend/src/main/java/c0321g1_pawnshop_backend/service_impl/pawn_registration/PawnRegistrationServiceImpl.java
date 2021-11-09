package c0321g1_pawnshop_backend.service_impl.pawn_registration;

import c0321g1_pawnshop_backend.entity.pawn_registration.PawnRegistration;
import c0321g1_pawnshop_backend.repository.pawn_registration.PawnRegistrationRepository;
import c0321g1_pawnshop_backend.service.pawn_registration.PawnRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PawnRegistrationServiceImpl implements PawnRegistrationService {
    @Autowired
    private PawnRegistrationRepository pawnRegistrationRepository;

    @Override
    public Page<PawnRegistration> findAll(Pageable pageable) {
        return pawnRegistrationRepository.findAll(pageable);
    }

    @Override
    public void save(PawnRegistration pawnRegistration) {
        pawnRegistrationRepository.save(pawnRegistration);
    }

    @Override
    public PawnRegistration findById(Long id) {
        return pawnRegistrationRepository.findById(id).get();
    }

}