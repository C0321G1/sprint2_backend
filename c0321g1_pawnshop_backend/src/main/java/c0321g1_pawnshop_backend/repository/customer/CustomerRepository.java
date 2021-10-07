package c0321g1_pawnshop_backend.repository.customer;

import c0321g1_pawnshop_backend.dto.customer.CusDTO;
import c0321g1_pawnshop_backend.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // Dong: method get list customer and count amount contract
    @Query(value = "select " +
                "(customer.customer_id) as customerId , " +
                "(customer.customer_code) as customerCode , " +
                "(customer.name) as customerName , " +
                "(customer.birth_date) as birthDate , " +
                "(customer.id_card) as idCard , " +
                "(customer.phone) as phone , " +
                "(customer.email) as email , " +
                "(gender.name) as genderName , " +
                "(customer.address) as address , " +
                "count(contract.contract_id) as amountContract " +
            "from customer " +
            "left join contract on customer.customer_id = contract.customer_id " +
            "left join gender on customer.gender_id=gender.gender_id " +
            "where customer.flag=1 "+
            "group by customer.customer_id ", nativeQuery = true,countQuery="select count(*)" +
            "            from customer  " +
            "            left join contract on customer.customer_id = contract.customer_id "  +
            "            left join gender on customer.gender_id=gender.gender_id " +
            "            where customer.flag=1 " +
            "            group by customer.customer_id")
    Page<CusDTO> findAllCustomerAndCountContract(Pageable pageable);
//
//    @Query(value = "SELECT e FROM Employee e LEFT JOIN FETCH e.addresses a " +
//            "WHERE " + MyRepository.WHERE_PART
//            "ORDER BY e.id, a.id",
//            countQuery="SELECT count(e) FROM Employee e WHERE " + MyRepository.WHERE_PART
//    )

    // Dong: method delete customer with id
    @Transactional
    @Modifying
    @Query(value = "update customer " +
            "set flag = 0 " +
            "where customer.customer_id = ?1 ", nativeQuery = true)
    void deleteCustomer(Long id);

    // Dong: method findById Customer
    @Query(value = "select " +
            "(customer.customer_id) as customerId , " +
            "(customer.customer_code) as customerCode , " +
            "(customer.name) as customerName , " +
            "(customer.birth_date) as birthDate , " +
            "(customer.id_card) as idCard , " +
            "(customer.phone) as phone , " +
            "(customer.email) as email , " +
            "(gender.name) as genderName , " +
            "(customer.address) as address , " +
            "count(contract.contract_id) as amountContract\n" +
            "from customer " +
            "left join contract on customer.customer_id = contract.customer_id " +
            "left join gender on customer.gender_id=gender.gender_id " +
            "where customer.flag=1 and customer.customer_id= ?1"+
            "group by customer.customer_id", nativeQuery = true)
    Customer findByCustomer(Long customerId);
}

