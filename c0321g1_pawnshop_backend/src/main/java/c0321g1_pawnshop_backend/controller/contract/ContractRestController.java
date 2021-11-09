package c0321g1_pawnshop_backend.controller.contract;

import c0321g1_pawnshop_backend.dto.contract.ContractDto;
import c0321g1_pawnshop_backend.dto.contract.ContractDtoLiquid;
import c0321g1_pawnshop_backend.dto.contract.ContractEditDto;
import c0321g1_pawnshop_backend.entity.contract.Contract;
import c0321g1_pawnshop_backend.entity.contract.StatusContract;
import c0321g1_pawnshop_backend.entity.contract.TypeContract;
import c0321g1_pawnshop_backend.entity.contract.TypeProduct;
import c0321g1_pawnshop_backend.entity.customer.Customer;
import c0321g1_pawnshop_backend.service.contract.ContractService;
import c0321g1_pawnshop_backend.service.contract.StatusContractService;
import c0321g1_pawnshop_backend.service.contract.TypeContractService;
import c0321g1_pawnshop_backend.service.contract.TypeProductService;
import c0321g1_pawnshop_backend.service_impl.contract.ContractServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.naming.NamingException;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/contract")
public class ContractRestController {
    @Autowired
    ContractService contractService;
    @Autowired
    StatusContractService statusContractService;
    @Autowired
    TypeContractService typeContractService;
    @Autowired
    TypeProductService typeProductService;

