package com.gua.game.service;

import com.gua.game.entity.Game;

/**
 * @author 86188
 */
public interface GameService {

    /**
     * 1P进入游戏
     *
     * @param name 名称
     * @return game 游戏
     */
    Game playOneEnterGame(String name);

    /**
     * 2P进入游戏
     *
     * @param name 名称
     * @return game 游戏
     */
    Game playTwoEnterGame(String name);

    /**
     * @param name   名称
     * @param action 动作
     * @return game 游戏
     */
    Game operate(String name, Integer action);
}
