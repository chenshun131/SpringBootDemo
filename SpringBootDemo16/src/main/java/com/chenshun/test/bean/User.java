package com.chenshun.test.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * User: mew <p />
 * Time: 18/5/9 13:47  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@ToString(exclude = {"age"}, callSuper = true)
public class User extends Base {

    @Setter
    @Getter
    private String phone;

    @Setter
    @Getter
    private Integer age;

    public static void main(String[] args) {
        User user = new User();
        user.setId(1);
        user.setName("name");
        user.setPhone("15623459526");
        user.setAge(18);
        System.out.println(user.toString());
        // 打印
        // User(super=Base(id=1, name=name), phone=15623459526)
    }

}
