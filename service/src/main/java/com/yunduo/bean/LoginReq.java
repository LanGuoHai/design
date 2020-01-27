package com.yunduo.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("登录请求")
public class LoginReq {
    @ApiModelProperty("账号")
    private Integer account;
    @ApiModelProperty
    private String password;
}