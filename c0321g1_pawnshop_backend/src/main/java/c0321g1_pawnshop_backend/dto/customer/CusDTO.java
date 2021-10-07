package c0321g1_pawnshop_backend.dto.customer;


public interface CusDTO {
    Long getCustomerId();
    String getCustomerCode();
    String getCustomerName();
    String getBirthDate();
    String getIdCard();
    String getPhone();
    String getEmail();
    String getGenderName();
    String getAddress();
    Integer getFlag();
    Integer getAmountContract();
}
