package com.aki.swaggertest;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "queryObj对象", description = "查询对象")
public class queryObj {
    @ApiModelProperty(value = "到报率1")
    private String val1;
    @ApiModelProperty(value = "到报率2")
    private String val2;
    @ApiModelProperty(value = "到报率3")
    private String val3;
}
