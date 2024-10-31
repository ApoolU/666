package com.kuafu.web.vo;

import com.kuafu.common.domin.PageRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Date;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class UserInfoAllPageVO extends PageRequest {

    @JsonProperty(value = "technicalDirection")
    private Integer technicalDirection;
    @JsonProperty(value = "userName")
    private String userName;
    @JsonProperty(value = "phoneNumber")
    private String phoneNumber;
    @JsonProperty(value = "technicalStatusDescription")
    private String technicalStatusDescription;
    @JsonProperty(value = "userInfoId")
    private Integer userInfoId;

}
