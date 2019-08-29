package cn.bucheng.server.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author ：yinchong
 * @create ：2019/8/29 14:59
 * @description：
 * @modified By：
 * @version:
 */
@RestController
@RequestMapping("server")
@Slf4j
public class ServerBController {

    @RequestMapping("hello")
    public String hello() {
        return "hello i am Server-B";
    }

    @RequestMapping("trace")
    public String trace(@RequestParam("traceId") String traceId, @RequestParam("pid") String pid) {
        String xid = UUID.randomUUID().toString().toLowerCase();
        log.info("server b traceId:{} ,pid:{},currentId:{}", traceId, pid, xid);
        return "server b receive trace invoke ,server b xid:" + xid;
    }
}
