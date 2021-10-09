package c0321g1_pawnshop_backend.controller.security;

import c0321g1_pawnshop_backend.config_security.JwtResponse;
import c0321g1_pawnshop_backend.config_security.JwtUtils;
import c0321g1_pawnshop_backend.config_security.LoginRequest;
import c0321g1_pawnshop_backend.repository.security.AccountRepository;
import c0321g1_pawnshop_backend.service.security.AccountService;
import c0321g1_pawnshop_backend.service_impl.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    AccountService accountService;


    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    AccountRepository accountRepository;

    @PostMapping("/signin")
    public ResponseEntity<JwtResponse> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        accountRepository.changeStatus(1,userDetails.getAccountId());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getAccountId(),
                userDetails.getUsername(),
                userDetails.getUserTime(),
                userDetails.getEmployee(),
                roles));
    }

    @PatchMapping("singout/{employeeId}")
    public ResponseEntity<Void> logout(@PathVariable(name = "employeeId") Long employeeId) {
        accountRepository.changeStatus(0,employeeId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
