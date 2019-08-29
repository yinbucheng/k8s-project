package cn.bucheng.server;

import cn.bucheng.discover.annotation.EnableRegisterClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author ：yinchong
 * @create ：2019/8/29 14:47
 * @description：
 * @modified By：
 * @version:
 */
@SpringBootApplication
@EnableFeignClients
@EnableRegisterClient
public class ServerAApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerAApplication.class,args);
    }
}
