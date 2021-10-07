package c0321g1_pawnshop_backend.controller.customer;

import c0321g1_pawnshop_backend.dto.customer.CusDTO;
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

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping
public class CustomerRestController {
    @Autowired
    private GenderService genderService;

    @Autowired
    private CustomerService customerService;

    // Dong: method get list customer and count amount contract
    @GetMapping("customer/list")
    public ResponseEntity<Page<CusDTO>> findAllCustomerAndCountContract(@PageableDefault(value = 2) Pageable pageable) {
        Page<CusDTO> cusDTOPage = customerService.findAllCustomerAndCountContract(pageable);
        if (cusDTOPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(cusDTOPage, HttpStatus.OK);
    }

    // Dong: method delete customer with id
    @DeleteMapping("/customer/delete/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        this.customerService.deleteCustomer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/customer/{id}")
    @ResponseBody
    public ResponseEntity<Customer> findByIdCustomer(@PathVariable("id") Long customerId) {
        if (customerId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Customer customer = customerService.findByIdCustomerDb(customerId);
        if (customer != null) {
            return new ResponseEntity<>(customer, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
