package c0321g1_pawnshop_backend.service_impl.contract;

import c0321g1_pawnshop_backend.repository.contract.PeriodContractRepository;
import c0321g1_pawnshop_backend.service.contract.PeriodContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeriodContractServiceImpl implements PeriodContractService {
    @Autowired
    private PeriodContractRepository periodContractRepository;
}
