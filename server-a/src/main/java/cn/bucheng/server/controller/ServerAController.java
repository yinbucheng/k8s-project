package cn.bucheng.server.controller;

import cn.bucheng.server.remoting.IServerB;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author ：yinchong
 * @create ：2019/8/29 14:49
 * @description：
 * @modified By：
 * @version:
 */
@RestController()
@RequestMapping("server")
@Slf4j
public class ServerAController {
    @Autowired
    private IServerB serverB;

    @RequestMapping("hello")
    public String hello() {
        return "hello i am Server-A";
    }

    @RequestMapping("trace")
    public String trace(String traceId) {
        String xid = UUID.randomUUID().toString().toLowerCase();
        log.info("server a traceId:{},currentId:{}", traceId, xid);
        return serverB.trace(traceId, xid);
    }
}
