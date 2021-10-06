package c0321g1_pawnshop_backend.service_impl.contract;

import c0321g1_pawnshop_backend.repository.contract.TypeProductRepository;
import c0321g1_pawnshop_backend.service.contract.TypeProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeProductServiceImpl implements TypeProductService {
    @Autowired
    private TypeProductRepository typeProductRepository;
}
