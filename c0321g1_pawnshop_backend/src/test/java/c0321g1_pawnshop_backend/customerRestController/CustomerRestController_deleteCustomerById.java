package c0321g1_pawnshop_backend.customerRestController;

import c0321g1_pawnshop_backend.controller.customer.CustomerRestController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerRestController_deleteCustomerById {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CustomerRestController customerRestController;

    @Test
    public void deleteCustomerById_28() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.delete("/customer/delete/{id}", 2))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    @Test
    public void deleteCustomerById_25() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.delete("/customer/delete/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
