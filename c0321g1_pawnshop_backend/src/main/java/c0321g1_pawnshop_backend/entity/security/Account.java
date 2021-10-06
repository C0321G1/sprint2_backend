package c0321g1_pawnshop_backend.entity.security;

import c0321g1_pawnshop_backend.entity.employee.Employee;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;
    private String password;
    private String username;
    private String userTime;
    @ManyToMany(targetEntity = Role.class)
    @JoinTable(name = "account_role",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roleSet;
    @JsonIgnore
    @OneToOne(mappedBy = "account")
    private Employee employee;
}
