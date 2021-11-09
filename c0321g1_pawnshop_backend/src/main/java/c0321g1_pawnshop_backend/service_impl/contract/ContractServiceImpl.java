package c0321g1_pawnshop_backend.service_impl.contract;

import c0321g1_pawnshop_backend.dto.contract.ContractDto;
import c0321g1_pawnshop_backend.entity.contract.Contract;
import c0321g1_pawnshop_backend.repository.contract.ContractRepository;
import c0321g1_pawnshop_backend.service.contract.ContractService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.*;

@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    ContractRepository contractRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    /*Long*/
    @Override
    public Integer createLiquidateContract(String contractCode, String productName, Long customerId,
                                           String dateLiquidation, Long typeContractId,
                                           Long statusId, int flag, int totalMoney, int loan,
                                           int profit) {
        return contractRepository.createLiquidateContract(contractCode, productName, customerId, dateLiquidation,
                typeContractId, statusId, flag, totalMoney, loan, profit);
    }

    /*Long*/
    @Override
    public Page<Contract> findProductLiquidation(Pageable pageable) {
        return contractRepository.findProductLiquidation(pageable);
    }

    /*Long*/
    @Override
    public Contract searchContractByCode(String contractCode) {
        return contractRepository.searchContractByCode(contractCode);
    }

    /*long*/
    @Override
    public Contract getContractById(Long id) {
        return contractRepository.getContractById(id);
    }

    /*long*/
    @Override
    public Page<Contract> searchContractLiquidation(String nameProduct, String nameTypeProduct, Integer loan, Pageable pageable) {
        return contractRepository.searchContractLiquidation(nameProduct, nameTypeProduct, loan, pageable);
    }

    /*long*/
    @Override
    public Integer setStatusById(Long id, Long statusId) {
        return contractRepository.setStatusById(id, statusId);
    }

    /*long*/
    @Override
    public Integer upDateLiquidationContract(String dateLiquidation, int totalMoney, Long customerId, Long contractId) {
        return contractRepository.upDateLiquidationContract(dateLiquidation, totalMoney, customerId, contractId);
    }

    /*long*/
    @Override
    public String initCodeAuto() {
        List<Contract> contracts = contractRepository.getContractList();
        String contractCode = "";
        if (contracts.isEmpty()) {
            contractCode = "HD-0001";
        } else {
            Long code = contracts.get(contracts.size() - 1).getContractId();
            contractCode = "HD-" + String.format("%04d", ++code);
        }
        return contractCode;
    }


    //Linh code
    @Override
    public Map<String, Object> saveContract(ContractDto contractDto, BindingResult bindingResult) throws MessagingException {
        Map<String, Object> result = new HashMap<>();

        List<String> errors = new ArrayList<>();
        boolean isError = false;
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(ob ->
                    errors.add(ob.getDefaultMessage()));
            result.put("status", false);
            result.put("msg", "Tạo mới hợp đồng thất bại.");
            result.put("errors", errors);
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
        contractDto.setContractCode(initCode());
        BeanUtils.copyProperties(contractDto, contract);
        contractRepository.saveContract(contract.getContractCode(), contract.getStartDate(), contract.getEndDate(),
                contract.getProductName(), contract.getProductImage(), contract.getLoan(), contract.getProfit(),
                contract.getCustomer().getCustomerId(), contract.getTypeProduct().getTypeProductId(),
                1L, 1L, 1, null, 0);
        sendEmailAfterCreateContract(contract);
        result.put("status", true);
        result.put("msg", "Thêm mới hợp đồng thành công.");
        return result;
    }

    private String initCode() {
        List<Contract> contracts = contractRepository.getContractList();
        String contractCode = "";
        if (contracts.isEmpty()) {
            contractCode = "HD-0001";
        } else {
            Long code = contracts.get(contracts.size() - 1).getContractId();
            contractCode = "HD-" + String.format("%04d", ++code);
        }
        return contractCode;
    }



    private boolean checkEndDate(ContractDto contractDto) {
        int timeDiff = contractDto.getStartDate().compareTo(contractDto.getEndDate());
        return timeDiff >= 0;
    }

    //Linh code
    private void sendEmailAfterCreateContract(Contract contract) throws MessagingException {

//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo(contract.getCustomer().getEmail());
//        message.setSubject("[Thông báo] Tạo mới hợp đồng cầm đồ thành công");
//        message.setText("Chào, khách hàng " + contract.getCustomer().getName() + "\n" +
//                "Chúc mừng bạn đã tạo mới hợp đồng cầm đồ thành công. \n" +
//                "Thông tin hợp đồng: \n" +
//                "Mã hợp đồng: " + contract.getContractCode() + ".\n" +
//                "Ngày bắt đầu: " + contract.getStartDate() + ".\n" +
//                "Ngày kết thúc: " + contract.getEndDate() + ".\n" +
//                "Tiền cho vay: " + contract.getLoan()  + ".\n" +
//                "Tiền lãi: " + contract.getProfit() + ".\n" +
//                "\n" +
//                "Thanks and Best Regards!\n" +
//                "M: 1800-6969\n" +
//                "E: codegym.c0321g1@gmail.com");
//
//        javaMailSender.send(message);


        final String fromEmail = "codegym.c0321g1@gmail.com";
        // Mat khai email cua ban
        final String password = "Qwerty@123";
        // dia chi email nguoi nhan
        final String toEmail = "hauhpdn2015@gmail.com";
        final String subject = "[Thông báo] Tạo mới hợp đồng cầm đồ thành công";
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        props.put("mail.smtp.port", "587"); //TLS Port
        props.put("mail.smtp.auth", "true"); //enable authentication
        props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(fromEmail));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
        message.setSubject(subject);
        String htmlContent = "<div style=\"align-content: center; text-align: center\">" +
                "<img src=\"https://firebasestorage.googleapis.com/v0/b/c0321g1-sprint1.appspot.com/o/RoomsImages%2F1634479388976?alt=media&token=07afab21-e1f6-487e-8975-e275f52f40e5\">\n" +
                "<h3>CÔNG TY TNHH MTV CẦM ĐỒ C03</h3>\n" +
                "<h1 style=\"color: red\">THÔNG BÁO XÁC NHẬN HỢP ĐỒNG CẦM ĐỒ </h1>" +
                "<p>Chào, khách hàng " + contract.getCustomer().getName() +
                " Chúc mừng bạn đã tạo mới hợp đồng cầm đồ thành công.</p>" +

                                "<p>Thông tin hợp đồng: </p>" +
                "<p>Mã hợp đồng: " + contract.getContractCode() + "</p>" +
                "<p>Ngày bắt đầu: " + contract.getStartDate() + "</p>" +
                "<p>Ngày kết thúc: " + contract.getEndDate() + "</p>" +
                "<p style=\"color:red\">Tiền cho vay: " + contract.getLoan()  + " VND</p>" +
                "<p style=\"color:red\">Tiền lãi: " + contract.getProfit() + " VND</p>"+
        "</div>" +
               "<div style=\"background-color: green\">\n" +
                "  <div  style=\"text-align: center; color: white; padding-right: 2px; padding-left: 2px\">\n" +
                "    <p>Cảm ơn quý khách đã sử dụng dịch vụ</p>\n" +
                "    <p>Dịch vụ cầm đồ Đà Nẵng uy tín - MST: 696 696 696</p>\n" +
                "    <p>295 Nguyễn Tất Thành, Thanh Bình, Hải Châu, Đà Nẵng 550000, Việt Nam\n" +
                "    </p>\n" +
                "  </div>\n" +
                "</div>";
        message.setContent(htmlContent, "text/html; charset=utf-8");
        Transport.send(message);
        System.out.println("Gui mail thanh cong");



    }


    //    creator: vinhdn. Get list contract
    @Override
    public Page<Contract> getListContract(Pageable pageable) {
        return contractRepository.getListContract(pageable, 1);
    }

    //    creator: vinhdn. search contract
    @Override
    public Page<Contract> searchContract(Pageable pageable, String contractCode, String customerName,
                                         String productName, String startDate) {
        return contractRepository.searchContract(pageable, contractCode,
                customerName, productName, startDate, 1);
    }

    //    creator: vinhdn. payment contract
    @Override
    public void paymentContract(Contract contract) {
        contractRepository.paymentContract(2, contract.getTotalMoney(), contract.getContractId());
        Optional<Contract> contract1 = contractRepository.findById(contract.getContractId());
        contract1.ifPresent(this::sendPaymentEmail);
    }

    /*Vu*/
    @Override
    public Page<Contract> getListContractHistory(Pageable pageable) {
        return contractRepository.getListContractHistory(pageable);
    }

    //    creator: vinhdn. send mail contract
    public String sendPaymentEmail(Contract contract) {
        // Create a Simple MailMessage.
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(contract.getCustomer().getEmail());
        message.setSubject("Hợp đồng cầm đồ của quý khách đã được thanh toán");
        message.setText("Dear " + contract.getCustomer().getName() + "\n" +
                "Hợp đồng cầm đồ của quý khách đã được thanh toán" + "\n" +
                "Hợp đồng id số " + contract.getContractId() + "\n" +
                "Đồ cầm là " + contract.getProductName() + "\n" +
                "Số tiền thanh toán là " + contract.getTotalMoney() + "VND");

        // Send Message!
        javaMailSender.send(message);
        return "Email Sent!";
    }


    @Override
    public void deleteContract(Long id) {
        this.contractRepository.deleteContract(id);
    }

    @Override
    public Page<Contract> searchContractHistory(Pageable pageable, String customer, String productName, String statusContract, String typeContract, String startDateFrom, String startDateTo) {
        return this.contractRepository.searchContractHistory( customer ,  productName ,  statusContract,  typeContract , startDateFrom, startDateTo, pageable);
    }

    @Override
    public List<Contract> searchTNameContract(String customer, String statusContract) {
        return this.contractRepository.searchTenContract(customer, statusContract);
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

    //vu code
    @Override
    public List<String> getAllEmailToSend() {
        return contractRepository.getAllEmailToSend();
    }


}
