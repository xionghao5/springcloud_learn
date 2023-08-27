package com.gua.xj.sz;

import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class GuaJobHandler {
    private static Logger logger = LoggerFactory.getLogger(GuaJobHandler.class);


    /**
     * 1、简单任务示例（Bean模式）
     */
    @XxlJob("gua1JobHandler")
    public void gua1JobHandler() throws Exception {
        XxlJobHelper.log("springcloud集成xxl-job");

        for (int i = 0; i < 5; i++) {
            XxlJobHelper.log("偶即把可,彼阳晚意:" + i);
            TimeUnit.SECONDS.sleep(2);
        }
        // default success
    }
}