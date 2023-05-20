package uz.najottalim.javan6.service;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.najottalim.javan6.entity.CustomerEntity;

@Service
public interface CustomerService {
    CustomerEntity getById(Long id);
    String addCustomer(CustomerEntity customer);
}
