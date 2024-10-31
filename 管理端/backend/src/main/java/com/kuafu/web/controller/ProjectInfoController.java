package com.kuafu.web.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.kuafu.web.entity.SelectVO;

import lombok.RequiredArgsConstructor;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.kuafu.common.domin.BaseResponse;
import com.kuafu.common.domin.ErrorCode;
import com.kuafu.common.domin.ResultUtils;
import com.kuafu.common.util.StringUtils;
import com.kuafu.web.entity.ProjectInfo;
import com.kuafu.web.service.IProjectInfoService;
import com.kuafu.web.vo.ProjectInfoPageVO;
import com.kuafu.web.vo.ProjectInfoVO;


/**
 * <p> 项目信息表 接口 </p>
 *
 * @author kuafuai
 * @description
 * @date 2024/09/23 11:10
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/projectInfo")
@Api(tags = {"项目信息表"})
public class ProjectInfoController  {

    private final IProjectInfoService projectInfoService;

    @PostMapping("page")
    @ApiOperation("分页")
    public BaseResponse page( @RequestBody ProjectInfoPageVO pageVO){
        IPage<ProjectInfo> page = new Page<>(pageVO.getCurrent(), pageVO.getPageSize());
        LambdaQueryWrapper<ProjectInfo> queryWrapper = new LambdaQueryWrapper<>();

            if(StringUtils.isNotEmpty(pageVO.getProjectName())) {
            queryWrapper.like(ProjectInfo::getProjectName, pageVO.getProjectName());
        }
            if(StringUtils.isNotEmpty(pageVO.getProjectVersion())) {
            queryWrapper.eq(ProjectInfo::getProjectVersion, pageVO.getProjectVersion());
        }
            if(StringUtils.isNotEmpty(pageVO.getProjectLeader())) {
            queryWrapper.eq(ProjectInfo::getProjectLeader, pageVO.getProjectLeader());
        }
        return ResultUtils.success(projectInfoService.page(page, queryWrapper));
    }

    @PostMapping("list")
    @ApiOperation("列表")
    public BaseResponse list( @RequestBody ProjectInfoVO vo){
        LambdaQueryWrapper<ProjectInfo> queryWrapper = new LambdaQueryWrapper<>();

            if(StringUtils.isNotEmpty(vo.getProjectName())) {
            queryWrapper.like(ProjectInfo::getProjectName, vo.getProjectName());
        }
            if(StringUtils.isNotEmpty(vo.getProjectVersion())) {
            queryWrapper.eq(ProjectInfo::getProjectVersion, vo.getProjectVersion());
        }
            if(StringUtils.isNotEmpty(vo.getProjectLeader())) {
            queryWrapper.eq(ProjectInfo::getProjectLeader, vo.getProjectLeader());
        }
        return ResultUtils.success(projectInfoService.list(queryWrapper));
    }


            @PostMapping("get_select_list")
            @ApiOperation("获取所有的下拉列表")
            public BaseResponse get_select_list( ){
                LambdaQueryWrapper<ProjectInfo> queryWrapper = new LambdaQueryWrapper<>();
                queryWrapper.select(ProjectInfo::getProjectInfoId);

        List<ProjectInfo> list =projectInfoService.list(queryWrapper);
        final List<SelectVO> selectVOS = list.stream().map(l -> new SelectVO(l.getProjectInfoId(), l.getProjectInfoId().toString())).collect(Collectors.toList());
        return ResultUtils.success(selectVOS);

                }

    @PostMapping("add")
    @ApiOperation("新增")
    public BaseResponse add( @RequestBody ProjectInfoVO vo) {
        ProjectInfo entity =  ProjectInfo.builder()
                    .projectName(vo.getProjectName())
                    .projectVersion(vo.getProjectVersion())
                    .projectLeader(vo.getProjectLeader())
                .build();
        boolean flag =this.projectInfoService.save(entity);
        return flag ? ResultUtils.success() : ResultUtils.error(ErrorCode.OPERATION_ERROR);
    }

    @PutMapping("update")
    @ApiOperation("更新")
    public BaseResponse update( @RequestBody ProjectInfoVO vo) {
        ProjectInfo entity =  ProjectInfo.builder()
                    .projectInfoId(vo.getProjectInfoId())
                    .projectName(vo.getProjectName())
                    .projectVersion(vo.getProjectVersion())
                    .projectLeader(vo.getProjectLeader())
                .build();
        boolean flag = this.projectInfoService.updateById(entity);
        return flag ? ResultUtils.success() : ResultUtils.error(ErrorCode.OPERATION_ERROR);
    }


    @GetMapping("get/{id}")
    @ApiOperation("根据Id查询")
    public BaseResponse get(@PathVariable(value="id") Integer projectInfoId) {
        ProjectInfo entity = this.projectInfoService.getById(projectInfoId);
        return entity!=null ? ResultUtils.success(entity) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
    }


    @DeleteMapping("delete/{id}")
    @ApiOperation("删除")
    public BaseResponse delete(@PathVariable(value="id") Integer projectInfoId) {
        boolean flag = this.projectInfoService.removeById(projectInfoId);
        return flag ? ResultUtils.success() : ResultUtils.error(ErrorCode.OPERATION_ERROR);
    }

}
