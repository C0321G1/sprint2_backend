package c0321g1_pawnshop_backend.repository.security;

import c0321g1_pawnshop_backend.entity.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
