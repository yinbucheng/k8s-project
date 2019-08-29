package cn.bucheng.server.remoting.fail;

import cn.bucheng.server.remoting.IServerB;
import org.springframework.stereotype.Component;

/**
 * @author ：yinchong
 * @create ：2019/8/29 14:52
 * @description：
 * @modified By：
 * @version:
 */
@Component
public class ServerBFail implements IServerB {
    public String hello() {
        return "fail to get Server-B hello";
    }

    public String trace(String traceId, String pid) {
        return "fail to invoke Server-B trace";
    }
}
