package c0321g1_pawnshop_backend.testContractController;

import c0321g1_pawnshop_backend.controller.contract.ContractRestController;
import c0321g1_pawnshop_backend.dto.contract.ContractDto;
import c0321g1_pawnshop_backend.dto.contract.StatusContractDto;
import c0321g1_pawnshop_backend.dto.contract.TypeContractDto;
import c0321g1_pawnshop_backend.dto.customer.CustomerDto;
import c0321g1_pawnshop_backend.entity.contract.Contract;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Optional;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CreateLiquidationContract {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ContractRestController contractRestController;

    @Test
    public void createContractLiquidation() throws Exception {
        ContractDto contractDto = new ContractDto();
        contractDto.setContractCode("HD-0006");
        contractDto.setProductName("Xe tăng");
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCustomerId((long) 1);
        contractDto.setCustomer(customerDto);
        contractDto.setDateLiquidation("2021-10-07");
        TypeContractDto typeContractDto = new TypeContractDto();
        typeContractDto.setTypeContractId((long) 1);
        contractDto.setTypeContract(typeContractDto);
        StatusContractDto statusContractDto = new StatusContractDto();
        statusContractDto.setStatusId((long) 1);
        contractDto.setStatusContract(statusContractDto);
        contractDto.setTotalMoney(10000);
        contractDto.setLoan(1000);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/contract/create-liquidation-contract")
                .contentType(MediaType.APPLICATION_JSON).content(this.objectMapper.writeValueAsString(contractDto))
        ).andDo(print()).andExpect(status().is2xxSuccessful());
    }

    @Test
    public void createContractLiquidation_dateLiquidation() throws Exception {
        ContractDto contractDto = new ContractDto();
        contractDto.setContractCode("HD-0006");
        contractDto.setProductName("Xe tăng");
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCustomerId((long) 1);
        contractDto.setCustomer(customerDto);
        contractDto.setDateLiquidation("2021-10-08");
        TypeContractDto typeContractDto = new TypeContractDto();
        typeContractDto.setTypeContractId((long) 1);
        contractDto.setTypeContract(typeContractDto);
        StatusContractDto statusContractDto = new StatusContractDto();
        statusContractDto.setStatusId((long) 1);
        contractDto.setStatusContract(statusContractDto);
        contractDto.setTotalMoney(10000);
        contractDto.setLoan(1000);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/contract/create-liquidation-contract")
                .contentType(MediaType.APPLICATION_JSON).content(this.objectMapper.writeValueAsString(contractDto))
        ).andDo(print()).andExpect(status().is4xxClientError());
    }

    @Test
    public void createContractLiquidation_contractCodeDuplication() throws Exception {
        ContractDto contractDto = new ContractDto();
        contractDto.setContractCode("HD-0006");
        contractDto.setProductName("Xe tăng");
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCustomerId((long) 1);
        contractDto.setCustomer(customerDto);
        contractDto.setDateLiquidation("2021-10-07");
        TypeContractDto typeContractDto = new TypeContractDto();
        typeContractDto.setTypeContractId((long) 1);
        contractDto.setTypeContract(typeContractDto);
        StatusContractDto statusContractDto = new StatusContractDto();
        statusContractDto.setStatusId((long) 1);
        contractDto.setStatusContract(statusContractDto);
        contractDto.setTotalMoney(10000);
        contractDto.setLoan(1000);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/contract/create-liquidation-contract")
                .contentType(MediaType.APPLICATION_JSON).content(this.objectMapper.writeValueAsString(contractDto))
        ).andDo(print()).andExpect(status().is4xxClientError());
    }

    @Test
    public void createContractLiquidation_contractCode() throws Exception {
        ContractDto contractDto = new ContractDto();
        contractDto.setContractCode("HD-000");
        contractDto.setProductName("Xe tăng");
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCustomerId((long) 1);
        contractDto.setCustomer(customerDto);
        contractDto.setDateLiquidation("2021-10-07");
        TypeContractDto typeContractDto = new TypeContractDto();
        typeContractDto.setTypeContractId((long) 1);
        contractDto.setTypeContract(typeContractDto);
        StatusContractDto statusContractDto = new StatusContractDto();
        statusContractDto.setStatusId((long) 1);
        contractDto.setStatusContract(statusContractDto);
        contractDto.setTotalMoney(10000);
        contractDto.setLoan(1000);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/contract/create-liquidation-contract")
                .contentType(MediaType.APPLICATION_JSON).content(this.objectMapper.writeValueAsString(contractDto))
        ).andDo(print()).andExpect(status().is4xxClientError());
    }

    @Test
    public void getContract_id() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/contract/findContract/{id}", "2"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void getContract_id_null() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/contract/findContract/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getContractPage()  {
        ResponseEntity<Page<Contract>> pageResponseEntity = this.contractRestController
                .getLiquidationProduct(PageRequest.of(0, 2));
        Page<Contract> contractPage = pageResponseEntity.getBody();
        int statusCode = pageResponseEntity.getStatusCodeValue();
        Assertions.assertEquals(200,statusCode);
        Assertions.assertEquals(4,contractPage.getTotalElements());
        Assertions.assertEquals(2,contractPage.getTotalPages());
        Assertions.assertEquals(3,contractPage.getContent().get(1).getContractId());
    }



}
