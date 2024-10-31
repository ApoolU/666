package com.kuafu.web.vo;

import lombok.AllArgsConstructor;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.Date;
import lombok.NoArgsConstructor;

/**
 * <p>技术方向枚举表</p>
 *
 * @author kuafuai
 * @description
 * @date 2024/09/23 11:10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TechnicalDirectionStatusVO  {

     @JsonProperty(value = "technicalStatusId")
    private Integer technicalStatusId;
     @JsonProperty(value = "technicalStatusDescription")
    private String technicalStatusDescription;

}
