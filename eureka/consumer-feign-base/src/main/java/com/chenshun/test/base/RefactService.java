package com.chenshun.test.base;

import com.chenshun.test.bean.User;
import org.springframework.web.bind.annotation.*;

/**
 * User: mew <p />
 * Time: 18/5/16 13:12  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@RequestMapping("refactor")
public interface RefactService {

    @RequestMapping("/hello4")
    String helloService(@RequestParam("name") String name);

    @GetMapping("/hello5")
    User helloService(@RequestHeader("name") String name, @RequestHeader("age") Integer age);

    /**
     * 发送对象，需要使用 POST
     *
     * @param user
     * @return
     */
    @PostMapping("/hello6")
    String helloService(@RequestBody User user);

}
