package c0321g1_pawnshop_backend.service_impl.security;

import c0321g1_pawnshop_backend.repository.security.RoleRepository;
import c0321g1_pawnshop_backend.service.security.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;
}
