package org.poem.vo.auth;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author poem
 */
@ApiModel("用户登录")
@Data
public class UserLoginVO {

    private String loginName;

    private String password;
}
