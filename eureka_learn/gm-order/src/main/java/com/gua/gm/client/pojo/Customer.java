package com.gua.gm.client.pojo;

import lombok.Data;

@Data
public class Customer {
    private Long id;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 名称
     */
    private String name;
}
