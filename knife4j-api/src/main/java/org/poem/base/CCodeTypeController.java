package org.poem.base;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.poem.base.impl.CCodeTypeService;
import org.poem.vo.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author poem
 */
@RestController
@Api(tags = "02-码表管理")
@RequestMapping("/v1/codeType")
public class CCodeTypeController {

    @Autowired
    private CCodeTypeService cCodeTypeService;
    /**
     * 获取码表列表
     * @return
     */
    @GetMapping("/getCodeList")
    @ApiOperation(value = "0201-获取码表列表", notes = "01-授权管理", httpMethod = "GET")
    public CommonResult<List<Object>> getCodeList(){
        return this.cCodeTypeService.getCodeList();
    }
}
