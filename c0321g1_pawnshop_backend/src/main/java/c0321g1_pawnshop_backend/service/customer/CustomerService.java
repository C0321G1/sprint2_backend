package c0321g1_pawnshop_backend.service.customer;

import c0321g1_pawnshop_backend.dto.customer.CusDTO;
import c0321g1_pawnshop_backend.entity.customer.Customer;

import java.util.List;

public interface CustomerService {
     List<CusDTO> findAllCustomerAndCountContract();
     void deleteCustomer(Long id);

     Customer findByIdCustomerDb(Long customerId);
}
