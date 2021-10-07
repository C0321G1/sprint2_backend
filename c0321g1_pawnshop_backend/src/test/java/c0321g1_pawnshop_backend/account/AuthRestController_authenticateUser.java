package c0321g1_pawnshop_backend.account;

import c0321g1_pawnshop_backend.dto.security.AccountDto;
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
public class AuthRestController_authenticateUser {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void authenticate_username_1() throws Exception {
        AccountDto accountDto = new AccountDto();
        accountDto.setUsername(null);
        accountDto.setPassword("123123");

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/api/auth/signin")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(accountDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    void authenticate_password_2() throws Exception {
        AccountDto accountDto = new AccountDto();
        accountDto.setUsername("tra123");
        accountDto.setPassword(null);

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/api/auth/signin")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(accountDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    void authenticate_username_3() throws Exception {
        AccountDto accountDto = new AccountDto();
        accountDto.setUsername("");
        accountDto.setPassword("123123");

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/api/auth/signin")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(accountDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    void authenticate_password_4() throws Exception {
        AccountDto accountDto = new AccountDto();
        accountDto.setUsername("khue123");
        accountDto.setPassword("");

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/api/auth/signin")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(accountDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    void authenticate_username_5() throws Exception {
        AccountDto accountDto = new AccountDto();
        accountDto.setUsername("khue122212121211");
        accountDto.setPassword("123123");

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/api/auth/signin")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(accountDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    void authenticate_password_6() throws Exception {
        AccountDto accountDto = new AccountDto();
        accountDto.setUsername("khue123");
        accountDto.setPassword("123456789123456789");

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/api/auth/signin")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(accountDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    void authenticate_7() throws Exception {
        AccountDto accountDto = new AccountDto();
        accountDto.setUsername("khue123");
        accountDto.setPassword("123123");

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/api/auth/signin")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(accountDto)))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
