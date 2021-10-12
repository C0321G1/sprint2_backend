package c0321g1_pawnshop_backend.controller.contract;

import c0321g1_pawnshop_backend.dto.contract.ContractDto;
import c0321g1_pawnshop_backend.dto.contract.ContractEditDto;
import c0321g1_pawnshop_backend.entity.contract.Contract;
import c0321g1_pawnshop_backend.entity.contract.StatusContract;
import c0321g1_pawnshop_backend.entity.contract.TypeContract;
import c0321g1_pawnshop_backend.entity.contract.TypeProduct;
import c0321g1_pawnshop_backend.entity.customer.Customer;
import c0321g1_pawnshop_backend.service.contract.*;
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

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.*;

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
    @GetMapping("/list")
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

    @GetMapping("/search")
    public ResponseEntity<Page<Contract>> getSearchContract(@PageableDefault(value = 5)
                                                                     Pageable pageable,
                                                            @RequestParam(defaultValue = "") String customer,
                                                            @RequestParam(defaultValue = "") String productName,
                                                            @RequestParam(defaultValue = "") String statusContract,
                                                            @RequestParam(defaultValue = "") String typeContract,
                                                            @RequestParam(defaultValue = "1900-01-01") String startDateFrom,
                                                            @RequestParam(defaultValue = "2100-01-01") String startDateTo
                                                                     ) {
        try {
            Page<Contract> contracts;
            String keywordCustomer = customer;
            String keywordProductName = productName;
            String keywordStatusContract = statusContract;
            String keywordTypeContract = typeContract;
            String keywordStartDateForm = startDateFrom;
            String keywordStartDateTo = startDateTo;
            if (keywordStartDateTo.equals("") && !keywordStartDateForm.equals("")){
               keywordStartDateTo =new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis()));
                contracts = contractService.searchContract(pageable,keywordCustomer,keywordProductName,keywordStatusContract,keywordTypeContract,keywordStartDateForm,keywordStartDateTo);
                if (contracts.isEmpty()){
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
                return new ResponseEntity<>(contracts, HttpStatus.OK);
            }
            if (keywordStartDateTo.equals("") && keywordStartDateForm.equals("")){
                contracts = contractService.searchContract(pageable,keywordCustomer,keywordProductName,keywordStatusContract,keywordTypeContract,keywordStartDateForm,keywordStartDateTo);
                if (contracts.isEmpty()){
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
                return new ResponseEntity<>(contracts, HttpStatus.OK);
            }else {
                contracts = contractService.searchContract(pageable,keywordCustomer,keywordProductName,keywordStatusContract,keywordTypeContract,keywordStartDateForm,keywordStartDateTo);
                if (contracts.isEmpty()){
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
                return new ResponseEntity<>(contracts, HttpStatus.OK);
            }

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
