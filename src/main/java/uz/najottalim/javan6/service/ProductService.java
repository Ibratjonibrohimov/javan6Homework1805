package uz.najottalim.javan6.service;

import uz.najottalim.javan6.entity.ProductEntity;
import java.util.*;
public interface ProductService {
    List<ProductEntity> getAll();

    String addProduct(ProductEntity product);

    String updateproduct(Long id, ProductEntity product);

    String deleteProduct(Long id);

    ProductEntity getById(Long id);

    List<ProductEntity> getResourceLimitOffset(Long limit, Long offset);
}
