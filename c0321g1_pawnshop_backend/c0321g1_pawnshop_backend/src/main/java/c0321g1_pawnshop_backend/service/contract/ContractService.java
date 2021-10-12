package c0321g1_pawnshop_backend.service.contract;

import c0321g1_pawnshop_backend.entity.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContractService {
    //    creator: vinhdn. Get list contract
    Page<Contract> getListContract(Pageable pageable);

    //    creator: vinhdn. search contract
    Page<Contract> searchContract(Pageable pageable, String contractCode,
                                  String customerName, String productName, String startDate);

    //    creator: vinhdn. payment contract
    void paymentContract(Contract contract);
}
