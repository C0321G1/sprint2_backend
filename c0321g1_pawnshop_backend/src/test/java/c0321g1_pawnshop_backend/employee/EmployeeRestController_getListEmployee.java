package c0321g1_pawnshop_backend.employee;

import c0321g1_pawnshop_backend.controller.employee.EmployeeRestController;
import c0321g1_pawnshop_backend.entity.employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class EmployeeRestController_getListEmployee {
    // Creator: Nhung
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private EmployeeRestController employeeRestController;

    @Test
    void getListEmployee_5() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/employee/listEmployee"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    void getListEmployee_6() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/employee/listEmployee"))
                .andDo(print())
                .andExpect(status().isOk());

        ResponseEntity<List<Employee>> listEmployee = this.employeeRestController.getListEmployee();
        Assertions.assertEquals(1, listEmployee.getBody().get(0).getEmployeeId());
        Assertions.assertEquals("10000000", listEmployee.getBody().get(0).getSalary());
        Assertions.assertEquals("1111111", listEmployee.getBody().get(0).getIdCard());
        Assertions.assertEquals("Khinh Vũ", listEmployee.getBody().get(0).getName());
        Assertions.assertEquals("E-0000", listEmployee.getBody().get(0).getEmployeeCode());
        Assertions.assertEquals("2000-02-02", listEmployee.getBody().get(0).getBirthDate());
        Assertions.assertEquals("Nghệ An", listEmployee.getBody().get(0).getAddress());
        Assertions.assertEquals("2@gmail.com", listEmployee.getBody().get(0).getEmail());
        Assertions.assertEquals("0987654321", listEmployee.getBody().get(0).getPhone());
        Assertions.assertEquals("https://salenhanh.com/wp-content/uploads/2020/12/phim-duong-duong.jpg", listEmployee.getBody().get(0).getImage());
        Assertions.assertEquals(0, listEmployee.getBody().get(0).getFlag());
        Assertions.assertEquals(1, listEmployee.getBody().get(0).getAccount().getAccountId());
        Assertions.assertEquals(1, listEmployee.getBody().get(0).getGender().getGenderId());
    }

}
