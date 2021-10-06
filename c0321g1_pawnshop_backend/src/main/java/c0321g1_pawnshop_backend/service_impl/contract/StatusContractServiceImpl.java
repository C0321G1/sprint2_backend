package c0321g1_pawnshop_backend.service_impl.contract;

import c0321g1_pawnshop_backend.repository.contract.StatusContractRepository;
import c0321g1_pawnshop_backend.service.contract.StatusContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusContractServiceImpl implements StatusContractService {
    @Autowired
    private StatusContractRepository statusContractRepository;
}
