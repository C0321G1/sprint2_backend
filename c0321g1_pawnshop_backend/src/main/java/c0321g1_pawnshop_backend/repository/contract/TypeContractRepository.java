package c0321g1_pawnshop_backend.repository.contract;

import c0321g1_pawnshop_backend.entity.contract.TypeContract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TypeContractRepository extends JpaRepository<TypeContract, Long> {
    /*long*/
    @Query(value = "select * from type_contract;", nativeQuery = true)
    List<TypeContract> findAll();
}
