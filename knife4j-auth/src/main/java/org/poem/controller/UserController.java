package org.poem.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.poem.vo.CommonResult;
import org.poem.vo.auth.UserLoginVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author poem
 */
@RestController
@Api("01-用户管理")
@RequestMapping("/v1/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);


    @PostMapping("/login")
    @ApiOperation(value = "00101-用户登陆", notes = "01-授权管理", httpMethod = "POST")
    public CommonResult<String> login(@RequestBody UserLoginVO userLoginVO){
        return new CommonResult<>();
    }
}
