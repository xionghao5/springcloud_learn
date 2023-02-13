package com.gua.gm.pojo.qo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@ApiModel(value = "orderQO", description = "订单请求对象")
public class OrderQO {
    @NotNull
    @ApiModelProperty(value = "cusId", name = "顾客id", required = true)
    private Long cusId;

    @Valid
    @ApiModelProperty(value = "productQoList", name = "商品对象集合", required = true)
    private List<ProductQo> productQoList;
}
