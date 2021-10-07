package c0321g1_pawnshop_backend.service.customer;

import c0321g1_pawnshop_backend.dto.customer.CusDTO;
import c0321g1_pawnshop_backend.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService {
     Page<CusDTO> findAllCustomerAndCountContract(Pageable pageable);

     void deleteCustomer(Long id);

     Customer findByIdCustomerDb(Long customerId);
}
