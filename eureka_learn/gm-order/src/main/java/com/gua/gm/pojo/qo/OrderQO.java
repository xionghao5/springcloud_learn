package com.gua.gm.pojo.qo;


import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class OrderQO {
    @NotNull
    private Long cusId;

    @Valid
    private List<ProductQo> productQoList;
}
