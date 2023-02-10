package com.gua.gm.pojo.qo;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class ProductQo {
    @NotNull
    private Long productId;
    @Min(0)
    private Integer count;
}
