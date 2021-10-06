package c0321g1_pawnshop_backend.service_impl.statistic;

import c0321g1_pawnshop_backend.repository.statictis.StatisticRepository;
import c0321g1_pawnshop_backend.service.statictis.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatisticServiceImpl implements StatisticService {
    @Autowired
    private StatisticRepository statisticRepository;
}
