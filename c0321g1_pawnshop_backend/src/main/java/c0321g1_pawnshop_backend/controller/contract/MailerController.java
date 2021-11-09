package c0321g1_pawnshop_backend.controller.contract;
import c0321g1_pawnshop_backend.service.contract.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@EnableScheduling
public class MailerController {
    @Autowired
    private JavaMailSender emailSender;
    @Autowired
    private ContractService contractService;

    @Scheduled(cron = " 0 55 13 ? * * ")
    public void sendEmail(){
        List<String> listEmailOneTime =contractService.getAllEmailToSend();
        Set<String> listMail = new HashSet<>();
        listMail.addAll(listEmailOneTime);
        if (!(listMail.size()==0)){
            String [] array =listMail.toArray(new String[0]);
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(array);
            message.setSubject("[Thông báo] Hợp đồng Của Bạn Sắp Hết Hạn ");
            message.setText(" Hợp Đồng của bạn sắp hết hạn.Bạn vui lòng liên hệ với cửa hàng.");
            // Send Message!
            this.emailSender.send(message);
        }else{
            System.out.println("Have not email to send!");

        }
    }
}
