package com.gua.gm.pojo.qo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@ApiModel(value = "商品请求对象")
public class ProductQo {
    @NotNull
    @ApiModelProperty(value = "商品id", required = true)
    private Long productId;
    @Min(0)
    @ApiModelProperty(value = "商品数量", required = true)
    private Integer count;
}
