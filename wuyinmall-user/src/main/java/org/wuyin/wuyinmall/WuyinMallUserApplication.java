package org.wuyin.wuyinmall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
@MapperScan("org.wuyin.wuyinmall.dao")
public class WuyinMallUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(WuyinMallUserApplication.class,args);
    }
}
