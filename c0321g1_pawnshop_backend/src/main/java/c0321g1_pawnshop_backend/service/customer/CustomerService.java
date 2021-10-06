package c0321g1_pawnshop_backend.service.customer;

import c0321g1_pawnshop_backend.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CustomerService {

    //Linh code
    Page<Customer> getCustomerList(Pageable pageable);

    //Linh code
    Optional<Customer> findById(Long id);

    //Linh code
    Page<Customer> searchToCreateContract(String keywordValue, Pageable pageable);
}
