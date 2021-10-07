package c0321g1_pawnshop_backend.contract;

import c0321g1_pawnshop_backend.controller.contract.ContractRestController;
import c0321g1_pawnshop_backend.dto.contract.ContractDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ContractRestController_paymentContract {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ContractRestController contractRestController;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void searchContract_1() throws Exception {
        ContractDto contractDto = new ContractDto();

        contractDto.setContractId(null);

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/contract/payment")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(contractDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }
    @Test
    public void searchContract_2() throws Exception {
        ContractDto contractDto = new ContractDto();

        contractDto.setContractId(1L);
        contractDto.setTotalMoney(3000);

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/contract/payment")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(contractDto)))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());

    }
}
