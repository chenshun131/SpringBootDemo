package com.chenshun.test;

import com.alibaba.druid.filter.config.ConfigTools;
import org.junit.Test;

/**
 * User: mew <p />
 * Time: 18/3/28 15:54  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public class DruidTest {

    private static final String DEFAULT_PRIVATE_KEY_STRING =
            "MIIBVAIBADANBgkqhkiG9w0BAQEFAASCAT4wggE6AgEAAkEAocbCrurZGbC5GArEHKlAfDSZi7gFBnd4yxOt0rwTqKBFzGyhtQLu5PRKjEiOXVa95aeIIBJ6OhC2f8FjqFUpawIDAQABAkAPejKaBYHrwUqUEEOe8lpnB6lBAsQIUFnQI/vXU4MV+MhIzW0BLVZCiarIQqUXeOhThVWXKFt8GxCykrrUsQ6BAiEA4vMVxEHBovz1di3aozzFvSMdsjTcYRRo82hS5Ru2/OECIQC2fAPoXixVTVY7bNMeuxCP4954ZkXp7fEPDINCjcQDywIgcc8XLkkPcs3Jxk7uYofaXaPbg39wuJpEmzPIxi3k0OECIGubmdpOnin3HuCP/bbjbJLNNoUdGiEmFL5hDI4UdwAdAiEAtcAwbm08bKN7pwwvyqaCBC//VnEWaq39DCzxr+Z2EIk=";

    public static final String DEFAULT_PUBLIC_KEY_STRING =
            "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAKHGwq7q2RmwuRgKxBypQHw0mYu4BQZ3eMsTrdK8E6igRcxsobUC7uT0SoxIjl1WveWniCASejoQtn/BY6hVKWsCAwEAAQ==";

    @Test
    public void test() throws Exception {
        String password = "123456";
        String[] arr = ConfigTools.genKeyPair(512);
        System.out.println("privateKey:" + password);
        System.out.println("password:" + ConfigTools.encrypt(DEFAULT_PRIVATE_KEY_STRING, password));
    }

}
