package org.poem.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.poem.vo.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author poem
 */
@RestController
@Api("02-码表管理")
@RequestMapping("/v1/codeType")
public class CodeTypeController {

    /**
     * 获取码表列表
     * @return
     */
    @GetMapping("/getCodeList")
    @ApiOperation(value = "0201-获取码表列表", notes = "01-授权管理", httpMethod = "POST")
    public CommonResult<List<Object>> getCodeList(){
        return new CommonResult<>();
    }
}
