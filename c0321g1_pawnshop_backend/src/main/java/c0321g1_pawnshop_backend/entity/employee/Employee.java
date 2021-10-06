package c0321g1_pawnshop_backend.entity.employee;

import c0321g1_pawnshop_backend.entity.customer.Gender;
import c0321g1_pawnshop_backend.entity.security.Account;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    private String salary;
    private String idCard;
    private String name;
    private String employeeCode;
    private String birthDate;
    private String address;
    private String email;
    private String image;
    private String phone;
    private Long flag;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id",referencedColumnName = "accountId")
    private Account account;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "gender_id", referencedColumnName = "genderId")
    private Gender gender;
}
