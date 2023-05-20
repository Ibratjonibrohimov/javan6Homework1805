package uz.najottalim.javan6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.najottalim.javan6.dto.OrderDto;
import uz.najottalim.javan6.entity.OrderEntity;
import uz.najottalim.javan6.service.OrderService;
import java.util.*;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;
    @GetMapping("/orders/all")
    public List<OrderEntity> getOrdersAll(){
        return orderService.getOrdersAll();
    }
    @PostMapping("/order/add")
    public String addOrder(@RequestBody OrderDto orderDto){
        return orderService.addOrder(orderDto);
    }
    @PutMapping("/order/update/{id}")
    public String updateOrder(@PathVariable Long id,@RequestBody OrderDto orderDto){
        return orderService.updateOrder(orderDto,id);
    }
    @DeleteMapping("/order/delete/{id}")
    public String delete(@PathVariable Long id){
        return orderService.deleteOrder(id);
    }
}
