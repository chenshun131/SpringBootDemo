package com.chenshun.test.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

/**
 * User: mew <p />
 * Time: 18/3/27 16:33  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@ShellComponent
public class MyCommands {

    @ShellMethod("Add two integers together.")
    public int add(int a, int b) {
        return a + b;
    }

}
