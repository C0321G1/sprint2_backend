package c0321g1_pawnshop_backend.service_impl.contract;

import c0321g1_pawnshop_backend.repository.contract.TypeContractRepository;
import c0321g1_pawnshop_backend.service.contract.TypeContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeContractServiceImpl implements TypeContractService {
    @Autowired
    private TypeContractRepository typeContractRepository;
}
