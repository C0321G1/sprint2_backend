package c0321g1_pawnshop_backend.controller.customer;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//Linh code
@SpringBootTest
@AutoConfigureMockMvc
public class CustomerRestController_getCustomer {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getCustomer_id_1() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/customer/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getCustomer_id_3() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/customer/{id}", 50))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getCustomer_id_4() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/customer/{id}", 1))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.customerId").value(1))
                .andExpect(jsonPath("$.customerCode").value("KH-0001"))
                .andExpect(jsonPath("$.name").value("Nguyễn Văn An"));
    }
}
