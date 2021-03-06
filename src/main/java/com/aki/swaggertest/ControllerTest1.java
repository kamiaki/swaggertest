package com.aki.swaggertest;

import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

//@ApiImplicitParams({@ApiImplicitParam(name = "params", required = true, dataType = "Map", paramType = "body",
//        value = "说明:" +
//                "示例:")})
//@ApiResponses({@ApiResponse(code = 200,
//        message = "说明:" +
//                "示例:")})

@Slf4j
@RestController
@RequestMapping(value = "test")
@Api(tags = "ControllerTest1", description = "测试swagger")
public class ControllerTest1 {

    @RequestMapping(value = "queryTest")
    /**
     * @ApiOperation："用在请求的方法上，说明方法的作用"
     *     value="说明方法的作用"
     *     notes="方法的备注说明"
     *     httpMethod = "POST" 请求方式
     */
    @ApiOperation(value = "测试方法", httpMethod = "POST", notes = "备注备注")
    /**
     * @ApiImplicitParams：用在请求的方法上，包含一组参数说明
     *     @ApiImplicitParam：对单个参数的说明
     *         name：参数名
     *         value：参数的汉字说明、解释
     *         required：参数是否必须传
     *         paramType：参数放在哪个地方
     *             · header --> 请求参数的获取：@RequestHeader
     *             · query --> 请求参数的获取：@RequestParam
     *             · path（用于restful接口）--> 请求参数的获取：@PathVariable
     *             · body（请求体）-->  @RequestBody User user
     *             · form（普通表单提交）
     *         dataType：参数类型，默认String，其它值dataType="int"
     *         defaultValue：参数的默认值
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "mobile", value = "手机号", required = true,  dataType = "string"),
            @ApiImplicitParam(name = "password", value = "密码", required = true,   dataType = "string"),
            @ApiImplicitParam(name = "age", value = "年龄", required = true,  dataType = "string")
    })
    /**
     * 属性名称	数据类型	默认值	说明
     * name	String	“”	参数名称(实体类字段名称)
     * value	String	“”	参数简要说明
     * defaultValue	String	“”	描述参数的默认值
     * allowableValues	String	“”	限制此参数接收的值，可使用的值或值得范围
     * required	boolean	false	指定是否为必填参数,false:非必传参数; true:必传参数
     * access	String	“”	参数过滤，参考: io.swagger.core.filter.SwaggerSpecFilte
     * allowMultiple	boolean	false	指定参数是否可以通过多次出现来接收多个值
     * dataType	String	“”	参数的数据类型，可以使类名或原始数据类型
     * dataTypeClass	Class<?>	Void.class	参数的类，如果提供则覆盖 dataType
     * paramType	String	“”	参数的参数类型，有效值为 path, query, body, header, form
     * example	String	“”	非请求体(body)参数的单个请求示例
     * examples	Example	@Example(value = @ExampleProperty(mediaType = “”, value = “”))	参数示例，仅适用于 BodyParameters(请求体类型的)
     * type	String	“”	添加覆盖检测到的类型的功能
     * format	String	“”	添加提供自定义格式的功能
     * allowEmptyValue	boolean	false	添加将 format 设置为空的功能
     * readOnly	boolean	false	添加被指定为只读的能力
     * collectionFormat	String	“”	添加使用 array 类型 collectionFormat 的功能
     */
    @ApiImplicitParam(name = "map", value = "{name: '行命', age: '岁数'}", required = true, paramType = "body")
    /**
     * @ApiResponses：方法返回对象的说明
     *     @ApiResponse：每个参数的说明
     *         code：数字，例如400
     *         message：信息，例如"请求参数没填好"
     *         response：抛出异常的类
     */
    @ApiResponses({
            @ApiResponse(code = 200, message = "{name: '行命', age: '岁数'}"),
            @ApiResponse(code = 201, message = "{name: '222', age: '333'}"),
    })
    public returnObj queryTest(@RequestBody Map map) {
        System.out.println(map.toString());
        returnObj returnObj = new returnObj();
        return returnObj;
    }

    @RequestMapping(value = "queryTest2")
    @ApiOperation(value = "测试方法2", httpMethod = "POST", notes = "备注备注2")
    /**
     * 单个参数
     */
//    @ApiImplicitParam(name = "depId", value = "部门id", required = true, paramType = "query")
    public returnObj queryTest2(@RequestBody queryObj queryObj, String depId) {
        System.out.println(depId);
        System.out.println(queryObj);
        System.out.println(queryObj.getVal1());
        returnObj returnObj = new returnObj();
        return returnObj;
    }
}
