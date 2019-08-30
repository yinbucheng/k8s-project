package cn.bucheng.zipkin;

import cn.bucheng.discover.annotation.EnableRegisterClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin2.server.internal.EnableZipkinServer;

/**
 * @author buchengyin
 * @create 2019/8/30 17:39
 * @describe
 */
@SpringBootApplication
@EnableZipkinServer
@EnableRegisterClient
public class ZipkinServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZipkinServerApplication.class,args);
    }
}
