package c0321g1_pawnshop_backend.controller.customer;

import c0321g1_pawnshop_backend.dto.customer.CustomerDto;
import c0321g1_pawnshop_backend.entity.customer.Customer;
import c0321g1_pawnshop_backend.entity.customer.Gender;
import c0321g1_pawnshop_backend.service.customer.CustomerService;
import c0321g1_pawnshop_backend.service.customer.GenderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CustomerRestController {
    @Autowired
    private GenderService genderService;
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> findById(@PathVariable Long id) {
        Optional<Customer> customerOptional = customerService.findCustomerById(id);
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customerOptional.get(), HttpStatus.OK);
    }

    @PostMapping("/customer")
    public ResponseEntity<Void> saveCustomer(@Valid @RequestBody CustomerDto customerDto, BindingResult bindingResult) {
        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        customerService.saveCustomer(customer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping("/customer")
    public ResponseEntity<Void> editCustomer(@Valid @RequestBody CustomerDto customerDto, BindingResult bindingResult) {
        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Customer customer = customerService.findCustomerById(customerDto.getCustomerId()).get();
        BeanUtils.copyProperties(customerDto, customer);
        customerService.saveCustomer(customer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/gender")
    public ResponseEntity<Iterable<Gender>> findAllGender() {
        List<Gender> genders = genderService.findAll();
        if (genders.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(genders, HttpStatus.OK);
    }
}
