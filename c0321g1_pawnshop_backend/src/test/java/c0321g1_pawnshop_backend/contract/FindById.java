package c0321g1_pawnshop_backend.contract;


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
class FindById {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void findById_1() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/contract/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void findById_3() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/contract/{id}", 30))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void findById_4() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/contract/{id}", 1))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}

