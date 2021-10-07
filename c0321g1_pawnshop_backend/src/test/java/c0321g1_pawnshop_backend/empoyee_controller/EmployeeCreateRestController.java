package c0321g1_pawnshop_backend.empoyee_controller;

import c0321g1_pawnshop_backend.dto.customer.GenderDto;
import c0321g1_pawnshop_backend.dto.employee.EmployeeDto;
import c0321g1_pawnshop_backend.dto.security.AccountDto;
import c0321g1_pawnshop_backend.entity.customer.Gender;
import c0321g1_pawnshop_backend.entity.security.Account;
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
public class EmployeeCreateRestController {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void createEmployee_code_1() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmployeeCode(null);
        employeeDto.setAddress("Đà Nẵng");
        employeeDto.setBirthDate("2000-12-12");
        employeeDto.setEmail("hauhp@gmail.com");
        employeeDto.setFlag((long) 0);
        employeeDto.setIdCard("123123123");
        employeeDto.setImage("ko");
        employeeDto.setName("Huỳnh Phước Hậu");
        employeeDto.setPhone("0905123123");
        employeeDto.setSalary("9000000");


        GenderDto genderDto = new GenderDto();
        genderDto.setGenderId(1L);
        genderDto.setName("nam");
        employeeDto.setGenderDto(genderDto);

