package c0321g1_pawnshop_backend.statistic;

import c0321g1_pawnshop_backend.controller.statistic.StatisticRestController;
import c0321g1_pawnshop_backend.entity.contract.Contract;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;
import java.util.Optional;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc
public class StatisticController_statisticLiquidation {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    StatisticRestController statisticRestController;
    @Test
    void statisticLiquidation_1() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/statisticLiquidation"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }



    @Test
    public void statisticLiquidation_2() {
        ResponseEntity<List<Contract>> listResponseEntity
                = this.statisticRestController.listStatisticLiquidation(Optional.of(""),Optional.of(""));
        List<Contract> contractList = listResponseEntity.getBody();
        int statusCode = listResponseEntity.getStatusCodeValue();

        Assertions.assertEquals(200, statusCode);
        assert contractList != null;
        Assertions.assertEquals("SV-0002", contractList.get(0).getContractCode());
        Assertions.assertEquals("2021-11-12", contractList.get(0).getEndDate());
        Assertions.assertEquals("2021-10-09", contractList.get(0).getStartDate());
        Assertions.assertEquals("Nhung", contractList.get(0).getProductName());

    }
}
