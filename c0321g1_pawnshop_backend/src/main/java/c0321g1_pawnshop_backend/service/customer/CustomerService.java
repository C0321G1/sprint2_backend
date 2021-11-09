package c0321g1_pawnshop_backend.service.customer;

import c0321g1_pawnshop_backend.dto.customer.CusDTO;
import c0321g1_pawnshop_backend.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CustomerService {
    Page<CusDTO> findAllCustomerAndCountContract(Pageable pageable);

    Page<CusDTO> searchCustomerAndCountContract(Pageable pageable, String customerCode);

    Page<CusDTO> searchKeyCustomerAndCountContract(Pageable pageable, String keySearch);

    void deleteCustomer(Long id);

    Optional<Customer> findCustomerById(Long id);

    void saveCustomer(Customer customer);

    //Linh code
    Page<Customer> getCustomerList(Pageable pageable);

    //Linh code
    Optional<Customer> findById(Long id);

    //Linh code
    Page<Customer> searchToCreateContract(String keywordValue, Pageable pageable);

}