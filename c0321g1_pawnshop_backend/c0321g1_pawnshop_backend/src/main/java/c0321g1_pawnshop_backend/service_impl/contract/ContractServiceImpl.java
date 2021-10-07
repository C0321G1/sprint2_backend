package c0321g1_pawnshop_backend.service_impl.contract;

import c0321g1_pawnshop_backend.entity.contract.Contract;
import c0321g1_pawnshop_backend.repository.contract.ContractRepository;
import c0321g1_pawnshop_backend.service.contract.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    private ContractRepository contractRepository;
    @Autowired
    private JavaMailSender javaMailSender;

    //    creator: vinhdn. Get list contract
    @Override
    public Page<Contract> getListContract(Pageable pageable) {
        return contractRepository.getListContract(pageable,1);
    }

    //    creator: vinhdn. search contract
    @Override
    public Page<Contract> searchContract(Pageable pageable, String contractCode, String customerName,
                                         String productName, String startDate) {
        return contractRepository.searchContract(pageable, contractCode,
                customerName, productName, startDate,1);
    }

    //    creator: vinhdn. payment contract
    @Override
    public void paymentContract(int totalMoney, Long contractId) {
        contractRepository.paymentContract(0, totalMoney, contractId);
    }

    //    creator: vinhdn. send mail contract
    public String sendPaymentEmail(Contract contract) {

        // Create a Simple MailMessage.
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(contract.getCustomer().getEmail());
        message.setSubject("Hợp đồng cầm đồ của quý khách đã được thanh toán");
        message.setText("Dear " + contract.getCustomer().getName() + "\n" +
                "Hợp đồng cầm đồ của quý khách đã thanh toán" + "\n" +
                "Hợp đồng id số " + contract.getContractId() + "\n" +
                "Đồ cầm là " + contract.getProductName() + "\n" +
                "Số tiền thanh toán là " + contract.getTotalMoney());

        // Send Message!
        javaMailSender.send(message);
        return "Email Sent!";
    }
}
