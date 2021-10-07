package c0321g1_pawnshop_backend.controller.customer;

import c0321g1_pawnshop_backend.entity.customer.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//Linh code
@SpringBootTest
@AutoConfigureMockMvc
public class CustomerRestController_getCustomerList {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    CustomerRestController customerRestController;

    @Test
    public void getCustomerList_5() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/customer"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getCustomerList_6() {
        ResponseEntity<Page<Customer>> pageResponseEntity = this.customerRestController.getCustomerList(
                PageRequest.of(0, 5));
        Page<Customer> customerPage = pageResponseEntity.getBody();
        int statusCode = pageResponseEntity.getStatusCodeValue();

        Assertions.assertEquals(200, statusCode);
        Assertions.assertEquals(1, customerPage.getTotalElements());
        Assertions.assertEquals(1, customerPage.getTotalPages());
        Assertions.assertEquals("Nguyễn Văn An", customerPage.getContent().get(0).getName());
        Assertions.assertEquals("KH-0001", customerPage.getContent().get(0).getCustomerCode());
    }
}
