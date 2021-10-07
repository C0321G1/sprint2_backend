package c0321g1_pawnshop_backend.controller.contract;


import c0321g1_pawnshop_backend.dto.contract.ContractDto;
import c0321g1_pawnshop_backend.entity.contract.StatusContract;
import c0321g1_pawnshop_backend.entity.contract.TypeContract;
import c0321g1_pawnshop_backend.entity.contract.TypeProduct;
import c0321g1_pawnshop_backend.entity.customer.Customer;
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

//Linh code
@SpringBootTest
@AutoConfigureMockMvc
public class ContractRestController_createContract {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void createContract_contractCode_13() throws Exception {
        ContractDto contractDto = new ContractDto();

        contractDto.setContractCode(null);
        contractDto.setStartDate("2021-10-07");
        contractDto.setEndDate("2021-10-20");
        contractDto.setProductName("Laptop Dell 7440");
        contractDto.setLoan(5000000);

        TypeProduct typeProduct = new TypeProduct();
        typeProduct.setTypeProductId(1L);
        contractDto.setTypeProduct(typeProduct);

        StatusContract statusContract = new StatusContract();
        statusContract.setStatusId(1L);
        contractDto.setStatusContract(statusContract);

        TypeContract typeContract = new TypeContract();
        typeContract.setTypeContractId(1L);
        contractDto.setTypeContract(typeContract);

        Customer customer = new Customer();
        customer.setCustomerId(1L);
        contractDto.setCustomer(customer);

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/contract")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(contractDto)))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void createContract_contractCode_14() throws Exception {
        ContractDto contractDto = new ContractDto();

        contractDto.setContractCode("");
        contractDto.setStartDate("2021-10-07");
        contractDto.setEndDate("2021-10-20");
        contractDto.setProductName("Laptop Dell 7440");
        contractDto.setLoan(5000000);

        TypeProduct typeProduct = new TypeProduct();
        typeProduct.setTypeProductId(1L);
        contractDto.setTypeProduct(typeProduct);

        StatusContract statusContract = new StatusContract();
        statusContract.setStatusId(1L);
        contractDto.setStatusContract(statusContract);

        TypeContract typeContract = new TypeContract();
        typeContract.setTypeContractId(1L);
        contractDto.setTypeContract(typeContract);

        Customer customer = new Customer();
        customer.setCustomerId(1L);
        contractDto.setCustomer(customer);

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/contract")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(contractDto)))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void createContract_contractCode_15() throws Exception {
        ContractDto contractDto = new ContractDto();

        contractDto.setContractCode("HD-001");
        contractDto.setStartDate("2021-10-07");
        contractDto.setEndDate("2021-10-20");
        contractDto.setProductName("Laptop Dell 7440");
        contractDto.setLoan(5000000);

        TypeProduct typeProduct = new TypeProduct();
        typeProduct.setTypeProductId(1L);
        contractDto.setTypeProduct(typeProduct);

        StatusContract statusContract = new StatusContract();
        statusContract.setStatusId(1L);
        contractDto.setStatusContract(statusContract);

        TypeContract typeContract = new TypeContract();
        typeContract.setTypeContractId(1L);
        contractDto.setTypeContract(typeContract);

        Customer customer = new Customer();
        customer.setCustomerId(1L);
        contractDto.setCustomer(customer);

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/contract")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(contractDto)))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void createContract_startDate_14() throws Exception {
        ContractDto contractDto = new ContractDto();

        contractDto.setContractCode("HD-0002");
        contractDto.setStartDate("");
        contractDto.setEndDate("2021-10-20");
        contractDto.setProductName("Laptop Dell 7440");
        contractDto.setLoan(5000000);

        TypeProduct typeProduct = new TypeProduct();
        typeProduct.setTypeProductId(1L);
        contractDto.setTypeProduct(typeProduct);

        StatusContract statusContract = new StatusContract();
        statusContract.setStatusId(1L);
        contractDto.setStatusContract(statusContract);

