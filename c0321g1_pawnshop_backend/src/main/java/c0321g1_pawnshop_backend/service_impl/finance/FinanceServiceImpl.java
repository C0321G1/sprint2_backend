package c0321g1_pawnshop_backend.service_impl.finance;

import c0321g1_pawnshop_backend.repository.finance.FinanceRepository;
import c0321g1_pawnshop_backend.service.finance.FinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FinanceServiceImpl implements FinanceService {
    @Autowired
    private FinanceRepository financeRepository;
}
