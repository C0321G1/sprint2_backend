package c0321g1_pawnshop_backend.service.contract;

import c0321g1_pawnshop_backend.dto.contract.ContractDto;
import c0321g1_pawnshop_backend.dto.contract.ContractEditDto;
import c0321g1_pawnshop_backend.entity.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Map;

public interface ContractService {

    //Vu code
    Page<Contract> getListContract(Pageable pageable);

    void deleteContract(Long contractId);

    Page<Contract> searchContract(Pageable pageable, String customer, String statusContract, String typeContract, String productName);

    //Khanh code
    List<Contract> searchTNameContract( String customer, String statusContract);

    Contract findByIdContract(Long contractId);
    void updateContractDto(Contract contract);
    void save(Contract contract1);

    List<Contract> page10Contract();



}
