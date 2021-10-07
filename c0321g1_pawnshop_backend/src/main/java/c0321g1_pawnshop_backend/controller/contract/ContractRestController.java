package c0321g1_pawnshop_backend.controller.contract;

import c0321g1_pawnshop_backend.dto.contract.ContractDto;
import c0321g1_pawnshop_backend.entity.contract.Contract;
import c0321g1_pawnshop_backend.entity.contract.StatusContract;
import c0321g1_pawnshop_backend.entity.contract.TypeContract;
import c0321g1_pawnshop_backend.entity.contract.TypeProduct;
import c0321g1_pawnshop_backend.service.contract.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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

    /*long*/
    @PostMapping("/create-liquidation-contract")
    public ResponseEntity<Void> createLiquidationContract(@Valid @RequestBody ContractDto contractDto,
                                                          BindingResult bindingResult) {
        new ContractDto().validate(contractDto, bindingResult);
        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Contract contract = contractService.searchContractByCode(contractDto.getContractCode());
        if (contract == null) {
            contractService.createLiquidateContract(contractDto.getContractCode(),
                    contractDto.getProductName(), contractDto.getCustomer().getCustomerId(),
                    contractDto.getDateLiquidation(), (long) 2,
                    (long) 3, 0, contractDto.getTotalMoney(),
                    contractDto.getLoan(), 0);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /*long*/
    @GetMapping("/list-liquidation-product")
    public ResponseEntity<Page<Contract>> getLiquidationProduct(@PageableDefault(value = 2) Pageable pageable) {
        Page<Contract> contracts = contractService.findProductLiquidation(pageable);
        if (contracts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(contracts, HttpStatus.OK);
    }

    /*long*/
    @GetMapping("/findContract/{id}")
    public ResponseEntity<Contract> getContractById(@PathVariable Long id) {
        Contract contract = contractService.getContractById(id);
        if (contract == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(contract, HttpStatus.OK);
    }

    /*long*/
    @GetMapping("/search")
    public ResponseEntity<Page<Contract>> searchContract(@PageableDefault(value = 2) Pageable pageable,
                                                         @RequestParam Optional<String> nameProduct,
                                                         @RequestParam Optional<String> nameTypeProduce,
                                                         @RequestParam Optional<String> loan) {
        String nameProductSearch = nameProduct.orElse("");
        String nameTypeProductSearch = nameTypeProduce.orElse("");
        String loanSearch = loan.orElse("");
        Page<Contract> contractPage = contractService.
                searchContractLiquidation(nameProductSearch, loanSearch, nameTypeProductSearch, pageable);
        if (contractPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(contractPage, HttpStatus.OK);
    }

    /*long*/
    @GetMapping("/list-status-contract")
    public ResponseEntity<Iterable<StatusContract>> getAllStatusContract() {
        List<StatusContract> statusContracts = statusContractService.findAll();
        if (statusContracts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(statusContracts, HttpStatus.OK);
    }

    /*long*/
    @GetMapping("/list-type-product")
    public ResponseEntity<Iterable<TypeProduct>> getAllTypeProduct() {
        List<TypeProduct> typeProducts = typeProductService.findAll();
        if (typeProducts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(typeProducts, HttpStatus.OK);
    }

    /*long*/
    @GetMapping("/list-type-contract")
    public ResponseEntity<Iterable<TypeContract>> getAllTypeContract() {
        List<TypeContract> typeContracts = typeContractService.findAll();
        if (typeContracts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(typeContracts, HttpStatus.OK);
    }
}
