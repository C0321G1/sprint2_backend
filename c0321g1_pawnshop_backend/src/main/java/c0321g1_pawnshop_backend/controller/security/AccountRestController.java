package c0321g1_pawnshop_backend.controller.security;

import c0321g1_pawnshop_backend.entity.employee.Employee;
import c0321g1_pawnshop_backend.entity.security.Account;
import c0321g1_pawnshop_backend.service.security.AccountService;
import c0321g1_pawnshop_backend.service.security.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping
public class AccountRestController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private RoleService roleService;

}
