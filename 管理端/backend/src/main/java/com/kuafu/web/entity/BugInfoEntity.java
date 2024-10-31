package com.kuafu.web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * <p>  BUG表 </p>
 *
 * @author kuafuai
 * @description
 * @date 2024/09/23 11:10
 */
@Data
public class BugInfoEntity {

    private Integer bugInfoId;
    private Integer bugDiscoverer;
    private Integer bugSubmitter;
    private Integer bugHandler;
    private String bugTitle;
    private String bugDescription;
    private String bugImage;
    private Integer projectInfoId;
    private Date bugDeadline;
    private Integer bugPriority;
    private Integer bugHandleStatus;
    private Date createdTime;
}
