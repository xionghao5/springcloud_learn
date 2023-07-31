package com.gua.game.controller;

import com.gua.game.entity.Game;
import com.gua.game.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 86188
 */


@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired
    private GameService gameService;


    @GetMapping("hello")
    public String hello() {
        return "hello game";
    }


    /**
     * 1. 1P进入游戏
     *
     * @param name
     * @return
     */
    @GetMapping("playOneEnterGame")
    public String playOneEnterGame(String name) {
        Game game = gameService.playOneEnterGame(name);
        return "hello " + name + ",欢迎进入游戏，游戏马上开始:" + game.toString();

    }

    /**
     * 1. 2P进入游戏
     *
     * @param name
     * @return
     */
    @GetMapping("playTwoEnterGame")
    public String playTwoEnterGame(String name) {
        Game game = gameService.playTwoEnterGame(name);
        return "hello " + name + ",欢迎进入游戏，游戏马上开始:" + game.toString();
    }

    /**
     * 操作游戏
     * 游戏结束
     *
     * @param name   玩家名称
     * @param action 动作
     * @return
     */
    @GetMapping("operate")
    public Game enterGame(String name, Integer action) {
        Game game = gameService.operate(name, action);
        return game;
    }
}

