package c0321g1_pawnshop_backend.service_impl.contract;

import c0321g1_pawnshop_backend.repository.contract.ContractRepository;
import c0321g1_pawnshop_backend.service.contract.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    private ContractRepository contractRepository;
}
