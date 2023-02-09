package com.gua.gm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author auto-genergator
 * @since 2023-02-09
 */
@TableName("pms_product")
public class Product extends Model<Product> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(Long productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public static final String ID = "id";

    public static final String PRODUCT_CATEGORY_ID = "product_category_id";

    public static final String NAME = "name";

    public static final String MONEY = "money";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Product{" +
        "id=" + id +
        ", productCategoryId=" + productCategoryId +
        ", name=" + name +
        ", money=" + money +
        "}";
    }
}
