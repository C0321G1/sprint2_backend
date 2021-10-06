package c0321g1_pawnshop_backend.controller.contract;

import c0321g1_pawnshop_backend.dto.contract.ContractDto;
import c0321g1_pawnshop_backend.service.contract.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

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

    //Linh code
    @PostMapping
    public Map<String, Object> createContract(@RequestBody @Valid ContractDto contractDto,
                                              BindingResult bindingResult) {
        return this.contractService.saveContract(contractDto, bindingResult);
    }
}
