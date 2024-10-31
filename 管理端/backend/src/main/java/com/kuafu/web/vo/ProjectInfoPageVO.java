package com.kuafu.web.vo;

import java.util.Date;

import com.kuafu.common.domin.PageRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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
public class ProjectInfoPageVO extends PageRequest {

    @JsonProperty(value = "projectInfoId")
    private Integer projectInfoId;
    @JsonProperty(value = "projectName")
    private String projectName;
    @JsonProperty(value = "projectVersion")
    private String projectVersion;
    @JsonProperty(value = "projectLeader")
    private String projectLeader;

}
