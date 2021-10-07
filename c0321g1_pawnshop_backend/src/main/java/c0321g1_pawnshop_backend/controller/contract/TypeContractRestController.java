package c0321g1_pawnshop_backend.controller.contract;

import c0321g1_pawnshop_backend.entity.contract.TypeContract;
import c0321g1_pawnshop_backend.service.contract.TypeContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


public class TypeContractRestController {
    @Autowired
    TypeContractService typeContractService;
    //Vu code
    @GetMapping("/typeContract")
    public ResponseEntity<List<TypeContract>> getTypeContractList() {
        List<TypeContract> typeContractList = typeContractService.getTypeContractList();
        if (typeContractList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(typeContractList, HttpStatus.OK);
    }
}
