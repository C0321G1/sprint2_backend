package c0321g1_pawnshop_backend.service_impl.customer;

import c0321g1_pawnshop_backend.dto.customer.CusDTO;
import c0321g1_pawnshop_backend.entity.customer.Customer;
import c0321g1_pawnshop_backend.repository.customer.CustomerRepository;
import c0321g1_pawnshop_backend.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Page<CusDTO> findAllCustomerAndCountContract(Pageable pageable) {
        return customerRepository.findAllCustomerAndCountContract(pageable);
    }

    @Override
    public Page<CusDTO> searchCustomerAndCountContract(Pageable pageable, String customerCode) {
        return customerRepository.searchCustomerAndCountContract(pageable, customerCode);
    }

    @Override
    public Page<CusDTO> searchKeyCustomerAndCountContract(Pageable pageable, String keySearch) {
        return customerRepository.searchKeyCustomerAndCountContract(pageable, keySearch);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteCustomer(id);
    }

    @Override
    public Optional<Customer> findCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public void saveCustomer(Customer customer) {
        customer.setFlag(1);
        customerRepository.save(customer);
    }

    //Linh code
    @Override
    public Page<Customer> getCustomerList(Pageable pageable) {
        return customerRepository.getCustomerList(pageable);
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    //Linh code
    @Override
    public Page<Customer> searchToCreateContract(String keywordValue, Pageable pageable) {
        return customerRepository.searchToCreateContract(keywordValue, pageable);
    }

}