        TypeContract typeContract = new TypeContract();
        typeContract.setTypeContractId(1L);
        contractDto.setTypeContract(typeContract);

        Customer customer = new Customer();
        customer.setCustomerId(1L);
        contractDto.setCustomer(customer);

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/contract")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(contractDto)))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void createContract_startDate_15() throws Exception {
        ContractDto contractDto = new ContractDto();

        contractDto.setContractCode("HD-0002");
        contractDto.setStartDate("2021-10-06");
        contractDto.setEndDate("2021-10-20");
        contractDto.setProductName("Laptop Dell 7440");
        contractDto.setLoan(5000000);

        TypeProduct typeProduct = new TypeProduct();
        typeProduct.setTypeProductId(1L);
        contractDto.setTypeProduct(typeProduct);

        StatusContract statusContract = new StatusContract();
        statusContract.setStatusId(1L);
        contractDto.setStatusContract(statusContract);

        TypeContract typeContract = new TypeContract();
        typeContract.setTypeContractId(1L);
        contractDto.setTypeContract(typeContract);

        Customer customer = new Customer();
        customer.setCustomerId(1L);
        contractDto.setCustomer(customer);

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/contract")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(contractDto)))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void createContract_endDate_14() throws Exception {
        ContractDto contractDto = new ContractDto();

        contractDto.setContractCode("HD-0002");
        contractDto.setStartDate("2021-10-07");
        contractDto.setEndDate("");
        contractDto.setProductName("Laptop Dell 7440");
        contractDto.setLoan(5000000);

        TypeProduct typeProduct = new TypeProduct();
        typeProduct.setTypeProductId(1L);
        contractDto.setTypeProduct(typeProduct);

        StatusContract statusContract = new StatusContract();
        statusContract.setStatusId(1L);
        contractDto.setStatusContract(statusContract);

        TypeContract typeContract = new TypeContract();
        typeContract.setTypeContractId(1L);
        contractDto.setTypeContract(typeContract);

        Customer customer = new Customer();
        customer.setCustomerId(1L);
        contractDto.setCustomer(customer);

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/contract")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(contractDto)))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void createContract_endDate_15() throws Exception {
        ContractDto contractDto = new ContractDto();

        contractDto.setContractCode("HD-0002");
        contractDto.setStartDate("2021-10-07");
        contractDto.setEndDate("2021-10-07");
        contractDto.setProductName("Laptop Dell 7440");
        contractDto.setLoan(5000000);

        TypeProduct typeProduct = new TypeProduct();
        typeProduct.setTypeProductId(1L);
        contractDto.setTypeProduct(typeProduct);

        StatusContract statusContract = new StatusContract();
        statusContract.setStatusId(1L);
        contractDto.setStatusContract(statusContract);

        TypeContract typeContract = new TypeContract();
        typeContract.setTypeContractId(1L);
        contractDto.setTypeContract(typeContract);

        Customer customer = new Customer();
        customer.setCustomerId(1L);
        contractDto.setCustomer(customer);

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/contract")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(contractDto)))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void createContract_productName_13() throws Exception {
        ContractDto contractDto = new ContractDto();

        contractDto.setContractCode("HD-0002");
        contractDto.setStartDate("2021-10-07");
        contractDto.setEndDate("2021-10-20");
        contractDto.setProductName(null);
        contractDto.setLoan(5000000);

        TypeProduct typeProduct = new TypeProduct();
        typeProduct.setTypeProductId(1L);
        contractDto.setTypeProduct(typeProduct);

        StatusContract statusContract = new StatusContract();
        statusContract.setStatusId(1L);
        contractDto.setStatusContract(statusContract);

        TypeContract typeContract = new TypeContract();
        typeContract.setTypeContractId(1L);
        contractDto.setTypeContract(typeContract);

