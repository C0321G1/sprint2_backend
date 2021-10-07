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
public class Delete {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void deleteContract_id_25() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders
                        .patch("/contract/delete/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void deleteContract_id_27() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders
                        .patch("/contract/delete/{id}", 50))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void deleteContract_id_28() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders
                        .patch("/contract/delete/{id}", 1))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}