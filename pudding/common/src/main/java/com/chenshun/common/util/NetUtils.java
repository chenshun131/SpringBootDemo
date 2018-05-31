package com.chenshun.common.util;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

/**
 * User: mew <p />
 * Time: 18/5/31 17:33  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public class NetUtils {

    /***
     *  true:already in using  false:not using
     * @param port
     */
    public static boolean isLoclePortUsing(int port) {
        boolean flag = true;
        try {
            flag = isPortUsing("127.0.0.1", port);
        } catch (Exception e) {
        }
        return flag;
    }

    /***
     *  true:already in using  false:not using
     * @param host
     * @param port
     */
    public static boolean isPortUsing(String host, int port) {
        boolean flag = false;
        try (Socket socket = new Socket(InetAddress.getByName(host), port)) {
            flag = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return flag;
    }

}
