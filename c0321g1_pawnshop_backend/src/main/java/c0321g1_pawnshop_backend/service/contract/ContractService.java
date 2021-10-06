package c0321g1_pawnshop_backend.service.contract;

import c0321g1_pawnshop_backend.dto.contract.ContractDto;
import org.springframework.validation.BindingResult;

import java.util.Map;

public interface ContractService {

    //Linh code
    Map<String, Object> saveContract(ContractDto contractDto, BindingResult bindingResult);
}
