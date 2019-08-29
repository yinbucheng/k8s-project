package cn.bucheng.server;

import cn.bucheng.discover.annotation.EnableRegisterClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ：yinchong
 * @create ：2019/8/29 14:57
 * @description：
 * @modified By：
 * @version:
 */
@SpringBootApplication
@EnableRegisterClient
public class ServerBApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServerBApplication.class,args);
    }
}
