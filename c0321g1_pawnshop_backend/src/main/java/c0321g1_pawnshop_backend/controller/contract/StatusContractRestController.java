package c0321g1_pawnshop_backend.controller.contract;

import c0321g1_pawnshop_backend.entity.contract.StatusContract;
import c0321g1_pawnshop_backend.service.contract.StatusContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class StatusContractRestController {
    @Autowired
    StatusContractService  statusContractService;
    //Vu code
    @GetMapping("/statusContract")
    public ResponseEntity<List<StatusContract>> getStatusContractList() {
        List<StatusContract> typeStatusList = statusContractService.getStatusContractList();
        if (typeStatusList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(typeStatusList, HttpStatus.OK);
    }
}
