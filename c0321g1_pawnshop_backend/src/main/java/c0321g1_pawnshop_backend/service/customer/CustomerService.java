package c0321g1_pawnshop_backend.service.customer;

import c0321g1_pawnshop_backend.entity.customer.Customer;

import java.util.Optional;

public interface CustomerService {
    Optional<Customer> findCustomerById(Long id);

    void saveCustomer(Customer customer);
}
