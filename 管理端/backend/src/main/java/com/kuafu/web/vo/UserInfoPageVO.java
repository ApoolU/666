package com.kuafu.web.vo;

import java.util.Date;

import com.kuafu.common.domin.PageRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * <p>用户表-分页列表-响应参数</p>
 *
 * @author kuafuai
 * @description
 * @date 2024/09/23 11:10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserInfoPageVO extends PageRequest {

    @JsonProperty(value = "userInfoId")
    private Integer userInfoId;
    @JsonProperty(value = "userName")
    private String userName;
    @JsonProperty(value = "phoneNumber")
    private String phoneNumber;
    @JsonProperty(value = "technicalDirection")
    private Integer technicalDirection;

}
