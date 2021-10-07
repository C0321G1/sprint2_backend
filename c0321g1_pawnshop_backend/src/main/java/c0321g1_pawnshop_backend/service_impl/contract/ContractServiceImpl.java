package c0321g1_pawnshop_backend.service_impl.contract;

import c0321g1_pawnshop_backend.entity.contract.Contract;
import c0321g1_pawnshop_backend.repository.contract.ContractRepository;
import c0321g1_pawnshop_backend.service.contract.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    private ContractRepository contractRepository;

    /*Long*/
    @Override
    public Integer createLiquidateContract(String contractCode, String productName, Long customerId,
                                           String dateLiquidation, Long typeContractId,
                                           Long statusId, int flag, int totalMoney, int loan,
                                           int profit) {
        return contractRepository.createLiquidateContract(contractCode, productName, customerId, dateLiquidation,
                typeContractId, statusId, flag, totalMoney, loan, profit);
    }

    /*Long*/
    @Override
    public Page<Contract> findProductLiquidation(Pageable pageable) {
        return contractRepository.findProductLiquidation(pageable);
    }

    /*Long*/
    @Override
    public Contract searchContractByCode(String contractCode) {
        return contractRepository.searchContractByCode(contractCode);
    }

    /*long*/
    @Override
    public Contract getContractById(Long contractId) {
        return contractRepository.getContractById(contractId);
    }

    /*long*/
    @Override
    public Page<Contract> searchContractLiquidation(String productName, String loan,
                                                    String nameTypeProduct, Pageable pageable) {
        return contractRepository.searchContractLiquidation(productName, loan, nameTypeProduct, pageable);
    }
}
