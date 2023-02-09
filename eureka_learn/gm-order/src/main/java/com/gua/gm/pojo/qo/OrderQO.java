package com.gua.gm.pojo.qo;


import lombok.Data;

import java.util.List;

@Data
public class OrderQO {
    private Long cusId;

    private List<ProductQo> productQoList;
}
