package c0321g1_pawnshop_backend.contract;

import c0321g1_pawnshop_backend.controller.contract.ContractRestController;
import c0321g1_pawnshop_backend.entity.contract.Contract;
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

@SpringBootTest
@AutoConfigureMockMvc
public class ContractRestController_getListContract {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ContractRestController contractRestController;

    //    creator: vinhdn
    @Test
    public void getAllContract_1() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/contract/list"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //    creator: vinhdn
    @Test
    public void getAllContract_2() {
        ResponseEntity<Page<Contract>> pageResponseEntity = this.contractRestController.getListContract(
                PageRequest.of(0, 3));
        Page<Contract> contractPage = pageResponseEntity.getBody();
        int statusCode = pageResponseEntity.getStatusCodeValue();

        Assertions.assertEquals(200, statusCode);
        Assertions.assertEquals(5, contractPage.getTotalElements());
        Assertions.assertEquals(2, contractPage.getTotalPages());
        Assertions.assertEquals("HD-001", contractPage.getContent().get(0).getContractCode());
        Assertions.assertEquals(1000, contractPage.getContent().get(0).getLoan());
        Assertions.assertEquals("IPhone 13", contractPage.getContent().get(0).getProductName());
    }
}