        Customer customer = new Customer();
        customer.setCustomerId(1L);
        contractDto.setCustomer(customer);

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/contract")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(contractDto)))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void createContract_productName_14() throws Exception {
        ContractDto contractDto = new ContractDto();

        contractDto.setContractCode("HD-0002");
        contractDto.setStartDate("2021-10-07");
        contractDto.setEndDate("2021-10-20");
        contractDto.setProductName("");
        contractDto.setLoan(5000000);

        TypeProduct typeProduct = new TypeProduct();
        typeProduct.setTypeProductId(1L);
        contractDto.setTypeProduct(typeProduct);

        StatusContract statusContract = new StatusContract();
        statusContract.setStatusId(1L);
        contractDto.setStatusContract(statusContract);

        TypeContract typeContract = new TypeContract();
        typeContract.setTypeContractId(1L);
        contractDto.setTypeContract(typeContract);

        Customer customer = new Customer();
        customer.setCustomerId(1L);
        contractDto.setCustomer(customer);

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/contract")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(contractDto)))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void createContract_productName_17() throws Exception {
        ContractDto contractDto = new ContractDto();

        contractDto.setContractCode("HD-0002");
        contractDto.setStartDate("2021-10-07");
        contractDto.setEndDate("2021-10-20");
        contractDto.setProductName("Laptop Dell 7440aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        contractDto.setLoan(5000000);

        TypeProduct typeProduct = new TypeProduct();
        typeProduct.setTypeProductId(1L);
        contractDto.setTypeProduct(typeProduct);

        StatusContract statusContract = new StatusContract();
        statusContract.setStatusId(1L);
        contractDto.setStatusContract(statusContract);

        TypeContract typeContract = new TypeContract();
        typeContract.setTypeContractId(1L);
        contractDto.setTypeContract(typeContract);

        Customer customer = new Customer();
        customer.setCustomerId(1L);
        contractDto.setCustomer(customer);

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/contract")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(contractDto)))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void createContract_loan_15() throws Exception {
        ContractDto contractDto = new ContractDto();

        contractDto.setContractCode("HD-0002");
        contractDto.setStartDate("2021-10-07");
        contractDto.setEndDate("2021-10-20");
        contractDto.setProductName("Laptop Dell 7440");
        contractDto.setLoan(49999);

        TypeProduct typeProduct = new TypeProduct();
        typeProduct.setTypeProductId(1L);
        contractDto.setTypeProduct(typeProduct);

        StatusContract statusContract = new StatusContract();
        statusContract.setStatusId(1L);
        contractDto.setStatusContract(statusContract);

        TypeContract typeContract = new TypeContract();
        typeContract.setTypeContractId(1L);
        contractDto.setTypeContract(typeContract);

        Customer customer = new Customer();
        customer.setCustomerId(1L);
        contractDto.setCustomer(customer);

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/contract")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(contractDto)))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void createContract_18() throws Exception {
        ContractDto contractDto = new ContractDto();

        contractDto.setContractCode("HD-0006");
        contractDto.setStartDate("2021-10-07");
        contractDto.setEndDate("2021-10-20");
        contractDto.setProductName("Laptop Dell 7440");
        contractDto.setLoan(10000000);
        contractDto.setProfit(100000);
        contractDto.setDateLiquidation("2021-10-21");
        contractDto.setFlag(1);
        contractDto.setProductImage("image test");
        contractDto.setTotalMoney(0);

        TypeProduct typeProduct = new TypeProduct();
        typeProduct.setTypeProductId(1L);
        contractDto.setTypeProduct(typeProduct);

        StatusContract statusContract = new StatusContract();
        statusContract.setStatusId(1L);
        contractDto.setStatusContract(statusContract);

        TypeContract typeContract = new TypeContract();
        typeContract.setTypeContractId(1L);
        contractDto.setTypeContract(typeContract);

        Customer customer = new Customer();
        customer.setCustomerId(1L);
        contractDto.setCustomer(customer);

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/contract")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(contractDto)))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

}