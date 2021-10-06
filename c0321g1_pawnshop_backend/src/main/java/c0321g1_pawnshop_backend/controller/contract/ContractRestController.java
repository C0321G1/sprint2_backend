package c0321g1_pawnshop_backend.controller.contract;

import c0321g1_pawnshop_backend.entity.contract.Contract;
import c0321g1_pawnshop_backend.entity.customer.Customer;
import c0321g1_pawnshop_backend.service.contract.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/contract")
public class ContractRestController {
    @Autowired
    private ContractService contractService;
    @Autowired
    private StatusContractService statusContractService;
    @Autowired
    private TypeContractService typeContractService;
    @Autowired
    private TypeProductService typeProductService;

    //vu code
    @GetMapping("/contract/list")
    public ResponseEntity<Page<Contract>> getAllContract(@PageableDefault(value = 5) Pageable pageable) {
        try {
            Page<Contract> contracts = contractService.getListContract(pageable);
            if (contracts.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(contracts, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @PatchMapping("/contract/delete/{id}")
    public ResponseEntity<Contract> deleteContract(@PathVariable Long id) {
        this.contractService.deleteContract(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/contract/{id}")
    public ResponseEntity<?> findContractById(@PathVariable Long id) {
        try {
            Contract contracts = contractService.findByIdContract(id);
            if (id == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(contracts, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/contract/search")
    public ResponseEntity<Page<Contract>> getSearchContract(@PageableDefault(value = 5) Pageable pageable,
                                                            @RequestParam(defaultValue = "") String customer,
                                                            @RequestParam(defaultValue = "1900-01-01") String startDateForm,
                                                            @RequestParam(defaultValue = "2100-01-01") String startDateTo,
                                                            @RequestParam(defaultValue = "") String productName,
                                                            @RequestParam(defaultValue = "") String statusContract,
                                                            @RequestParam(defaultValue = "") String typeContract) {
        Page<Contract> contracts = contractService.searchContract(pageable, customer, startDateForm, startDateTo, productName, typeContract, statusContract);
        if (contracts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(contracts, HttpStatus.OK);
    }



}
