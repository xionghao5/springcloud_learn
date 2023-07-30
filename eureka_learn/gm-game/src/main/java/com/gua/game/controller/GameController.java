package com.gua.game.controller;

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


    @GetMapping("hello")
    public String hello() {
        return "hello game";
    }


}

