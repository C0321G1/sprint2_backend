package c0321g1_pawnshop_backend.repository.customer;

import c0321g1_pawnshop_backend.entity.contract.TypeProduct;
import c0321g1_pawnshop_backend.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    //Linh code
    @Query(value = "select * from customer where flag = 1", nativeQuery = true)
    Page<Customer> getCustomerList(Pageable pageable);

    //Linh code
    @Query(value="select * from customer where customer_id = ?1", nativeQuery = true)
    Optional<Customer> findById(Long id);

    //Linh code
    @Query(value = "select * from customer " +
            "where flag = 1 and concat(`name`, customer_code, id_card) like %:keyword%", nativeQuery = true)
    Page<Customer> searchToCreateContract(@Param("keyword") String keywordValue, Pageable pageable);
}
