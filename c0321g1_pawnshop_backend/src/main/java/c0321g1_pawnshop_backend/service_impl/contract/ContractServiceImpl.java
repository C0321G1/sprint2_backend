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
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.List;


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
    public void deleteContract(Long id) {
        this.contractRepository.deleteContract(id);
    }

    @Override
    public Page<Contract> searchContract(Pageable pageable, String customer, String productName, String statusContract, String typeContract, String startDateFrom, String startDateTo) {
        return this.contractRepository.searchContract('%' + customer + '%','%' + productName + '%', '%' + statusContract + '%','%' + typeContract + '%',  startDateFrom , startDateTo ,pageable);
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

    private void sendSimpleEmail(Contract contract) {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(contract.getCustomer().getEmail());
        message.setSubject("[Thông báo] Hợp đồng Của Bạn Sắp Hết Hạn");
        message.setText("Chào, khách hàng " + contract.getCustomer().getName() + "\n"
                + "Hợp Đồng của bạn sắp hết hạn, mã hợp đồng là " + contract.getContractCode() + ".");

        javaMailSender.send(message);
    }

    @Override
    public List<Contract> page10Contract() {
        return contractRepository.page10Contract();
    }

    //vu code
    @Override
    public List<String> getAllEmailToSend() {
        return contractRepository.getAllEmailToSend();
    }

}
