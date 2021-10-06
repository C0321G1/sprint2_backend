package c0321g1_pawnshop_backend.service_impl.customer;

import c0321g1_pawnshop_backend.repository.customer.CustomerRepository;
import c0321g1_pawnshop_backend.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

}
