package c0321g1_pawnshop_backend.customerRestController;

import c0321g1_pawnshop_backend.controller.customer.CustomerRestController;
import c0321g1_pawnshop_backend.dto.customer.CusDTO;
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
public class CustomerRestController_getAllList {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    CustomerRestController customerRestController;

    @Test
    public void getAllCustomer_5() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/customer/list"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getAllCustomer_6() {
        ResponseEntity<Page<CusDTO>> pageResponseEntity =
                this.customerRestController.findAllCustomerAndCountContract(PageRequest.of(0, 2));
        Page<CusDTO> cusDTOPage = pageResponseEntity.getBody();
        int statusCode = pageResponseEntity.getStatusCodeValue();
        Assertions.assertEquals(200, statusCode);
        Assertions.assertEquals(5, cusDTOPage.getTotalElements());
        Assertions.assertEquals(3, cusDTOPage.getTotalPages());
        Assertions.assertEquals(1, cusDTOPage.getContent().get(0).getCustomerId());
        Assertions.assertEquals("Nguyễn Văn A", cusDTOPage.getContent().get(0).getCustomerName());
        Assertions.assertEquals("1980-3-8", cusDTOPage.getContent().get(0).getBirthDate());
        Assertions.assertEquals("2015123456", cusDTOPage.getContent().get(0).getIdCard());
        Assertions.assertEquals("0905123456", cusDTOPage.getContent().get(0).getPhone());
        Assertions.assertEquals("anguyen@gmail.com", cusDTOPage.getContent().get(0).getEmail());
        Assertions.assertEquals("Nam", cusDTOPage.getContent().get(0).getGenderName());
        Assertions.assertEquals("68 Nguyễn Văn Linh", cusDTOPage.getContent().get(0).getAddress());
    }
}
