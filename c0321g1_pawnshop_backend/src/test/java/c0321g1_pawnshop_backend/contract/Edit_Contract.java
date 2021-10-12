package c0321g1_pawnshop_backend.contract;


import c0321g1_pawnshop_backend.entity.contract.Contract;
import c0321g1_pawnshop_backend.entity.contract.StatusContract;
import c0321g1_pawnshop_backend.entity.contract.TypeContract;
import c0321g1_pawnshop_backend.entity.contract.TypeProduct;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class Edit_Contract {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getInfoContract_id_1() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/contract/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getInfoContract_id_3() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/contract/{id}", 99))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getInfoContract_id_2() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/contract/{id}", 13))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.contractCode").value("HD-0001"))
                .andExpect(jsonPath("$.startDate").value("2021-10-20"))
                .andExpect(jsonPath("$.endDate").value("2021-12-11"))
                .andExpect(jsonPath("$.productName").value("Nhung"))
                .andExpect(jsonPath("$.loan").value(10000))
                .andExpect(jsonPath("$.profit").value(5));
    }


    @Test
    public void editContract_name_13() throws Exception {
        Contract contract = new Contract();
        contract.setContractCode(null);
        contract.setEndDate("2021-10-13");
        contract.setStartDate("2021-9-10");
        contract.setProductName("Nhung");
        contract.setProfit(5);
        contract.setLoan(100000);

        StatusContract statusContract = new StatusContract();
        statusContract.setStatusId(1L);
        contract.setStatusContract(statusContract);

        TypeContract typeContract = new TypeContract();
        typeContract.setTypeContractId(1L);
        contract.setTypeContract(typeContract);

        TypeProduct typeProduct = new TypeProduct();
        typeProduct.setTypeProductId(1L);
        contract.setTypeProduct(typeProduct);

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .patch("/contract/{id}",13)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(contract)))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editContract_name_14() throws Exception {
        Contract contract = new Contract();
        contract.setContractCode("HD-0001");
        contract.setEndDate(null);
        contract.setStartDate("2021-9-10");
        contract.setProductName("Nhung");
        contract.setProfit(5);
        contract.setLoan(100000);

        StatusContract statusContract = new StatusContract();
        statusContract.setStatusId(1L);
        contract.setStatusContract(statusContract);

        TypeContract typeContract = new TypeContract();
        typeContract.setTypeContractId(1L);
        contract.setTypeContract(typeContract);

        TypeProduct typeProduct = new TypeProduct();
        typeProduct.setTypeProductId(1L);
        contract.setTypeProduct(typeProduct);

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .patch("/contract/{id}",13)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(contract)))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editContract_name_15() throws Exception {
        Contract contract = new Contract();
        contract.setContractCode("HD-0001");
        contract.setEndDate("2021-10-12");
        contract.setStartDate(null);
        contract.setProductName("Nhung");
        contract.setProfit(5);
        contract.setLoan(100000);

        StatusContract statusContract = new StatusContract();
        statusContract.setStatusId(1L);
        contract.setStatusContract(statusContract);

        TypeContract typeContract = new TypeContract();
        typeContract.setTypeContractId(1L);
        contract.setTypeContract(typeContract);

        TypeProduct typeProduct = new TypeProduct();
        typeProduct.setTypeProductId(1L);
        contract.setTypeProduct(typeProduct);

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .patch("/contract/{id}",13)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(contract)))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editContract_name_16() throws Exception {
        Contract contract = new Contract();
        contract.setContractCode("HD-0001");
        contract.setEndDate("2021-10-12");
        contract.setStartDate("2021-9-10");
        contract.setProductName(null);
        contract.setProfit(5);
        contract.setLoan(100000);

        StatusContract statusContract = new StatusContract();
        statusContract.setStatusId(1L);
        contract.setStatusContract(statusContract);

        TypeContract typeContract = new TypeContract();
        typeContract.setTypeContractId(1L);
        contract.setTypeContract(typeContract);

        TypeProduct typeProduct = new TypeProduct();
        typeProduct.setTypeProductId(1L);
        contract.setTypeProduct(typeProduct);

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .patch("/contract/{id}",13)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(contract)))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    @Test
    public void editContract_name_17() throws Exception {
        Contract contract = new Contract();
        contract.setContractCode("HD-0001");
        contract.setEndDate("2021-10-12");
        contract.setStartDate("2021-9-10");
        contract.setProductName("Nhung");
        contract.setProfit(0);
        contract.setLoan(100000);

        StatusContract statusContract = new StatusContract();
        statusContract.setStatusId(1L);
        contract.setStatusContract(statusContract);

        TypeContract typeContract = new TypeContract();
        typeContract.setTypeContractId(1L);
        contract.setTypeContract(typeContract);

        TypeProduct typeProduct = new TypeProduct();
        typeProduct.setTypeProductId(1L);
        contract.setTypeProduct(typeProduct);

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .patch("/contract/{id}",13)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(contract)))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    @Test
    public void editContract_name_18() throws Exception {
        Contract contract = new Contract();
        contract.setContractCode("HD-0001");
        contract.setEndDate("2021-10-12");
        contract.setStartDate("2021-9-10");
        contract.setProductName("Nhung");
        contract.setProfit(5);
        contract.setLoan(0);

        StatusContract statusContract = new StatusContract();
        statusContract.setStatusId(1L);
        contract.setStatusContract(statusContract);

        TypeContract typeContract = new TypeContract();
        typeContract.setTypeContractId(1L);
        contract.setTypeContract(typeContract);

        TypeProduct typeProduct = new TypeProduct();
        typeProduct.setTypeProductId(1L);
        contract.setTypeProduct(typeProduct);

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .patch("/contract/{id}",13)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(contract)))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editContract_name_19() throws Exception {
        Contract contract = new Contract();
        contract.setContractCode("HD-0001");
        contract.setEndDate("2021-10-12");
        contract.setStartDate("2021-9-10");
        contract.setProductName("Nhung");
        contract.setProfit(5);
        contract.setLoan(100000);

        StatusContract statusContract = new StatusContract();
        statusContract.setStatusId(0L);
        contract.setStatusContract(statusContract);

        TypeContract typeContract = new TypeContract();
        typeContract.setTypeContractId(1L);
        contract.setTypeContract(typeContract);

        TypeProduct typeProduct = new TypeProduct();
        typeProduct.setTypeProductId(1L);
        contract.setTypeProduct(typeProduct);

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .patch("/contract/{id}",13)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(contract)))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editContract_name_20() throws Exception {
        Contract contract = new Contract();
        contract.setContractCode("HD-0001");
        contract.setEndDate("2021-10-12");
        contract.setStartDate("2021-9-10");
        contract.setProductName("Nhung");
        contract.setProfit(5);
        contract.setLoan(100000);

        StatusContract statusContract = new StatusContract();
        statusContract.setStatusId(1L);
        contract.setStatusContract(statusContract);

        TypeContract typeContract = new TypeContract();
        typeContract.setTypeContractId(0L);
        contract.setTypeContract(typeContract);

        TypeProduct typeProduct = new TypeProduct();
        typeProduct.setTypeProductId(1L);
        contract.setTypeProduct(typeProduct);

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .patch("/contract/{id}",13)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(contract)))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    @Test
    public void editContract_name_21() throws Exception {
        Contract contract = new Contract();
        contract.setContractCode("HD-0001");
        contract.setEndDate("2021-10-12");
        contract.setStartDate("2021-9-10");
        contract.setProductName("Nhung");
        contract.setProfit(5);
        contract.setLoan(100000);

        StatusContract statusContract = new StatusContract();
        statusContract.setStatusId(1L);
        contract.setStatusContract(statusContract);

        TypeContract typeContract = new TypeContract();
        typeContract.setTypeContractId(1L);
        contract.setTypeContract(typeContract);

        TypeProduct typeProduct = new TypeProduct();
        typeProduct.setTypeProductId(0L);
        contract.setTypeProduct(typeProduct);

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .patch("/contract/{id}",13)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(contract)))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
