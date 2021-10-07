package c0321g1_pawnshop_backend.service_impl.contract;

import c0321g1_pawnshop_backend.dto.contract.ContractDto;
import c0321g1_pawnshop_backend.dto.contract.ContractEditDto;
import c0321g1_pawnshop_backend.entity.contract.Contract;
import c0321g1_pawnshop_backend.repository.contract.ContractRepository;
import c0321g1_pawnshop_backend.service.contract.ContractService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


import java.time.LocalDate;


@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    private ContractRepository contractRepository;
    @Autowired
    private JavaMailSender javaMailSender;


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

    @Override
    public void updateContractDto(ContractEditDto contractEditDto) {

    }

}
