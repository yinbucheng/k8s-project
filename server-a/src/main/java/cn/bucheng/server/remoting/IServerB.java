package cn.bucheng.server.remoting;

import cn.bucheng.server.remoting.fail.ServerBFail;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author ：yinchong
 * @create ：2019/8/29 14:51
 * @description：
 * @modified By：
 * @version:
 */
@FeignClient(value = "server-b", fallback = ServerBFail.class)
public interface IServerB {

    @RequestMapping("/server/hello")
    String hello();

    @RequestMapping("/server/trace")
    String trace(@RequestParam("traceId") String traceId, @RequestParam("pid") String pid);
}
