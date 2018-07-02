package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.util.Date;

/**
 * User: chenshun131 <p />
 * Time: 18/6/24 09:22  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@Data
public class User {

    public interface UserSimpleView {

    }

    public interface UserDetailView extends UserSimpleView {

    }

    @JsonView(UserSimpleView.class)
    private String id;

    //    @MyConstraint(message = "这是一个测试")
    @JsonView(UserSimpleView.class)
    @ApiModelProperty(value = "用户名")
    private String username;

    @JsonView(UserDetailView.class)
    @NotBlank(message = "密码不能为空")
    private String password;

    @JsonView(UserSimpleView.class)
    @Past(message = "生日必须是过去的时间")
    private Date birthday;

}
