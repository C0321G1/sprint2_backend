package c0321g1_pawnshop_backend.dto.security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {
    private Long accountId;
    private String password;
    private String username;
    private String userTime;
    private int status;
}