    /*long*/
    @PostMapping("/create-liquidation-contract")
    public ResponseEntity<Void> createLiquidationContract(@Valid @RequestBody ContractDtoLiquid contractDtoLiquid,
                                                          BindingResult bindingResult) {
        new ContractDtoLiquid().validate(contractDtoLiquid, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Contract contract = contractService.searchContractByCode(contractDtoLiquid.getContractCode());
        if (contract == null) {
            String contractCodeAuto = contractService.initCodeAuto();
            contractService.createLiquidateContract(contractCodeAuto,
                    contractDtoLiquid.getProductName(), contractDtoLiquid.getCustomer().getCustomerId(),
                    contractDtoLiquid.getDateLiquidation(), (long) 2,
                    (long) 3, 1, contractDtoLiquid.getTotalMoney(),
                    contractDtoLiquid.getLoan(), 5);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PatchMapping("/update-liquidation-contract")
    public ResponseEntity<Void> updateLiquidationContract(@Valid @RequestBody ContractDtoLiquid contractDtoLiquid,
                                                          BindingResult bindingResult){
        new ContractDtoLiquid().validate(contractDtoLiquid, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Contract contract = contractService.searchContractByCode(contractDtoLiquid.getContractCode());
        if (contract.getContractCode().equals(contractDtoLiquid.getContractCode())){
            contractService.upDateLiquidationContract(contractDtoLiquid.getDateLiquidation(),
                    contractDtoLiquid.getTotalMoney(),contractDtoLiquid.getCustomer().getCustomerId(),
                    contractDtoLiquid.getContractId());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /*long*/
    @GetMapping("/list-liquidation-product")
    public ResponseEntity<Page<Contract>> getLiquidationProduct(@PageableDefault(value = 2) Pageable pageable) {

            Page<Contract> contracts = contractService.findProductLiquidation(pageable);
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
                                                         @RequestParam(defaultValue = "") String nameProduct,
                                                         @RequestParam(defaultValue = "") String nameTypeProduct,
                                                         @RequestParam(defaultValue = "10000000") Integer loan

    ) {
        try {
            Page<Contract> contractPage = contractService.searchContractLiquidation(nameProduct,
                    nameTypeProduct, loan, pageable);
            return new ResponseEntity<>(contractPage, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
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

    /*long*/
    @PatchMapping("/setStatus/{id}")
    public ResponseEntity<Void> setFlag(@PathVariable Long id, @RequestBody Long status) {
        contractService.setStatusById(id, status);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //Linh code
    @PostMapping
    public Map<String, Object> createContract(@RequestBody @Valid ContractDto contractDto,
                                              BindingResult bindingResult) throws MessagingException, NamingException {
        return this.contractService.saveContract(contractDto, bindingResult);
    }

    //    creator: vinhdn. Get list contract
    @GetMapping("/list")
    public ResponseEntity<Page<Contract>> getListContract(@PageableDefault(value = 3) Pageable pageable) {
        Page<Contract> contracts = contractService.getListContract(pageable);
        if (contracts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(contracts, HttpStatus.OK);
    }

    //    creator: vinhdn. search contract
    @GetMapping("/search/{code},{name},{product},{date}")
    public ResponseEntity<Page<Contract>> searchContract(@PageableDefault(value = 3) Pageable pageable,
                                                         @PathVariable String code, @PathVariable String name,
                                                         @PathVariable String product, @PathVariable String date) {
        Page<Contract> contracts = contractService.searchContract(pageable, code, name, product, date);
        if (contracts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(contracts, HttpStatus.OK);
    }

    @PostMapping("/payment")
    public ResponseEntity<Contract> paymentContract(@RequestBody ContractDto contractDto) {
        if (contractDto.getContractId() == null) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDto,contract);
        contractService.paymentContract(contract);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    //vu code
    @GetMapping("/list-history")
    public ResponseEntity<Page<Contract>> getAllContractHistory(@PageableDefault(value = 5) Pageable pageable) {
        try {
            Page<Contract> contracts = contractService.getListContractHistory(pageable);
            if (contracts.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(contracts, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteContract(@PathVariable Long id) {
        this.contractService.deleteContract(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
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

    @GetMapping("/search-history")
    public ResponseEntity<Page<Contract>> getSearchContractHistory(@PageableDefault(value = 5)
                                                                           Pageable pageable,
                                                                   @RequestParam(defaultValue = "") String customer,
                                                                   @RequestParam(defaultValue = "") String productName,
                                                                   @RequestParam(defaultValue = "") String statusContract,
                                                                   @RequestParam(defaultValue = "") String typeContract,
                                                                   @RequestParam(defaultValue = "1900-01-01") String startDateFrom,
                                                                   @RequestParam(defaultValue = "2100-01-01") String startDateTo
    ) {
        try {

            String keywordCustomer = customer;
            String keywordProductName = productName;
            String keywordStatusContract = statusContract;
            String keywordTypeContract = typeContract;
            String keywordStartDateForm = startDateFrom;
            String keywordStartDateTo = startDateTo;
            Page<Contract> contracts = contractService.searchContractHistory(pageable,keywordCustomer,keywordProductName,keywordStatusContract,keywordTypeContract,keywordStartDateForm,keywordStartDateTo);
            if (contracts.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(contracts, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/edit/{id}")
    public ResponseEntity<Contract> editContract(@Valid @RequestBody ContractEditDto contractEditDto, @PathVariable Long id) {
        try {
            Contract contracts = contractService.findByIdContract(id);
            if (contracts == null) {
                Contract contract1 = new Contract();
                contractEditDto.setContractId(contracts.getContractId());
                BeanUtils.copyProperties(contractEditDto, contract1);
                contractService.updateContractDto(contract1);
                return new ResponseEntity<>(HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // khanh code
    @PatchMapping("/{id}")
    public ResponseEntity<Contract> editContract(@RequestBody @Valid ContractDto contractDto,
                                                 @PathVariable Long id) {
        try {

            Contract contract = contractService.findByIdContract(id);
            if (contract == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } else {

                Customer customer = new Customer();
                contractDto.setContractId(contract.getContractId());
                BeanUtils.copyProperties(contractDto, contract);
                BeanUtils.copyProperties(contractDto.getCustomer(),customer);
                contract.setCustomer(customer);
                StatusContract statusContract = new StatusContract();
                statusContract.setStatusId(contractDto.getStatusContract().getStatusId());
                TypeContract typeContract = new TypeContract();
                typeContract.setTypeContractId(contractDto.getTypeContract().getTypeContractId());
                TypeProduct typeProduct = new TypeProduct();
                typeProduct.setTypeProductId(contractDto.getTypeProduct().getTypeProductId());
                contract.setTypeProduct(typeProduct);
                contract.setStatusContract(statusContract);
                contract.setTypeContract(typeContract);
                contract.setFlag(1);
                contractService.save(contract);
                return new ResponseEntity<>(HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

    @GetMapping("/list10")
    public ResponseEntity<List<Contract>> page10Contract(){
        List<Contract> contractPage = contractService.page10Contract();
        if (contractPage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(contractPage,HttpStatus.OK);

    }
    @GetMapping("/searchName")
    public ResponseEntity<List<Contract>> getPage10Contract(Optional<String> name,
                                                            Optional<String> status){
        String nameContract = name.orElse("").trim();
        String statusContract = status.orElse("").trim();
        List<Contract> contractPage = contractService.searchTNameContract(nameContract,statusContract);
        if (contractPage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(contractPage,HttpStatus.OK);
    }


}
