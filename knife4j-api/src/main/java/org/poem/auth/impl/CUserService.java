package org.poem.auth.impl;

import org.poem.ProviderName;
import org.poem.config.ErrMsgConfiguration;
import org.poem.vo.CommonResult;
import org.poem.vo.auth.UserLoginVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author poem
 */
@Service
@FeignClient(name = ProviderName.AUTH, configuration = {ErrMsgConfiguration.class})
public interface CUserService {

    @PostMapping("/v1/user/login")
    CommonResult<String> login(@RequestBody UserLoginVO userLoginVO);
}
