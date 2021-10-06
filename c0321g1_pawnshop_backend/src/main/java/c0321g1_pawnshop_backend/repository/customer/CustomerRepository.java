package c0321g1_pawnshop_backend.repository.customer;

import c0321g1_pawnshop_backend.entity.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
