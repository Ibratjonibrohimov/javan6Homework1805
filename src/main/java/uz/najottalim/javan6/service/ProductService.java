package uz.najottalim.javan6.service;

import uz.najottalim.javan6.dto.ProductDto;
import uz.najottalim.javan6.entity.ProductEntity;
import java.util.*;
public interface ProductService {
    List<ProductEntity> getAll();

    String addProduct(ProductDto product);

    String updateproduct(Long id, ProductDto product);

    String deleteProduct(Long id);

    ProductEntity getById(Long id);

    List<ProductEntity> getResourceLimitOffset(Long limit, Long offset);
}
