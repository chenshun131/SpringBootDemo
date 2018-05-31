package com.chenshun.common.util;

import java.util.Random;

/**
 * User: mew <p />
 * Time: 18/5/31 17:32  <p />
 * Version: V1.0  <p />
 * Description: 端口工具类 <p />
 */
public class ServerPortUtils {

    /**
     * 获取可用端口，范围2000-65535
     *
     * @return
     */
    public static int getAvailablePort() {
        int max = 65535;
        int min = 2000;
        Random random = new Random();
        int port = random.nextInt(max) % (max - min + 1) + min;
        boolean using = NetUtils.isLoclePortUsing(port);
        if (using) {
            return getAvailablePort();
        } else {
            return port;
        }
    }

}
