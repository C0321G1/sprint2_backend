package c0321g1_pawnshop_backend.entity.pawn_registration;

import c0321g1_pawnshop_backend.entity.contract.TypeProduct;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PawnRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  pawnRegistrationId;
    private String description;
    private String email;
    private String phone;
    private String address;
    private String status;
    private String registerDate;
    private String nameCustomer;

    @ManyToOne
    @JoinColumn(name = "typeProductId",referencedColumnName = "typeProductId")
    private TypeProduct typeProduct;
}
