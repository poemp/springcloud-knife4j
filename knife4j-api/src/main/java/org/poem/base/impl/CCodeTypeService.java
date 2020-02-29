package org.poem.base.impl;


import org.poem.ProviderName;
import org.poem.config.ErrMsgConfiguration;
import org.poem.vo.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author poem
 */
@Service
@FeignClient(name = ProviderName.BASE, configuration = {ErrMsgConfiguration.class})
public interface CCodeTypeService {

    /**
     * 获取码表列表
     * @return
     */
    @GetMapping("/v1/codeType/getCodeList")
    CommonResult<List<Object>> getCodeList();
}
