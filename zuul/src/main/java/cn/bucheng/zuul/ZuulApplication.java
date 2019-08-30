package cn.bucheng.zuul;

import cn.bucheng.discover.annotation.EnableRegisterClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author buchengyin
 * @create 2019/8/30 17:34
 * @describe
 */
@SpringBootApplication
@EnableZuulProxy
@EnableRegisterClient
public class ZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
    }
}
