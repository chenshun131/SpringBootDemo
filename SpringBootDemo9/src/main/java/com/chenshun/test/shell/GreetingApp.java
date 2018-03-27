package com.chenshun.test.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

/**
 * User: mew <p />
 * Time: 18/3/27 15:51  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@ShellComponent
public class GreetingApp {

    @ShellMethod("Say hi")
    public String sayHi(String name) {
        return String.format("Hi %s", name);
    }

    @ShellMethod("Echo1")
    public String echo1(int a, int b, int c) {
        return String.format("a = %d, b = %d, c = %d", a, b, c);
    }

}
