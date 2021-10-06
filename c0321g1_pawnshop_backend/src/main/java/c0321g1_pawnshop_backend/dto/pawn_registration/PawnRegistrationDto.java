package c0321g1_pawnshop_backend.dto.pawn_registration;

import c0321g1_pawnshop_backend.dto.contract.TypeProductDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PawnRegistrationDto {
    private Long  pawnRegistrationId;
    private String description;
    private String email;
    private String phone;
    private String address;
    private String status;
    private String registerDate;
    private String nameCustomer;
    private TypeProductDto typeProduct;
}
