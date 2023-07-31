package com.gua.game.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author 86188
 */
@Data
public class Game {
    /**
     * 游戏开始时间
     */
    private Date begin;
    /**
     * 游戏结束时间
     */
    private Date end;

    /**
     * 1P
     */
    private Player playerOne;

    /**
     * 2P
     */
    private Player playerTwo;

    /**
     * 游戏获胜方
     */
    private Player winner;
}
