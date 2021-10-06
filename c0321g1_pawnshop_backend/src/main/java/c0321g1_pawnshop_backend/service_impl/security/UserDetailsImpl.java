package c0321g1_pawnshop_backend.service_impl.security;

import c0321g1_pawnshop_backend.entity.employee.Employee;
import c0321g1_pawnshop_backend.entity.security.Account;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserDetailsImpl implements UserDetails {
    private static final long serialVersionUID = 1L;

    private Long accountId;

    private String username;

    private String userTime;

    private Employee employee;

    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(Long accountId, String username, String userTime, Employee employee, String password, Collection<? extends GrantedAuthority> authorities) {
        this.accountId = accountId;
        this.username = username;
        this.userTime = userTime;
        this.employee = employee;
        this.password = password;
        this.authorities = authorities;
    }


    public static UserDetailsImpl build(Account account) {
        List<GrantedAuthority> authorities = account.getRoleSet().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName().name()))
                .collect(Collectors.toList());
        return new UserDetailsImpl(
                account.getAccountId(),
                account.getUsername(),
                account.getUserTime(),
                account.getEmployee(),
                account.getPassword(),
                authorities
        );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getAccountId() {
        return accountId;
    }

    public String getUserTime() {
        return userTime;
    }

    public Employee getEmployee() {
        return employee;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        UserDetailsImpl user = (UserDetailsImpl) o;
        return Objects.equals(accountId,user.accountId);
    }

}
