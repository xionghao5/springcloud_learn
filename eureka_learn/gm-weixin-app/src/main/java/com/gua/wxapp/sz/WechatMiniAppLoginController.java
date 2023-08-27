package com.gua.wxapp.sz;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.api.impl.WxMaServiceImpl;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.binarywang.wx.miniapp.config.impl.WxMaDefaultConfigImpl;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/wechat")
public class WechatMiniAppLoginController {

    @Autowired
    private WechatMiniAppConfig wechatMiniAppConfig;

    @PostMapping("/login")
    public Map<String, Object> login(String code) throws WxErrorException {
        WxMaService wxMaService = new WxMaServiceImpl();
        wxMaService.setWxMaConfig(new WxMaDefaultConfigImpl());

        WxMaJscode2SessionResult session = wxMaService.getUserService().getSessionInfo(code);

        Map<String, Object> result = new HashMap<>();
        result.put("openid", session.getOpenid());
        result.put("sessionKey", session.getSessionKey());
        return result;
    }
}