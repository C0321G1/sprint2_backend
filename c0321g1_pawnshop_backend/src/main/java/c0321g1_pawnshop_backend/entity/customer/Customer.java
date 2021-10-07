package c0321g1_pawnshop_backend.entity.customer;

import c0321g1_pawnshop_backend.entity.contract.Contract;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "customerId")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long customerId;
    private String customerCode;
    private String name;
    private String idCard;
    private Integer flag;
    private String phone;
    private String image;
    private String email;
    private String address;
    private String birthDate;

    @ManyToOne
    @JoinColumn(name = "genderId",referencedColumnName = "genderId")
    private Gender gender;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    @JsonBackReference(value = "customer-contract")
    List<Contract> contracts;

}
