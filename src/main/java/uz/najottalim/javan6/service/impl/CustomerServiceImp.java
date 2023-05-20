package uz.najottalim.javan6.service.impl;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.najottalim.javan6.entity.CustomerEntity;
import uz.najottalim.javan6.service.CustomerService;
@Service
public class CustomerServiceImp implements CustomerService {
    @Autowired
    EntityManager entityManager;
    @Transactional
    @Override
    public CustomerEntity getById(Long id) {
        return entityManager.find(CustomerEntity.class,id);
    }
    @Transactional
    @Override
    public String addCustomer(CustomerEntity customer) {
        entityManager.merge(customer);
        return "Successfully added";
    }

}
