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

import java.util.Optional;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ContractRestController_searchContract {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ContractRestController contractRestController;

    @Test
    public void searchComputer_1() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/contract/search/abc,abc,abc,abc"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void searchComputer_2() {
        ResponseEntity<Page<Contract>> pageResponseEntity = this.contractRestController.searchContract(
                PageRequest.of(0, 3),"HD-001",
             "Nguyen Van A", "IPhone 13", "2021-10-05");
        Page<Contract> computerPage = pageResponseEntity.getBody();
        int statusCode = pageResponseEntity.getStatusCodeValue();

        Assertions.assertEquals(200, statusCode);
        Assertions.assertEquals(1, computerPage.getTotalElements());
        Assertions.assertEquals(1, computerPage.getTotalPages());
        Assertions.assertEquals("HD-001", computerPage.getContent().get(0).getContractCode());
        Assertions.assertEquals("Nguyen Van A", computerPage.getContent().get(0).getCustomer().getName());
        Assertions.assertEquals("IPhone 13", computerPage.getContent().get(0).getProductName());
        Assertions.assertEquals("2021-10-05", computerPage.getContent().get(0).getStartDate());
    }
}
