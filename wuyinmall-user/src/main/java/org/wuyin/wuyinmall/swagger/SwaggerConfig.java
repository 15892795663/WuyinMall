package org.wuyin.wuyinmall.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @Description:
 * @Author: wuyin
 * @Date: Created in 21:57 2020/5/28
 */
@Configuration
public class SwaggerConfig {
    // 接口版本号
    private final String version = "3.0";
    // 接口大标题
    private final String title = "快乐蜗牛商城V3.0文档";
    // 具体的描述
    private final String description = "用户服务";
    // 服务说明url
    private final String termsOfServiceUrl = "http://www.kingeid.com";
    // 接口作者联系方式
    private final Contact contact = new Contact("fourColor", "https://github.com/15892795663", "596000933e@qq.com");

    @Bean
    public Docket buildDocket(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(buildApiInfo())
                .select().build();
    }
    private ApiInfo buildApiInfo(){
        return new ApiInfoBuilder().title(title).termsOfServiceUrl(termsOfServiceUrl).description(description)
                .version(version).contact(contact).build();
    }
}
