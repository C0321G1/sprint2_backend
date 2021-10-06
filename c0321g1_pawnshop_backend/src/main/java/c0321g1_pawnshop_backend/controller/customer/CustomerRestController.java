package c0321g1_pawnshop_backend.controller.customer;

import c0321g1_pawnshop_backend.entity.customer.Customer;
import c0321g1_pawnshop_backend.service.customer.CustomerService;
import c0321g1_pawnshop_backend.service.customer.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/customer")
public class CustomerRestController {

    @Autowired
    private GenderService genderService;

    @Autowired
    private CustomerService customerService;

    //Linh code
    @GetMapping
    public ResponseEntity<Page<Customer>> getCustomerList(@PageableDefault(value = 5) Pageable pageable) {
        Page<Customer> customers = customerService.getCustomerList(pageable);
        if (customers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    //Linh code
    @GetMapping("/searchToCreateContract")
    public ResponseEntity<Page<Customer>> searchToCreateContract(@PageableDefault(value = 5) Pageable pageable,
                                                                 @RequestParam Optional<String> keyword) {
        String keywordValue = "";
        if (keyword.isPresent()) {
            keywordValue = keyword.get();
        }
        Page<Customer> customers = customerService.searchToCreateContract(keywordValue, pageable);
        if (customers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    //Linh code
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Long id) {

        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Optional<Customer> customerOptional = customerService.findById(id);
        return customerOptional.map(customer -> new ResponseEntity<>(customer, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
