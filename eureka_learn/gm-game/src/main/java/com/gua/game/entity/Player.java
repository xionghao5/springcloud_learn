package com.gua.game.entity;

import lombok.Data;

/**
 * @author 86188
 */
@Data
public class Player {
    /**
     * 玩家名称
     */
    private String name;
    /**
     * 初始血量
     */
    private Integer initialBlood;
    /**
     * 剩余血量
     */
    private Integer remainingBlood;
}
