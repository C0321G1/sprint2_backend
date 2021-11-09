package c0321g1_pawnshop_backend.repository.customer;

import c0321g1_pawnshop_backend.dto.customer.CusDTO;
import c0321g1_pawnshop_backend.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // Dong: method get list customer and count amount contract
//    @Query(value = "select " +
//            "(customer.customer_id) as customerId , " +
//            "(customer.customer_code) as customerCode , " +
//            "(customer.name) as customerName , " +
//            "(customer.birth_date) as birthDate , " +
//            "(customer.id_card) as idCard , " +
//            "(customer.phone) as phone , " +
//            "(customer.email) as email , " +
//            "(gender.name) as genderName , " +
//            "(customer.address) as customerAddress , " +
//            "count(contract.contract_id) as amountContract " +
//            "from customer " +
//            "left join contract on customer.customer_id = contract.customer_id " +
//            "left join gender on customer.gender_id=gender.gender_id " +
//            "where customer.flag=1 " +
//            "group by customer.customer_id ", nativeQuery = true, countQuery = "select count(*)" +
//            "            from customer  " +
//            "            left join contract on customer.customer_id = contract.customer_id " +
//            "            left join gender on customer.gender_id=gender.gender_id " +
//            "            where customer.flag=0 " +
//            "            group by customer.customer_id")
//    Page<CusDTO> findAllCustomerAndCountContract(Pageable pageable);

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
            "(customer.address) as customerAddress , " +
            "count(contract.contract_id) as amountContract " +
            "from customer " +
            "left join contract on customer.customer_id = contract.customer_id " +
            "left join gender on customer.gender_id=gender.gender_id " +
            "where customer.flag=1 " +
            "group by customer.customer_id ", nativeQuery = true, countQuery = "select count(*)" +
            "            from customer  " +
            "            left join contract on customer.customer_id = contract.customer_id " +
            "            left join gender on customer.gender_id=gender.gender_id " +
            "            where customer.flag=1 " +
            "            group by customer.customer_id")
    Page<CusDTO> findAllCustomerAndCountContract(Pageable pageable);

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
            "(customer.address) as customerAddress , " +
            "count(contract.contract_id) as amountContract " +
            "from customer " +
            "left join contract on customer.customer_id = contract.customer_id " +
            "left join gender on customer.gender_id=gender.gender_id " +
            "where customer.flag=1 and customer_code like %?1% " +
            "group by customer.customer_id" +
            "order by customer_id desc; ", nativeQuery = true, countQuery = "select count(*)" +
            "            from customer  " +
            "            left join contract on customer.customer_id = contract.customer_id " +
            "            left join gender on customer.gender_id=gender.gender_id " +
            "            where customer.flag=1 and customer_code like %?1% " +
            "            group by customer.customer_id")
    Page<CusDTO> searchCustomerAndCountContract(Pageable pageable, String customerCode);

    // Dong: method delete customer with id
    @Transactional
    @Modifying
    @Query(value = "update customer " +
            "set flag = 0 " +
            "where customer.customer_id = ?1 ", nativeQuery = true)
    void deleteCustomer(Long id);

    // Dong: method search key list customer and count amount contract
    @Query(value = "select " +
            "(customer.customer_id) as customerId , " +
            "(customer.customer_code) as customerCode , " +
            "(customer.name) as customerName , " +
            "(customer.birth_date) as birthDate , " +
            "(customer.id_card) as idCard , " +
            "(customer.phone) as phone , " +
            "(customer.email) as email , " +
            "(gender.name) as genderName , " +
            "(customer.address) as customerAddress , " +
            "count(contract.contract_id) as amountContract " +
            "from customer " +
            "left join contract on customer.customer_id = contract.customer_id " +
            "left join gender on customer.gender_id=gender.gender_id " +
            "where customer.flag=1  and (concat(customer.phone,customer.birth_date,customer.email,gender.name,customer.address,customer.name) like %?1%) " +
            "group by customer.customer_id ", nativeQuery = true, countQuery = "select count(*)" +
            "            from customer  " +
            "            left join contract on customer.customer_id = contract.customer_id " +
            "            left join gender on customer.gender_id=gender.gender_id " +
            "            where customer.flag=1  and (concat(customer.phone,customer.birth_date,customer.email,gender.name,customer.address,customer.name) like %?1%) " +
            "            group by customer.customer_id")
    Page<CusDTO> searchKeyCustomerAndCountContract(Pageable pageable, String keySearch);

    //Linh code
    @Query(value = "select * from customer where flag = 1 order by customer_id desc", nativeQuery = true)
    Page<Customer> getCustomerList(Pageable pageable);

    //Linh code
    @Query(value="select * from customer where customer_id = ?1", nativeQuery = true)
    Optional<Customer> findById(Long id);

    //Linh code
    @Query(value = "select * from customer " +
            "where flag = 1 and concat(`name`, customer_code, id_card) like %:keyword%", nativeQuery = true)
    Page<Customer> searchToCreateContract(@Param("keyword") String keywordValue, Pageable pageable);
}