package com.chenshun.test.controller;

import com.chenshun.test.bean.Account;
import com.chenshun.test.util.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * User: chenshun131 <p />
 * Time: 18/9/25 23:17  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@RestController
public class TestController {

    @GetMapping("/api/protected")
    public @ResponseBody
    Object hellWorld(@RequestHeader(value = JwtUtil.USER_NAME) String userId) {
        return "Your user id is '" + userId + "'";
    }

    @PostMapping("/login")
    public Object login(HttpServletResponse response, @RequestBody final Account account) throws IOException {
        if (isValidPassword(account)) {
            String jwt = JwtUtil.generateToken(account.username);
            Map<String, String> result = new HashMap<>(1);
            result.put("token", jwt);
            return result;
        } else {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
    }

    private boolean isValidPassword(Account credentials) {
        return "admin".equals(credentials.username) && "admin".equals(credentials.password);
    }

}
