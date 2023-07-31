package com.gua.game.entity;

import com.gua.game.enums.ActionEnum;
import lombok.Data;

/**
 * @author 86188
 */
@Data
public class Operate {
    /**
     * 玩家名称
     */
    private String playerName;

    /**
     * 动作
     */
    private Integer action;

}
