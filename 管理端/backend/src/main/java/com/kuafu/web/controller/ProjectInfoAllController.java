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


import lombok.RequiredArgsConstructor;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.kuafu.common.domin.BaseResponse;
import com.kuafu.common.domin.ErrorCode;
import com.kuafu.common.domin.ResultUtils;
import com.kuafu.common.util.StringUtils;
import com.kuafu.web.entity.SelectVO;
import com.kuafu.web.entity.ProjectInfoAll;
import com.kuafu.web.service.IProjectInfoAllService;
import com.kuafu.web.vo.ProjectInfoAllPageVO;

import com.kuafu.web.service.IUserInfoService;
import com.kuafu.web.entity.UserInfo;


/**
 * <p> 项目信息表 接口 </p>
 *
 * @author kuafuai
 * @description
 * @date 2024/09/23 11:10
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/projectInfoAll")
@Api(tags = {"项目信息表"})
public class ProjectInfoAllController  {

    private final IProjectInfoAllService projectInfoAllService;

    @PostMapping("page")
    @ApiOperation("全字段分页")
    public BaseResponse page(@RequestBody ProjectInfoAllPageVO pageVO){
        IPage<ProjectInfoAll> page = new Page<>(pageVO.getCurrent(), pageVO.getPageSize());
        LambdaQueryWrapper<ProjectInfoAll> queryWrapper = new LambdaQueryWrapper<>();

            if(pageVO.getTechnicalDirection() != null){
            queryWrapper.eq(ProjectInfoAll::getTechnicalDirection, pageVO.getTechnicalDirection());
        }
        if(StringUtils.isNotEmpty(pageVO.getProjectLeader())) {
            queryWrapper.eq(ProjectInfoAll::getProjectLeader, pageVO.getProjectLeader());
        }
        if(StringUtils.isNotEmpty(pageVO.getUserName())) {
            queryWrapper.like(ProjectInfoAll::getUserName, pageVO.getUserName());
        }
        if(StringUtils.isNotEmpty(pageVO.getProjectVersion())) {
            queryWrapper.eq(ProjectInfoAll::getProjectVersion, pageVO.getProjectVersion());
        }
        if(StringUtils.isNotEmpty(pageVO.getPhoneNumber())) {
            queryWrapper.eq(ProjectInfoAll::getPhoneNumber, pageVO.getPhoneNumber());
        }
        if(StringUtils.isNotEmpty(pageVO.getProjectName())) {
            queryWrapper.like(ProjectInfoAll::getProjectName, pageVO.getProjectName());
        }
        return ResultUtils.success(projectInfoAllService.page(page, queryWrapper));
    }

    @PostMapping("list")
    @ApiOperation("全字段列表")
    public BaseResponse list(@RequestBody ProjectInfoAllPageVO vo){
        LambdaQueryWrapper<ProjectInfoAll> queryWrapper = new LambdaQueryWrapper<>();

                if(vo.getTechnicalDirection() != null){
            queryWrapper.eq(ProjectInfoAll::getTechnicalDirection, vo.getTechnicalDirection());
        }
            if(StringUtils.isNotEmpty(vo.getProjectLeader())) {
            queryWrapper.eq(ProjectInfoAll::getProjectLeader, vo.getProjectLeader());
        }
            if(StringUtils.isNotEmpty(vo.getUserName())) {
            queryWrapper.like(ProjectInfoAll::getUserName, vo.getUserName());
        }
            if(StringUtils.isNotEmpty(vo.getProjectVersion())) {
            queryWrapper.eq(ProjectInfoAll::getProjectVersion, vo.getProjectVersion());
        }
            if(StringUtils.isNotEmpty(vo.getPhoneNumber())) {
            queryWrapper.eq(ProjectInfoAll::getPhoneNumber, vo.getPhoneNumber());
        }
            if(StringUtils.isNotEmpty(vo.getProjectName())) {
            queryWrapper.like(ProjectInfoAll::getProjectName, vo.getProjectName());
        }
        return ResultUtils.success(projectInfoAllService.list(queryWrapper));
    }

    @GetMapping("get/{id}")
    @ApiOperation("根据Id查询")
    public BaseResponse get(@PathVariable(value="id") Integer projectInfoId) {
        ProjectInfoAll entity = this.projectInfoAllService.getById(projectInfoId);
        return entity!=null ? ResultUtils.success(entity) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
    }


        private final IUserInfoService userInfoService;

        @GetMapping("get/user_info_list")
        @ApiOperation("查询下拉框的外键信息")
        public BaseResponse get_user_info_list() {
            List<UserInfo> list = this.userInfoService.list();
            final List<SelectVO> selectVoList = list.stream().map(p ->
                new SelectVO(p.getUserInfoId(), p.getUserName().toString()))
                        .collect(Collectors.toList());
            return ResultUtils.success(selectVoList);
        }

}
