package c0321g1_pawnshop_backend.service.contract;

import c0321g1_pawnshop_backend.entity.contract.TypeProduct;

import java.util.List;

public interface TypeProductService {
    /*long*/
    List<TypeProduct> findAll();

    //Linh code
    List<TypeProduct> getTypeProductList();


}
