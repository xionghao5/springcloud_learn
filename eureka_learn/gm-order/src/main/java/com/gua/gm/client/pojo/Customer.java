package com.gua.gm.client.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

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
