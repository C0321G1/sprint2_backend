package c0321g1_pawnshop_backend.contract;

import c0321g1_pawnshop_backend.controller.contract.ContractRestController;
import c0321g1_pawnshop_backend.entity.contract.Contract;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
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
public class PageConntract {

    @MockBean
    public ContractRestController contractRestController;

    @Autowired
    private MockMvc mockMvc;



    @Test
    public void pageContractAll_5() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/contract/list"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void pageContractAll_6() {
        ResponseEntity<Page<Contract>> pageResponseEntity
                = this.contractRestController.getAllContract(
                PageRequest.of(0,1));
        Page<Contract> contractPage = pageResponseEntity.getBody();
        int statusCode = pageResponseEntity.getStatusCodeValue();

        Assertions.assertEquals(200, statusCode);
        Assertions.assertEquals(1, contractPage.getTotalElements());
        Assertions.assertEquals(1, contractPage.getTotalPages());
        Assertions.assertEquals("SV-0002", contractPage.getContent().get(0).getContractCode());
        Assertions.assertEquals("2021-11-12", contractPage.getContent().get(0).getEndDate());
        Assertions.assertEquals("2021-10-09", contractPage.getContent().get(0).getStartDate());
        Assertions.assertEquals("Nhung", contractPage.getContent().get(0).getProductName());


//        Assertions.assertEquals(1, servicesPage.getContent().get(0).getName());
        //...
    }
}
