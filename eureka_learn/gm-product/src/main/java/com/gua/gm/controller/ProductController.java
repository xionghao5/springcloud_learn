package com.gua.gm.controller;


import com.gua.gm.entity.Product;
import com.gua.gm.service.IProductService;
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
@RequestMapping("/product")
public class ProductController {

    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @PostMapping("add")
    public Product addProductCategory(@RequestBody Product product) {
        productService.save(product);
        return product;
    }

    @GetMapping("get")
    public Product getCustomer(Long productId) {
        return productService.getById(productId);
    }

}

