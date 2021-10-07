package c0321g1_pawnshop_backend.service.security;

import c0321g1_pawnshop_backend.entity.security.Account;
import c0321g1_pawnshop_backend.entity.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleService {
    void saveRole(Role role);
}
