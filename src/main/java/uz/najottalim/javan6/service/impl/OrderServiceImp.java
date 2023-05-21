package uz.najottalim.javan6.service.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.najottalim.javan6.dto.OrderDto;
import uz.najottalim.javan6.entity.CustomerEntity;
import uz.najottalim.javan6.entity.OrderEntity;
import uz.najottalim.javan6.entity.ProductEntity;
import uz.najottalim.javan6.service.CustomerService;
import uz.najottalim.javan6.service.OrderService;
import uz.najottalim.javan6.service.ProductService;

import java.util.ArrayList;
import java.util.List;
@Service
public class OrderServiceImp implements OrderService {
    @Autowired
    EntityManager entityManager;
    @Autowired
    CustomerService customerService;
    @Autowired
    ProductService productService;
    @Override
    public List<OrderEntity> getOrdersAll() {
        TypedQuery<OrderEntity> query = entityManager.createQuery("select o from OrderEntity o order by id",OrderEntity.class);
        return query.getResultList();
    }

    @Override
    public OrderEntity getById(Long id) {
        return entityManager.find(OrderEntity.class,id);
    }
    @Transactional
    @Override
    public String addOrder(OrderDto orderDto) {
        if(customerService.getById(orderDto.getCustomerId())==null)return "Customer not found";
        OrderEntity order = new OrderEntity();
        order.setOrderDate(orderDto.getOrderDate());
        order.setDeliveryDate(orderDto.getDeliveryDate());
        order.setStatus(orderDto.getStatus());
        CustomerEntity customer = customerService.getById(orderDto.getCustomerId());
        order.setCustomer(customer);
        List<ProductEntity> products = new ArrayList<>();
        Long [] productIds = orderDto.getProductIds();
        for (int i = 0; i < productIds.length; i++) {
            products.add(productService.getById(productIds[i]));
        }
        order.setProducts(products);
        entityManager.merge(order);
        return "Successfully added";
    }
    @Transactional
    @Override
    public String updateOrder(OrderDto orderDto, Long id) {
        if(getById(id)==null) return "Order not found";
        if(customerService.getById(orderDto.getCustomerId())==null)return "Customer not found";
        OrderEntity order =new OrderEntity();
        order.setId(id);
        order.setOrderDate(orderDto.getOrderDate());
        order.setDeliveryDate(orderDto.getDeliveryDate());
        order.setStatus(orderDto.getStatus());
        CustomerEntity customer = customerService.getById(orderDto.getCustomerId());
        order.setCustomer(customer);
        List<ProductEntity> products = new ArrayList<>();
        Long [] productIds = orderDto.getProductIds();
        for (int i = 0; i < productIds.length; i++) {
            products.add(productService.getById(productIds[i]));
        }
        order.setProducts(products);
        entityManager.merge(order);
        return "Successfully updated";
    }
    @Transactional
    @Override
    public String deleteOrder(Long id) {
        OrderEntity delete = getById(id);
        if(delete==null) return "Order not found";
        entityManager.remove(delete);
        return "Successfully deleted";
    }
}
