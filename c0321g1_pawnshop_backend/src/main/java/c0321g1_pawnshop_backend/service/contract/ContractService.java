package c0321g1_pawnshop_backend.service.contract;

import c0321g1_pawnshop_backend.entity.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

;

public interface ContractService {
    // vu code
    Page<Contract> getListContract(Pageable pageable);

    void deleteContract(Long contractId);

    Page<Contract> searchContract(Pageable pageable, String customer, String startDateForm, String startDateTo, String productName, String typeContract, String statusContract);

    //khanh code
    Page<Contract> searchTenContract(Pageable pageable, String customer, String statusContract);

    Contract findByIdContract(Long contractId);

}
