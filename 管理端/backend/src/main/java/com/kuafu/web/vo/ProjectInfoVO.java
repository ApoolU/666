package com.kuafu.web.vo;

import lombok.AllArgsConstructor;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.Date;
import lombok.NoArgsConstructor;

/**
 * <p>项目信息表</p>
 *
 * @author kuafuai
 * @description
 * @date 2024/09/23 11:10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectInfoVO  {

     @JsonProperty(value = "projectInfoId")
    private Integer projectInfoId;
     @JsonProperty(value = "projectName")
    private String projectName;
     @JsonProperty(value = "projectVersion")
    private String projectVersion;
     @JsonProperty(value = "projectLeader")
    private String projectLeader;

}