        AccountDto accountDto = new AccountDto();
        accountDto.setAccountId(1L);
        accountDto.setUsername("hauhp");
        accountDto.setPassword("123123");
        accountDto.setUserTime("2021-10-10");
        employeeDto.setAccountDto(accountDto);
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/employee/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(employeeDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createEmployee_code_2() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmployeeCode("NV-1234");
        employeeDto.setAddress("Đà Nẵng");
        employeeDto.setBirthDate("2000-12-12");
        employeeDto.setEmail("hauhp@gmail.com");
        employeeDto.setFlag((long) 0);
        employeeDto.setIdCard("123123123");
        employeeDto.setImage("ko");
        employeeDto.setName(null);
        employeeDto.setPhone("0905123123");
        employeeDto.setSalary("9000000");


        GenderDto genderDto = new GenderDto();
        genderDto.setGenderId(1L);
        genderDto.setName("nam");
        employeeDto.setGenderDto(genderDto);

        AccountDto accountDto = new AccountDto();
        accountDto.setAccountId(12L);
        accountDto.setUsername("hauhpvv");
        accountDto.setPassword("123123");
        accountDto.setUserTime("2021-10-10");
        employeeDto.setAccountDto(accountDto);
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/employee/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(employeeDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createEmployee_code_3() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmployeeCode("NV-1234");
        employeeDto.setAddress("Đà Nẵng");
        employeeDto.setBirthDate(null);
        employeeDto.setEmail("hauhp@gmail.com");
        employeeDto.setFlag((long) 0);
        employeeDto.setIdCard("123123123");
        employeeDto.setImage("ko");
        employeeDto.setName("Huỳnh Phước Hậu");
        employeeDto.setPhone("0905123123");
        employeeDto.setSalary("9000000");


        GenderDto genderDto = new GenderDto();
        genderDto.setGenderId(1L);
        genderDto.setName("nam");
        employeeDto.setGenderDto(genderDto);

        AccountDto accountDto = new AccountDto();
        accountDto.setAccountId(1L);
        accountDto.setUsername("hauhp");
        accountDto.setPassword("123123");
        accountDto.setUserTime("2021-10-10");
        employeeDto.setAccountDto(accountDto);
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/employee/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(employeeDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createEmployee_code_4() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmployeeCode("NV-1234");
        employeeDto.setAddress("Đà Nẵng");
        employeeDto.setBirthDate("2000-12-12");
        employeeDto.setEmail("hauhp@gmail.com");
        employeeDto.setFlag((long) 0);
        employeeDto.setIdCard("123123123");
        employeeDto.setImage("ko");
        employeeDto.setName("Huỳnh Phước Hậu");
        employeeDto.setPhone("0905123123");
        employeeDto.setSalary("9000000");


        GenderDto genderDto = new GenderDto();
        genderDto.setGenderId(1L);
        genderDto.setName("nam");
        employeeDto.setGenderDto(null);

        AccountDto accountDto = new AccountDto();
        accountDto.setAccountId(1L);
        accountDto.setUsername("hauhp");
        accountDto.setPassword("123123");
        accountDto.setUserTime("2021-10-10");
        employeeDto.setAccountDto(accountDto);
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/employee/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(employeeDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createEmployee_code_5() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmployeeCode("NV-1234");
        employeeDto.setAddress("Đà Nẵng");
        employeeDto.setBirthDate("2000-12-12");
        employeeDto.setEmail(null);
        employeeDto.setFlag((long) 0);
        employeeDto.setIdCard("123123123");
        employeeDto.setImage("ko");
        employeeDto.setName("Huỳnh Phước Hậu");
        employeeDto.setPhone("0905123123");
        employeeDto.setSalary("9000000");


        GenderDto genderDto = new GenderDto();
        genderDto.setGenderId(1L);
        genderDto.setName("nam");
        employeeDto.setGenderDto(genderDto);

        AccountDto accountDto = new AccountDto();
        accountDto.setAccountId(1L);
        accountDto.setUsername("hauhp");
        accountDto.setPassword("123123");
        accountDto.setUserTime("2021-10-10");
        employeeDto.setAccountDto(accountDto);
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/employee/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(employeeDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createEmployee_code_6() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmployeeCode("NV-1234");
        employeeDto.setAddress("Đà Nẵng");
        employeeDto.setBirthDate("2000-12-12");
        employeeDto.setEmail("hauhp");
        employeeDto.setFlag((long) 0);
        employeeDto.setIdCard("123123123");
        employeeDto.setImage("ko");
        employeeDto.setName("Huỳnh Phước Hậu");
        employeeDto.setPhone("0905123123");
        employeeDto.setSalary("9000000");


        GenderDto genderDto = new GenderDto();
        genderDto.setGenderId(1L);
        genderDto.setName("nam");
        employeeDto.setGenderDto(genderDto);

        AccountDto accountDto = new AccountDto();
        accountDto.setAccountId(1L);
        accountDto.setUsername("hauhp");
        accountDto.setPassword("123123");
        accountDto.setUserTime("2021-10-10");
        employeeDto.setAccountDto(accountDto);
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/employee/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(employeeDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createEmployee_code_7() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmployeeCode("NV1234");
        employeeDto.setAddress(null);
        employeeDto.setBirthDate("2000-12-12");
        employeeDto.setEmail("hauhp@gmail.com");
        employeeDto.setFlag((long) 0);
        employeeDto.setIdCard("123123123");
        employeeDto.setImage("ko");
        employeeDto.setName("Huỳnh Phước Hậu");
        employeeDto.setPhone("0905123123");
        employeeDto.setSalary("9000000");


        GenderDto genderDto = new GenderDto();
        genderDto.setGenderId(1L);
        genderDto.setName("nam");
        employeeDto.setGenderDto(genderDto);

        AccountDto accountDto = new AccountDto();
        accountDto.setAccountId(1L);
        accountDto.setUsername("hauhp");
        accountDto.setPassword("123123");
        accountDto.setUserTime("2021-10-10");
        employeeDto.setAccountDto(accountDto);
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/employee/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(employeeDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createEmployee_code_8() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmployeeCode("NV-1234");
        employeeDto.setAddress("Đà Nẵng");
        employeeDto.setBirthDate("2000-12-12");
        employeeDto.setEmail("hauhp@gmail.com");
        employeeDto.setFlag((long) 0);
        employeeDto.setIdCard("123123123");
        employeeDto.setImage("ko");
        employeeDto.setName("Huỳnh Phước Hậu");
        employeeDto.setPhone("0905123123");
        employeeDto.setSalary("9000000");


        GenderDto genderDto = new GenderDto();
        genderDto.setGenderId(1L);
        genderDto.setName("nam");
        employeeDto.setGenderDto(genderDto);

        AccountDto accountDto = new AccountDto();
        accountDto.setAccountId(1L);
        accountDto.setUsername("hauhp");
        accountDto.setPassword("123123");
        accountDto.setUserTime("2021-10-10");
        employeeDto.setAccountDto(accountDto);
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/employee/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(employeeDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createEmployee_code_9() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmployeeCode("NV1234");
        employeeDto.setAddress("Đà Nẵng");
        employeeDto.setBirthDate("2000-12-12");
        employeeDto.setEmail("hauhp@gmail.com");
        employeeDto.setFlag((long) 0);
        employeeDto.setIdCard(null);
        employeeDto.setImage("ko");
        employeeDto.setName("Huỳnh Phước Hậu");
        employeeDto.setPhone("0905123123");
        employeeDto.setSalary("9000000");


        GenderDto genderDto = new GenderDto();
        genderDto.setGenderId(1L);
        genderDto.setName("nam");
        employeeDto.setGenderDto(genderDto);

        AccountDto accountDto = new AccountDto();
        accountDto.setAccountId(1L);
        accountDto.setUsername("hauhp");
        accountDto.setPassword("123123");
        accountDto.setUserTime("2021-10-10");
        employeeDto.setAccountDto(accountDto);
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/employee/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(employeeDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createEmployee_code_10() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmployeeCode("NV1234");
        employeeDto.setAddress("Đà Nẵng");
        employeeDto.setBirthDate("2000-12-12");
        employeeDto.setEmail("hauhp@gmail.com");
        employeeDto.setFlag((long) 0);
        employeeDto.setIdCard("123123123");
        employeeDto.setImage("ko");
        employeeDto.setName("Huỳnh Phước Hậu");
        employeeDto.setPhone("0905123123");
        employeeDto.setSalary(null);


        GenderDto genderDto = new GenderDto();
        genderDto.setGenderId(1L);
        genderDto.setName("nam");
        employeeDto.setGenderDto(genderDto);

        AccountDto accountDto = new AccountDto();
        accountDto.setAccountId(1L);
        accountDto.setUsername("hauhp");
        accountDto.setPassword("123123");
        accountDto.setUserTime("2021-10-10");
        employeeDto.setAccountDto(accountDto);
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/employee/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(employeeDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createEmployee_code_11() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmployeeCode("NV1234");
        employeeDto.setAddress("Đà Nẵng");
        employeeDto.setBirthDate("2000-12-12");
        employeeDto.setEmail("hauhp@gmail.com");
        employeeDto.setFlag((long) 0);
        employeeDto.setIdCard("123123123");
        employeeDto.setImage("ko");
        employeeDto.setName("Huỳnh Phước Hậu");
        employeeDto.setPhone("0905123123");
        employeeDto.setSalary("9000000");


        GenderDto genderDto = new GenderDto();
        genderDto.setGenderId(1L);
        genderDto.setName("nam");
        employeeDto.setGenderDto(genderDto);

        AccountDto accountDto = new AccountDto();
        accountDto.setAccountId(1L);
        accountDto.setUsername(null);
        accountDto.setPassword("123123");
        accountDto.setUserTime("2021-10-10");
        employeeDto.setAccountDto(accountDto);
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/employee/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(employeeDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createEmployee_code_12() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmployeeCode("NV1234");
        employeeDto.setAddress("Đà Nẵng");
        employeeDto.setBirthDate("2000-12-12");
        employeeDto.setEmail("hauhp@gmail.com");
        employeeDto.setFlag((long) 0);
        employeeDto.setIdCard("123123123");
        employeeDto.setImage("ko");
        employeeDto.setName("Huỳnh Phước Hậu");
        employeeDto.setPhone("0905123123");
        employeeDto.setSalary("9000000");


        GenderDto genderDto = new GenderDto();
        genderDto.setGenderId(1L);
        genderDto.setName("nam");
        employeeDto.setGenderDto(genderDto);

        AccountDto accountDto = new AccountDto();
        accountDto.setAccountId(1L);
        accountDto.setUsername("hauhp");
        accountDto.setPassword(null);
        accountDto.setUserTime("2021-10-10");
        employeeDto.setAccountDto(accountDto);
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/employee/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(employeeDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createEmployee_code_14() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmployeeCode("NV1234");
        employeeDto.setAddress("Đà Nẵng");
        employeeDto.setBirthDate("2000-12-12");
        employeeDto.setEmail("hauhp@gmail.com");
        employeeDto.setFlag((long) 0);
        employeeDto.setIdCard("123123123");
        employeeDto.setImage("ko");
        employeeDto.setName("Huỳnh Phước Hậu");
        employeeDto.setPhone(null);
        employeeDto.setSalary("9000000");


        GenderDto genderDto = new GenderDto();
        genderDto.setGenderId(1L);
        genderDto.setName("nam");
        employeeDto.setGenderDto(genderDto);

        AccountDto accountDto = new AccountDto();
        accountDto.setAccountId(1L);
        accountDto.setUsername("hauhp");
        accountDto.setPassword("123123");
        accountDto.setUserTime("2021-10-10");
        employeeDto.setAccountDto(accountDto);
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/employee/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(employeeDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createEmployee_code_15() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmployeeCode("NV1234");
        employeeDto.setAddress("Đà Nẵng");
        employeeDto.setBirthDate("2000-12-12");
        employeeDto.setEmail("hauhp@gmail.com");
        employeeDto.setFlag((long) 0);
        employeeDto.setIdCard("123123123");
        employeeDto.setImage("ko");
        employeeDto.setName("Huỳnh Phước Hậu");
        employeeDto.setPhone("0905123123");
        employeeDto.setSalary("9000000");


        GenderDto genderDto = new GenderDto();
        genderDto.setGenderId(1L);
        genderDto.setName("nam");
        employeeDto.setGenderDto(genderDto);

        AccountDto accountDto = new AccountDto();
        accountDto.setAccountId(1L);
        accountDto.setUsername("hauhp");
        accountDto.setPassword("123123");
        accountDto.setUserTime("2021-10-10");
        employeeDto.setAccountDto(accountDto);
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/employee/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(employeeDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createEmployee_code_17() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmployeeCode("NV1234");
        employeeDto.setAddress("Đà Nẵng");
        employeeDto.setBirthDate("2000-12-12");
        employeeDto.setEmail("hauhp@gmail.com");
        employeeDto.setFlag((long) 0);
        employeeDto.setIdCard("123123123");
        employeeDto.setImage("ko");
        employeeDto.setName("Huỳnh Phước Hậu");
        employeeDto.setPhone("0905123123");
        employeeDto.setSalary("0");


        GenderDto genderDto = new GenderDto();
        genderDto.setGenderId(1L);
        genderDto.setName("nam");
        employeeDto.setGenderDto(genderDto);

        AccountDto accountDto = new AccountDto();
        accountDto.setAccountId(1L);
        accountDto.setUsername("hauhp");
        accountDto.setPassword("123123");
        accountDto.setUserTime("2021-10-10");
        employeeDto.setAccountDto(accountDto);
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/employee/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(employeeDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createEmployee_code_18() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmployeeCode("NV-1234");
        employeeDto.setAddress("Đà Nẵng");
        employeeDto.setBirthDate("2000-12-12");
        employeeDto.setEmail("hauhp@gmail.com");
        employeeDto.setFlag((long) 0);
        employeeDto.setIdCard("123123123");
        employeeDto.setImage("ko");
        employeeDto.setName("Huỳnh Phước Hậu");
        employeeDto.setPhone("0905123123");
        employeeDto.setSalary("9000000");


        GenderDto genderDto = new GenderDto();
        genderDto.setGenderId(1L);
        genderDto.setName("nam");
        employeeDto.setGenderDto(genderDto);

        AccountDto accountDto = new AccountDto();
        accountDto.setAccountId(1L);
        accountDto.setUsername("hauhp");
        accountDto.setPassword("123123");
        accountDto.setUserTime("2021-10-10");
        employeeDto.setAccountDto(accountDto);
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/employee/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(employeeDto)))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
