package c0321g1_pawnshop_backend.repository.contract;

import c0321g1_pawnshop_backend.entity.contract.TypeProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TypeProductRepository extends JpaRepository<TypeProduct, Long> {
    /*long*/
    @Query(value = "select * from type_product;", nativeQuery = true)
    List<TypeProduct> findAll();

    //Linh code
    @Query(value = "select * from type_product", nativeQuery = true)
    List<TypeProduct> getTypeProductList();

}


