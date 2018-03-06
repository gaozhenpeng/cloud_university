package com.chinasoft.gateway.config.swigger;

/**
 * Created by VerRan.Liu on 2017/6/20.
 */

import com.google.common.base.Predicates;
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
@Configuration //由于测试model时无法使用web环境，因此屏蔽此部份
@EnableSwagger2
public class SwaggerConfig {

    private ApiInfo systemApiInfo() {
        ApiInfo apiInfo = new ApiInfo("云中课堂-API网关 ",//大标题
                "Cloud_Class 云中课堂API文档",//小标题
                "1.0",//版本
                "http://verran.iteye.com",
                "VerRan.Liu",//作者
                "中软国际服务信息有限公司",//链接显示文字
                "http://www.chinasoftinc.com/"//网站链接
        );

        return apiInfo;
    }


    @SuppressWarnings("unchecked")
    @Bean
    public Docket LoginApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("chinasoftinc")
                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(false)
                .pathMapping("/")
                .select()
                //.paths(Predicates.or(PathSelectors.regex("/api/.*")))//过滤的接口
                .build()
                .apiInfo(systemApiInfo());
    }

}
