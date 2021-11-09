package c0321g1_pawnshop_backend.controller.statistic;

import c0321g1_pawnshop_backend.entity.contract.Contract;
import c0321g1_pawnshop_backend.service.statictis.StatisticService;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping
public class StatisticRestController {
    @Autowired
    private StatisticService statisticService;

    @GetMapping("/statisticInterest")
    public ResponseEntity<List<Contract>> listStatisticInterest(Optional<String> startDate , Optional<String> endDate){
        try {
            String endDateValue = endDate.orElse("");
            String startDateValue = startDate.orElse("");
            List<Contract> listContract = statisticService.listStatisticInterest(startDateValue,endDateValue);
            return new ResponseEntity<>(listContract, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/statisticLiquidation")
    public ResponseEntity<List<Contract>> listStatisticLiquidation(Optional<String> startDate , Optional<String> endDate){
        try {
            String endDateValue = endDate.orElse("");
            String startDateValue = startDate.orElse("");
            List<Contract> listContract = statisticService.listStatisticLiquidation(startDateValue,endDateValue);
            return new ResponseEntity<>(listContract, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/statisticExpected")
    public ResponseEntity<List<Contract>> listStatisticExpected(Optional<String> startDate , Optional<String> endDate){
        try {
            String endDateValue = endDate.orElse("");
            String startDateValue = startDate.orElse("");
            List<Contract> listContract = statisticService.listStatisticExpected(startDateValue,endDateValue);
            return new ResponseEntity<>(listContract, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}