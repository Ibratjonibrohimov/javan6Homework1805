package uz.najottalim.javan6.service.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.najottalim.javan6.entity.ProductEntity;
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
    public String addProduct(ProductEntity product) {
        ProductEntity merge = entityManager.merge(product);
        return "Successfully added";
    }

    @Override
    @Transactional
    public String updateproduct(Long id, ProductEntity product) {
        product.setId(id);
        entityManager.merge(product);
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
