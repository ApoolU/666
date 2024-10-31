package com.kuafu.web.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>  用户表 </p>
 *
 * @author kuafuai
 * @description
 * @date 2024/09/23 11:10
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoAll  {
    @TableField(value="ui.technical_direction")
@JsonProperty(value = "technicalDirection")
    private Integer technicalDirection;
    @TableField(value="ui.user_name")
@JsonProperty(value = "userName")
    private String userName;
    @TableField(value="ui.phone_number")
@JsonProperty(value = "phoneNumber")
    private String phoneNumber;
    @TableField(value="tds.technical_status_description")
@JsonProperty(value = "technicalStatusDescription")
    private String technicalStatusDescription;
    @TableField(value="ui.user_info_id")
@JsonProperty(value = "userInfoId")
    private Integer userInfoId;
}
