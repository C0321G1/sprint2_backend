package c0321g1_pawnshop_backend.service.contract;


import c0321g1_pawnshop_backend.dto.contract.ContractDto;
import c0321g1_pawnshop_backend.entity.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;

import javax.mail.MessagingException;
import javax.naming.NamingException;
import java.util.List;
import java.util.Map;

public interface ContractService {
    /* Long*/
    Integer createLiquidateContract(String contractCode, String productName, Long customerId,
                                    String dateLiquidation, Long typeContractId, Long statusId,
                                    int flag, int totalMoney, int loan, int profit);

    /* Long*/
    Page<Contract> findProductLiquidation(Pageable pageable);

    /* Long*/
    Contract searchContractByCode(String contractCode);

    /*long*/
    Contract getContractById(Long id);

    /*long*/
    Page<Contract> searchContractLiquidation(String nameProduct, String nameTypeProduct, Integer loan, Pageable pageable);

    /*long*/
    Integer setStatusById(Long id, Long statusId);

    /*long*/
    Integer upDateLiquidationContract(String dateLiquidation, int totalMoney, Long customerId, Long contractId);

    String initCodeAuto();

    //Linh code
    Map<String, Object> saveContract(ContractDto contractDto, BindingResult bindingResult) throws MessagingException, NamingException;

    //    creator: vinhdn. Get list contract
    Page<Contract> getListContract(Pageable pageable);

    //    creator: vinhdn. search contract
    Page<Contract> searchContract(Pageable pageable, String contractCode,
                                  String customerName, String productName, String startDate);

    //    creator: vinhdn. payment contract
    void paymentContract(Contract contract);

    //Vu code
    Page<Contract> getListContractHistory(Pageable pageable);

    void deleteContract(Long contractId);

    Page<Contract> searchContractHistory(Pageable pageable, String customer, String statusContract, String typeContract, String productName, String startDateFrom, String startDateTo);

    //Khanh code
    List<Contract> searchTNameContract(String customer, String statusContract);

    Contract findByIdContract(Long contractId);

    void updateContractDto(Contract contract);

    void save(Contract contract1);

    List<Contract> page10Contract();

    //vu code
    List<String> getAllEmailToSend();


}
