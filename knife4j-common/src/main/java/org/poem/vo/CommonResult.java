package org.poem.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author poem
 */
@Data
@ApiModel("返回的实体")
public class CommonResult<T> {

    @ApiModelProperty("编码 0 成功  1 失败")
    private Integer code = 0;

    @ApiModelProperty("消息")
    private String message;

    @ApiModelProperty("返回的数据")
    private T  data;
}
