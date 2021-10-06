package c0321g1_pawnshop_backend.controller.pawn_registration;

import c0321g1_pawnshop_backend.service.contract.TypeProductService;
import c0321g1_pawnshop_backend.service.pawn_registration.PawnRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping
public class PawnRegistrationRestController {
    @Autowired
    private PawnRegistrationService pawnRegistrationService;
    @Autowired
    private TypeProductService typeProductService;
}
