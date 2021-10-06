package c0321g1_pawnshop_backend.service_impl.customer;

import c0321g1_pawnshop_backend.repository.customer.GenderRepository;
import c0321g1_pawnshop_backend.service.customer.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenderServiceImpl implements GenderService {
    @Autowired
    private GenderRepository genderRepository;
}
