package com.gua.game.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 86188
 */

public enum ActionEnum {

    ATTACK(1, "攻击"),

    BLOCK(2, "格挡"),
    ;
    private Integer code;
    private String msg;
    private static final Map<Integer, String> map = new HashMap<>();

    ActionEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    static {
        ActionEnum[] values = ActionEnum.values();
        for (ActionEnum value : values) {
            map.put(value.getCode(), value.getMsg());
        }
    }

    /**
     * 根据code获取msg
     *
     * @param code
     * @return
     */
    public static String getMsgByCode(int code) {
        return map.get(code);
    }


    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}