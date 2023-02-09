package com.gua.gm.controller;


import com.gua.gm.entity.Customer;
import com.gua.gm.service.ICustomerService;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author auto-genergator
 * @since 2023-02-09
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final ICustomerService customerService;

    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("add")
    public Customer addCustomer(@RequestBody Customer customer) {
        customerService.save(customer);
        return customer;
    }

    @GetMapping("get")
    public Customer getCustomer(Long cusId) {
        return customerService.getById(cusId);
    }


}

