package c0321g1_pawnshop_backend.service_impl.customer;

import c0321g1_pawnshop_backend.dto.customer.CusDTO;
import c0321g1_pawnshop_backend.entity.customer.Customer;
import c0321g1_pawnshop_backend.repository.customer.CustomerRepository;
import c0321g1_pawnshop_backend.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Page<CusDTO> findAllCustomerAndCountContract(Pageable pageable) {
        return customerRepository.findAllCustomerAndCountContract(pageable);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteCustomer(id);
    }

    @Override
    public Customer findByIdCustomerDb(Long customerId) {
        return customerRepository.findByCustomer(customerId);
    }
}
