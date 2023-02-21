package com.gua.cg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


/**
 * 输入文本
 * 预处理
 * 分词和位置编码
 * GPT模型处理（注意层和前置反馈层）
 * 输出结果
 * ========
 * 自然语言模型
 * 代码语言模型
 * 监督微调模型
 * 人类反馈微调模型
 * 强化学习微调模型
 * ======
 * 复制ChatGPT的难点
 * 1.深度学习，自然语言处理
 * 2.数据集和计算资源（海量数据，超大规模的模型架构(AI算力，GPU卡),不小的成本）
 * 3.创造性思维和坚持（克服困难，不断优化）
 * 4.人工标注，调整模型参数
 * 5.易用性，及时反馈，及时调整
 *
 * 如果您想尝试构建一个ChatGPT，建议您先深入学习机器学习和自然语言处理的基本理论和技术，
 * 并积累足够的编程经验和计算资源，然后选择适合自己的数据集和算法，进行不断的实验和优化。
 * ======
 * 各大公司纷纷下场
 * 程序员要马上学会使用ChatGPT，提高生产力
 */
@SpringBootApplication
@EnableEurekaClient
public class GmChatgptApplication {

    public static void main(String[] args) {
        SpringApplication.run(GmChatgptApplication.class, args);
    }

}


