package c0321g1_pawnshop_backend.service_impl.contract;

import c0321g1_pawnshop_backend.entity.contract.Contract;
import c0321g1_pawnshop_backend.repository.contract.ContractRepository;
import c0321g1_pawnshop_backend.service.contract.ContractService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    private ContractRepository contractRepository;

    @Override
    public Page<Contract> getListContract(Pageable pageable) {
        return this.contractRepository.getListContract(pageable);
    }

    @Override
    public void deleteContract(Long contractId) {
        this.contractRepository.deleteContract(contractId);
    }

    @Override
    public Page<Contract> searchContract(Pageable pageable, String customer, String startDateForm, String startDateTo, String productName, String typeContract, String statusContract) {
        return this.contractRepository.searchContract(pageable, customer, statusContract, typeContract, productName, startDateForm, startDateTo);
    }

    @Override
    public Page<Contract> searchTenContract(Pageable pageable, String customer, String statusContract) {
        return this.contractRepository.searchTenContract(pageable, customer, statusContract);
    }

    @Override
    public Contract findByIdContract(Long contractId) {
        return this.contractRepository.findByContractId(contractId);
    }
}
