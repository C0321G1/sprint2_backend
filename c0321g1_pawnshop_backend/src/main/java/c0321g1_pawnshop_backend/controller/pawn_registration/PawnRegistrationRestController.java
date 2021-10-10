package c0321g1_pawnshop_backend.controller.pawn_registration;

import c0321g1_pawnshop_backend.dto.pawn_registration.PawnRegistrationDto;
import c0321g1_pawnshop_backend.entity.contract.TypeProduct;
import c0321g1_pawnshop_backend.entity.pawn_registration.PawnRegistration;
import c0321g1_pawnshop_backend.service.contract.TypeProductService;
import c0321g1_pawnshop_backend.service.pawn_registration.PawnRegistrationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping
public class PawnRegistrationRestController {

    @Autowired
    private PawnRegistrationService pawnRegistrationService;

    @Autowired
    private TypeProductService typeProductService;

    @PostMapping("/pawnRegistration/create")
    public ResponseEntity<PawnRegistration> createPawnRegister(@Valid @RequestBody PawnRegistrationDto pawnRegistrationDto,
                                                               BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }

        PawnRegistration pawnRegistration = new PawnRegistration();
        TypeProduct typeProduct = new TypeProduct();
        String registerTime = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy").format(new Date(System.currentTimeMillis()));


        BeanUtils.copyProperties(pawnRegistrationDto, pawnRegistration);
        BeanUtils.copyProperties(pawnRegistrationDto.getTypeProduct(), typeProduct);
        pawnRegistration.setTypeProduct(typeProduct);
        pawnRegistration.setRegisterDate(registerTime);
        pawnRegistration.setStatus("Chưa xác nhận");
        pawnRegistrationService.save(pawnRegistration);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/typeProduct")
    public ResponseEntity<List<TypeProduct>> getAllTypeProduct() {
        List<TypeProduct> typeProducts = typeProductService.findAll();
        if (typeProducts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(typeProducts, HttpStatus.OK);
    }

    @GetMapping("/pawnRegistration")
    public ResponseEntity<Page<PawnRegistration>> getAllPawnRegistration(@PageableDefault(value = 3, sort = "status") Pageable pageable) {
        Page<PawnRegistration> pawnRegistrations = pawnRegistrationService.findAll(pageable);
        if (pawnRegistrations.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
            return new ResponseEntity<>(pawnRegistrations, HttpStatus.OK);
    }

    @PatchMapping("/pawnRegistration/{id}")
    public ResponseEntity<Void> editStatus(@PathVariable Long id) {
        PawnRegistration pawnRegistration = pawnRegistrationService.findById(id);
        pawnRegistration.setStatus("Đã xác nhận");
        pawnRegistrationService.save(pawnRegistration);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
