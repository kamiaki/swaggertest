package com.aki.swaggertest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "test")
@Api(tags = "ControllerTest1", description = "测试swagger")
public class ControllerTest1 {

    @RequestMapping(value = "queryTest")
    @ApiOperation(value = "测试方法")
    public returnObj queryTest(@RequestBody queryObj queryObj){
        System.out.println(queryObj);
        System.out.println(queryObj.getVal1());
        returnObj returnObj = new returnObj();
        return returnObj;
    }

}
