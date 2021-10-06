package c0321g1_pawnshop_backend.controller.security;

import c0321g1_pawnshop_backend.service.security.AccountService;
import c0321g1_pawnshop_backend.service.security.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping
public class AccountRestController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private RoleService roleService;
}
