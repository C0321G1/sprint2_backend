package c0321g1_pawnshop_backend.controller.customer;

import c0321g1_pawnshop_backend.dto.customer.CusDTO;
import c0321g1_pawnshop_backend.dto.customer.CustomerDto;
import c0321g1_pawnshop_backend.entity.customer.Customer;
import c0321g1_pawnshop_backend.entity.customer.Gender;
import c0321g1_pawnshop_backend.service.customer.CustomerService;
import c0321g1_pawnshop_backend.service.customer.GenderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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

    //     Dong: method get list customer and count amount contract
    @GetMapping("customer/list")
    public ResponseEntity<Page<CusDTO>> findAllCustomerAndCountContract(@PageableDefault(value = 5) Pageable pageable) {
        Page<CusDTO> cusDTOPage = customerService.findAllCustomerAndCountContract(pageable);
        if (cusDTOPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cusDTOPage, HttpStatus.OK);
    }

    //     Dong: method search list customer and count amount contract
    @GetMapping("customer/search")
    public ResponseEntity<Page<CusDTO>> searchCustomerAndCountContract(@PageableDefault(value = 2) Pageable pageable,
                                                                       @RequestParam(defaultValue = "customerCode") String customerCode) {
        Page<CusDTO> cusDTOPage = customerService.searchCustomerAndCountContract(pageable, customerCode);
        if (cusDTOPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cusDTOPage, HttpStatus.OK);
    }

    @GetMapping("customer/searchKey")
    public ResponseEntity<Page<CusDTO>> searchKeyCustomerAndCountContract(@PageableDefault(value = 5) Pageable pageable,
                                                                          @RequestParam(defaultValue = "keySearch") String keySearch) {
        Page<CusDTO> cusDTOPage = customerService.searchKeyCustomerAndCountContract(pageable, keySearch);
        if (cusDTOPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cusDTOPage, HttpStatus.OK);
    }

    // Dong: method delete customer with id
    @DeleteMapping("/customer/delete/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        this.customerService.deleteCustomer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

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

    @GetMapping("/customer/gender")
    public ResponseEntity<Iterable<Gender>> findAllGender() {
        List<Gender> genders = genderService.findAll();
        if (genders.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(genders, HttpStatus.OK);
    }

    //Linh code
    @GetMapping
    public ResponseEntity<Page<Customer>> getCustomerList(@PageableDefault(value = 4) Pageable pageable) {
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