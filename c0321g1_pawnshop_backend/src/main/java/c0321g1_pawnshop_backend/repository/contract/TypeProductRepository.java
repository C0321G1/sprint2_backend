package c0321g1_pawnshop_backend.repository.contract;

import c0321g1_pawnshop_backend.entity.contract.TypeProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeProductRepository extends JpaRepository<TypeProduct,Long> {
}
