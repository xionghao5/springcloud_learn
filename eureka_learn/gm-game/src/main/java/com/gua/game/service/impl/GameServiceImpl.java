package com.gua.game.service.impl;

import com.gua.game.entity.Game;
import com.gua.game.entity.Player;
import com.gua.game.enums.ActionEnum;
import com.gua.game.service.GameService;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author 86188
 */

@Service
public class GameServiceImpl implements GameService {

    private static Game game;

    @Override
    public Game playOneEnterGame(String name) {
        initialGame();
        if (game.getPlayerOne() == null) {
            Player playerOne = new Player();
            playerOne.setName(name);
            playerOne.setInitialBlood(100);
            playerOne.setRemainingBlood(100);
            game.setPlayerOne(playerOne);
        }
        beginGame();
        return game;
    }

    /**
     * 初始化游戏
     */
    private static void initialGame() {
        if (game == null) {
            game = new Game();
        }
        if (game.getEnd() != null) {
            game = new Game();
        }
    }

    /**
     * 游戏开始
     */
    private static void beginGame() {
        if (game.getPlayerOne() != null && game.getPlayerTwo() != null) {
            game.setBegin(new Date());
        }
    }

    @Override
    public Game playTwoEnterGame(String name) {
        if (game == null) {
            game = new Game();
        }
        if (game.getPlayerTwo() == null) {
            Player playerTwo = new Player();
            playerTwo.setName(name);
            playerTwo.setInitialBlood(100);
            playerTwo.setRemainingBlood(100);
            game.setPlayerTwo(playerTwo);
        }
        beginGame();
        return game;
    }

    @Override
    public Game operate(String name, Integer action) {
        if (game == null || game.getEnd() != null) {
            return game;
        }
        Player one = game.getPlayerOne();
        Player two = game.getPlayerTwo();

        if (one == null || two == null) {
            return game;
        }

        if (one.getName().equals(name)) {
            if (ActionEnum.ATTACK.getCode().equals(action)) {
                two.setRemainingBlood(two.getRemainingBlood() - 10);
            }

        }
        if (two.getName().equals(name)) {
            if (ActionEnum.ATTACK.getCode().equals(action)) {
                one.setRemainingBlood(one.getRemainingBlood() - 10);
            }

        }
        if (one.getRemainingBlood() == 0) {
            game.setWinner(two);
            game.setEnd(new Date());
            return game;
        }
        if (two.getRemainingBlood() == 0) {
            game.setWinner(one);
            game.setEnd(new Date());
            return game;
        }
        return game;
    }
}
