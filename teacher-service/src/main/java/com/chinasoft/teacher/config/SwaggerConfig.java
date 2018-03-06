package com.chinasoft.teacher.config;

/**
 * Created by VerRan.Liu on 2017/6/20.
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * Created by VerRan.Liu on 2017/6/20.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo("cloud-class:system ",//大标题
                "云中课堂系统，cloud-class",//小标题
                "1.0",//版本
                "http://verran.iteye.com",
                "VerRan.Liu",//作者
                "中软国际",//链接显示文字
                "http://www.chinasoftinc.com/"//网站链接
        );

        return apiInfo;
    }


    @SuppressWarnings("unchecked")
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("course-service")
                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(false)
                .pathMapping("/")
                .select()
                //.paths(Predicates.or(PathSelectors.regex("/swagger")))//过滤的接口
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

}
