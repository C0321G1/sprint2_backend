package c0321g1_pawnshop_backend.controller.customer;

import c0321g1_pawnshop_backend.service.customer.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping
public class CustomerRestController {
    @Autowired
    private GenderService genderService;
}
