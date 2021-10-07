package c0321g1_pawnshop_backend.service.contract;


import c0321g1_pawnshop_backend.entity.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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
    Contract getContractById(Long contractId);

    /*long*/
    Page<Contract> searchContractLiquidation(String productName,String loan,String nameTypeProduct,Pageable pageable);
}
