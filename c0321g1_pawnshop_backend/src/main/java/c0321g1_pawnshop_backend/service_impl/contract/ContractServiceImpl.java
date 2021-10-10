package c0321g1_pawnshop_backend.service_impl.contract;

import c0321g1_pawnshop_backend.dto.contract.ContractDto;
import c0321g1_pawnshop_backend.dto.contract.ContractEditDto;
import c0321g1_pawnshop_backend.entity.contract.Contract;
import c0321g1_pawnshop_backend.repository.contract.ContractRepository;
import c0321g1_pawnshop_backend.service.contract.ContractService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.List;


@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    private ContractRepository contractRepository;



    private boolean checkStartDate(ContractDto contractDto) {
        int timeDiff = contractDto.getStartDate().compareTo(LocalDate.now().toString());
        return timeDiff < 0;
    }

    private boolean checkEndDate(ContractDto contractDto) {
        int timeDiff = contractDto.getStartDate().compareTo(contractDto.getEndDate());
        return timeDiff >= 0;
    }

    @Override
    public Page<Contract> getListContract(Pageable pageable) {
        return this.contractRepository.getListContract(pageable);
    }

    @Override
    public void deleteContract(Long id) {
        this.contractRepository.deleteContract(id);
    }

    @Override
    public Page<Contract> searchContract(Pageable pageable, String customer,String productName, String statusContract, String typeContract) {
        return this.contractRepository.searchContract( '%'+customer+'%', '%'+productName+'%', '%'+statusContract+'%', '%'+typeContract+'%',pageable);
    }

    @Override
    public List<Contract> searchTNameContract( String customer, String statusContract) {
        return this.contractRepository.searchTenContract( customer, statusContract);
    }

    @Override
    public Contract findByIdContract(Long contractId) {
        return this.contractRepository.findByContractId(contractId);
    }

    @Override
    public void updateContractDto(Contract contract) {

    }

    @Override
    public void save(Contract contract1) {
        this.contractRepository.save(contract1);
    }


    @Override
    public List<Contract> page10Contract() {
        return contractRepository.page10Contract();
    }

}
