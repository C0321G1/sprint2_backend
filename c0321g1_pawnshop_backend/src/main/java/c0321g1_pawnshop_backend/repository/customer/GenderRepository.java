package c0321g1_pawnshop_backend.repository.customer;

import c0321g1_pawnshop_backend.entity.customer.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenderRepository extends JpaRepository<Gender,Long> {
}
