package c0321g1_pawnshop_backend.service_impl.security;

import c0321g1_pawnshop_backend.entity.security.Account;
import c0321g1_pawnshop_backend.repository.security.AccountRepository;
import c0321g1_pawnshop_backend.service.security.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    private JavaMailSender javaMailSender;


    @Override
    public void saveAccount(Account account) {
        accountRepository.saveAccount(account.getUsername(), account.getPassword());
    }


    @Override
    public void editAccount(Account account) {
        accountRepository.editAccount(account.getUsername(), account.getPassword(), account.getAccountId());
    }

    @Override
    public void saveRoleForAccount(Long accountId, Long roleId) {
        accountRepository.saveRoleForAccount(accountId, roleId);
    }

    @Override
    public List<Account> getAccountList() {
        return accountRepository.getAccountList();
    }

    //khue



    @Override
    public Optional<Account> findByUserNames(String userName) {
        return accountRepository.findByUserNames(userName);
    }

    @Override
    public void changePassWord(String newPassword,Long accountId) throws MessagingException {
        accountRepository.changePassWord(encoder.encode(newPassword), accountId);
        Account account = accountRepository.getById(accountId);
        sendChangPasswordEmail(account.getEmployee().getEmail());
    }

    @Override
    public void changeStatus(int status, Long accountId) {
        accountRepository.changeStatus(status, accountId);
    }

//    @Override
//    public void editAccount(Account account) {
//        accountRepository.editAccount(account.getUsername(), account.getPassword(), account.getAccountId());
//    }

    //    creator: vinhdn. send mail contract
    public String sendChangPasswordEmail(String email) throws MessagingException {
//        // Create a Simple MailMessage.
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo(email);
//        message.setSubject("Bạn đã đổi mật khẩu thành công, vui lòng kiểm tra lại thông tin");
//        message.setText("Dear " + email + "\n" +
//                "Mật khẩu của bạn đã được thay đổi");
//
//        // Send Message!
//        javaMailSender.send(message);
//        return "Email Sent!";

        final String fromEmail = "codegym.c0321g1@gmail.com";
        // Mat khai email cua ban
        final String password = "Qwerty@123";
        // dia chi email nguoi nhan
        final String subject = "[Thông báo] Thay đổi mật khẩu thành công";
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
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email, false));
        message.setSubject(subject);
        String htmlContent = "<div style=\"align-content: center; text-align: center\">\n" +
                "<img src=\"https://firebasestorage.googleapis.com/v0/b/c0321g1-sprint1.appspot.com/o/RoomsImages%2F1634479388976?alt=media&token=07afab21-e1f6-487e-8975-e275f52f40e5\">\n" +
                "<h3>CÔNG TY TNHH MTV CẦM ĐỒ C03</h3>\n" +
                "<h1 style=\"color: red\">THÔNG BÁO XÁC NHẬN THAY ĐỔI MẬT KHẨU THÀNH CÔNG</h1>\n" +
                "<p>Bạn đã thực hiện thay đổi mật khẩu, nếu không phải bạn vui lòng liên hệ ngay mới admin để lấy lại tài khoản</p>\n" +
                "</div>"+
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


        return "Email Sent!";
    }
}
