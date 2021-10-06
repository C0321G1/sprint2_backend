package c0321g1_pawnshop_backend.service_impl.contract;

import c0321g1_pawnshop_backend.dto.contract.ContractDto;
import c0321g1_pawnshop_backend.entity.contract.Contract;
import c0321g1_pawnshop_backend.repository.contract.ContractRepository;
import c0321g1_pawnshop_backend.service.contract.ContractService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    private ContractRepository contractRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    //Linh code
    @Override
    public Map<String, Object> saveContract(ContractDto contractDto, BindingResult bindingResult) {
        Map<String, Object> result = new HashMap<>();

        List<String> errors = new ArrayList<>();
        boolean isError = false;
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(ob -> {
                errors.add(ob.getDefaultMessage());
            });
            result.put("status", false);
            result.put("msg", "Tạo mới hợp đồng thất bại.");
            result.put("errors", errors);
            isError = true;
        }

        if (checkCode(contractDto)) {
            result.put("status", false);
            result.put("msgCode", "Mã hợp đồng đã được sử dụng, vui lòng nhập lại.");
            isError = true;
        }

        if (checkStartDate(contractDto)) {
            result.put("status", false);
            result.put("msgStartDate", "Ngày bắt đầu không được là ngày quá khứ, vui lòng chọn lại.");
            isError = true;
        }

        if (checkEndDate(contractDto)) {
            result.put("status", false);
            result.put("msgEndDate", "Ngày kết thúc phải lớn hơn ngày bắt đầu, vui lòng chọn lại.");
            isError = true;
        }

        if (isError) {
            return result;
        }

        Contract contract = new Contract();
        contractDto.setProductName(contractDto.getProductName().trim());
        BeanUtils.copyProperties(contractDto, contract);
        contractRepository.saveContract(contract.getContractCode(), contract.getStartDate(), contract.getEndDate(),
                contract.getProductName(), contract.getProductImage(), contract.getLoan(), contract.getProfit(),
                contract.getCustomer().getCustomerId(), contract.getTypeProduct().getTypeProductId(),
                1L,1L, 1,null,0);
        sendSimpleEmail(contract);
        result.put("status", true);
        result.put("msg", "Thêm mới hợp đồng thành công.");
        return result;
    }

    private boolean checkCode(ContractDto contractDto) {
        List<Contract> contracts = contractRepository.getContractList();
        for (Contract c : contracts) {
            if (contractDto.getContractCode().equals(c.getContractCode())) {
                return true;
            }
        }
        return false;
    }

    private boolean checkStartDate(ContractDto contractDto) {
        int timeDiff = contractDto.getStartDate().compareTo(LocalDate.now().toString());
        return timeDiff < 0;
    }

    private boolean checkEndDate(ContractDto contractDto) {
        int timeDiff = contractDto.getStartDate().compareTo(contractDto.getEndDate());
        return timeDiff >= 0;
    }

    //creator: vinhdn. send mail contract
    private void sendSimpleEmail(Contract contract) {

        // Create a Simple MailMessage.
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(contract.getCustomer().getEmail());
        message.setSubject("[Thông báo] Tạo mới hợp đồng thành công");
        message.setText("Chào, khách hàng " + contract.getCustomer().getName() + "\n"
         + "Chúc mừng bạn đã được tạo mới hợp đồng thành công, mã hợp đồng là " + contract.getContractCode() + ".");

        // Send Message!
        javaMailSender.send(message);
    }
}
