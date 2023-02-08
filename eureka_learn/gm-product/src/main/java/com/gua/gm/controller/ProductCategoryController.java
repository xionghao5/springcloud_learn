package com.gua.gm.controller;


import com.gua.gm.entity.ProductCategory;
import com.gua.gm.service.IProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ProductCategory addProductCategory(ProductCategory productCategory) {
        productCategoryService.save(productCategory);
        return productCategory;
    }

}

