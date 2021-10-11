package c0321g1_pawnshop_backend.controller.contract;

import c0321g1_pawnshop_backend.dto.contract.ContractDto;
import c0321g1_pawnshop_backend.entity.contract.Contract;
import c0321g1_pawnshop_backend.service.contract.ContractService;
import c0321g1_pawnshop_backend.service.contract.StatusContractService;
import c0321g1_pawnshop_backend.service.contract.TypeContractService;
import c0321g1_pawnshop_backend.service.contract.TypeProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
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


}
