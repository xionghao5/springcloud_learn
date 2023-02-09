package com.gua.gm.controller;


import com.gua.gm.entity.ProductCategory;
import com.gua.gm.service.IProductCategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author auto-genergator
 * @since 2023-02-08
 */
@RestController
@RequestMapping("/productCategory")
public class ProductCategoryController {

    private final IProductCategoryService productCategoryService;

    public ProductCategoryController(IProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }

    @PostMapping("add")
    public ProductCategory addProductCategory(@RequestBody ProductCategory productCategory) {
        productCategoryService.save(productCategory);
        return productCategory;
    }

    @GetMapping("getAll")
    public List<ProductCategory> getAllProductCategory() {
        return productCategoryService.list();
    }

}

