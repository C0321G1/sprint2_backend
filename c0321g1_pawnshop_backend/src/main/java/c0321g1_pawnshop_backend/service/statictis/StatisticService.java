package c0321g1_pawnshop_backend.service.statictis;

import c0321g1_pawnshop_backend.entity.contract.Contract;

import java.util.List;

public interface StatisticService {
    List<Contract> listStatisticInterest(String startDate, String endDate);
    List<Contract> listStatisticLiquidation(String startDate,String endDate);
    List<Contract> listStatisticExpected(String startDate,String endDate);
}