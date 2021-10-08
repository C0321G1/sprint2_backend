package c0321g1_pawnshop_backend.controller.employee;

import c0321g1_pawnshop_backend.entity.customer.Gender;
import c0321g1_pawnshop_backend.service.customer.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class GenderRestController {
    @Autowired
    GenderService genderService;

    @GetMapping("/gender")
    public ResponseEntity<List<Gender>> getGenderList() {
        List<Gender> genderList = genderService.getGenderList();
        if(genderList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(genderList, HttpStatus.OK);
    }
}
