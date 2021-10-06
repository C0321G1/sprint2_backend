package c0321g1_pawnshop_backend.entity.contract;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StatusContract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long statusId;
    private String name;

    @OneToMany(mappedBy = "statusContract", cascade = CascadeType.ALL)
    @JsonBackReference
    List<Contract> contracts;
}
