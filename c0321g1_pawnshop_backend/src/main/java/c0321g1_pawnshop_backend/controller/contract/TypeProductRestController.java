package c0321g1_pawnshop_backend.controller.contract;

import c0321g1_pawnshop_backend.entity.contract.TypeProduct;
import c0321g1_pawnshop_backend.service.contract.TypeProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TypeProductRestController {

    @Autowired
    private TypeProductService typeProductService;

    //Linh code
    @GetMapping("/typeProduct")
    public ResponseEntity<List<TypeProduct>> getTypeProductList() {
        List<TypeProduct> typeProductList = typeProductService.getTypeProductList();
        if (typeProductList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(typeProductList, HttpStatus.OK);
    }
}
