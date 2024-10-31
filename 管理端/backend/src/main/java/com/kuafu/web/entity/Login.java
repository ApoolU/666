package com.kuafu.web.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>  登录表 </p>
 *
 * @author kuafuai
 * @description
 * @date 2024/09/23 11:10
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("login")
//登录信息功能
public class Login  {
    @TableId(value = "login_id", type = IdType.AUTO)
    @JsonProperty(value = "loginId")
    private Integer loginId;
    @JsonProperty(value = "relevanceId")
    private String relevanceId;
    @JsonProperty(value = "password")
    private String password;
    @JsonProperty(value = "userName")
    private String userName;
    @JsonProperty(value = "relevanceTable")
    private String relevanceTable;
    @JsonProperty(value = "phoneNumber")
    private String phoneNumber;
    @JsonProperty(value = "wxOpenId")
    private String wxOpenId;
}
