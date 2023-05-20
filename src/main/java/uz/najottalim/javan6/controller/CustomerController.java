package uz.najottalim.javan6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.najottalim.javan6.entity.CustomerEntity;
import uz.najottalim.javan6.service.CustomerService;

@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @GetMapping("customer/{id}")
    public CustomerEntity getById(@PathVariable Long id){
        return customerService.getById(id);
    }
    @PostMapping("/customer/add")
    public String addCustomer(@RequestBody CustomerEntity customer){
        return customerService.addCustomer(customer);
    }
}
