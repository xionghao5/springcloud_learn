package com.gua.gm.client.pojo;


import lombok.Data;

@Data
public class Product {

    private Long id;

    /**
     * 商品分类id
     */
    private Long productCategoryId;

    /**
     * 名称
     */
    private String name;

    /**
     * 金额
     */
    private Integer money;

}
