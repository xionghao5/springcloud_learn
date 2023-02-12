package com.gua.gm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;


/**
 * swagger2的这个配置需要根据版本进行设置
 */
@Configuration
@EnableSwagger2WebMvc
public class SwaggerConfig {
    @Bean
    Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.gua.gm"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("订单模块API文档")
                .description("gm-电商项目订单模块的API文档")
                .termsOfServiceUrl("http://127.0.0.1:9000")
                .version("1.0")
                .contact(new Contact("xionghao5",
                        "http://127.0.0.1:9000",
                        "xionghao5@163.com"))
                .build();
    }
}
