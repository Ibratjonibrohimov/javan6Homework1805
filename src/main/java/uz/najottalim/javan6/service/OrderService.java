package uz.najottalim.javan6.service;

import uz.najottalim.javan6.dto.OrderDto;
import uz.najottalim.javan6.entity.OrderEntity;
import java.util.*;
public interface OrderService {
    List<OrderEntity> getOrdersAll();
    OrderEntity getById(Long id);
    String addOrder(OrderDto orderDto);
    String updateOrder(OrderDto oderDto,Long id);
    String deleteOrder(Long id);
}
