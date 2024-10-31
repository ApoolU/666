package com.kuafu.web.vo;

import com.kuafu.common.domin.PageRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Date;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * <p>项目信息表-分页列表-响应参数</p>
 *
 * @author kuafuai
 * @description
 * @date 2024/09/23 11:10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ProjectInfoAllPageVO extends PageRequest {

    @JsonProperty(value = "technicalDirection")
    private Integer technicalDirection;
    @JsonProperty(value = "projectLeader")
    private String projectLeader;
    @JsonProperty(value = "userName")
    private String userName;
    @JsonProperty(value = "projectVersion")
    private String projectVersion;
    @JsonProperty(value = "phoneNumber")
    private String phoneNumber;
    @JsonProperty(value = "projectName")
    private String projectName;
    @JsonProperty(value = "projectInfoId")
    private Integer projectInfoId;

}
