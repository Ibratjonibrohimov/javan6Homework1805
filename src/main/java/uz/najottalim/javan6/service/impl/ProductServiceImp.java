package uz.najottalim.javan6.service.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.najottalim.javan6.dto.ProductDto;
import uz.najottalim.javan6.entity.OrderEntity;
import uz.najottalim.javan6.entity.ProductEntity;
import uz.najottalim.javan6.service.OrderService;
import uz.najottalim.javan6.service.ProductService;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    EntityManager entityManager;

    @Override
    public List<ProductEntity> getAll() {
        TypedQuery<ProductEntity> nativeQuery = entityManager.createQuery("select p from ProductEntity p order by id", ProductEntity.class);
        return nativeQuery.getResultList();
    }

    @Override
    @Transactional
    public String addProduct(ProductDto product) {
        ProductEntity addProduct = new ProductEntity();
        addProduct.setName(product.getName());
        addProduct.setPrice(product.getPrice());
        addProduct.setCategory(product.getCategory());
        entityManager.persist(addProduct );
        return "Successfully added";
    }

    @Override
    @Transactional
    public String updateproduct(Long id, ProductDto product) {
        ProductEntity byId = getById(id);
        if(byId == null)return "Product not found";
        byId.setCategory(product.getCategory());
        byId.setName(product.getName());
        byId.setPrice(product.getPrice());
        entityManager.merge(byId);
        return "Successfully updated";
    }

    @Transactional
    @Override
    public String deleteProduct(Long id) {
        entityManager.remove(getById(id));
        return "Successfully deleted";
    }

    @Override
    public ProductEntity getById(Long id) {
        return entityManager.find(ProductEntity.class, id);
    }

    @Override
    public List<ProductEntity> getResourceLimitOffset(Long limit, Long offset) {
        TypedQuery<ProductEntity> query = (TypedQuery<ProductEntity>) entityManager.createNativeQuery("select * from product limit ? offset ?",ProductEntity.class);
        query.setParameter(1,limit);
        query.setParameter(2,offset);
        return query.getResultList();
    }

}
