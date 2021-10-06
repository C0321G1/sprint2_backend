package c0321g1_pawnshop_backend.entity.contract;

import c0321g1_pawnshop_backend.entity.pawn_registration.PawnRegistration;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class TypeProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long typeProductId;
    private String name;

    @OneToMany(mappedBy = "typeProduct", cascade = CascadeType.ALL)
    @JsonBackReference
    List<Contract> contracts;

    @OneToMany(mappedBy = "typeProduct", cascade = CascadeType.ALL)
    @JsonBackReference
    List<PawnRegistration> pawnRegistrations;
}
