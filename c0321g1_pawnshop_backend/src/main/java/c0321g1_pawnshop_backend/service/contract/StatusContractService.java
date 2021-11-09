package c0321g1_pawnshop_backend.service.contract;

import c0321g1_pawnshop_backend.entity.contract.StatusContract;

import java.util.List;

public interface StatusContractService {
    /*long*/
    List<StatusContract> findAll();

    //Vu code
    List<StatusContract> getStatusContractList();
}
