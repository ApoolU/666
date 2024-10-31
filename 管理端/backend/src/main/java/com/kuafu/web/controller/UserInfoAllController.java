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
import com.kuafu.web.entity.UserInfoAll;
import com.kuafu.web.service.IUserInfoAllService;
import com.kuafu.web.vo.UserInfoAllPageVO;

import com.kuafu.web.service.ITechnicalDirectionStatusService;
import com.kuafu.web.entity.TechnicalDirectionStatus;


/**
 * <p> 用户表 接口 </p>
 *
 * @author kuafuai
 * @description
 * @date 2024/09/23 11:10
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/userInfoAll")
@Api(tags = {"用户表"})
public class UserInfoAllController  {

    private final IUserInfoAllService userInfoAllService;

    @PostMapping("page")
    @ApiOperation("全字段分页")
    public BaseResponse page(@RequestBody UserInfoAllPageVO pageVO){
        IPage<UserInfoAll> page = new Page<>(pageVO.getCurrent(), pageVO.getPageSize());
        LambdaQueryWrapper<UserInfoAll> queryWrapper = new LambdaQueryWrapper<>();

            if(pageVO.getTechnicalDirection() != null){
            queryWrapper.eq(UserInfoAll::getTechnicalDirection, pageVO.getTechnicalDirection());
        }
        if(StringUtils.isNotEmpty(pageVO.getUserName())) {
            queryWrapper.like(UserInfoAll::getUserName, pageVO.getUserName());
        }
        if(StringUtils.isNotEmpty(pageVO.getPhoneNumber())) {
            queryWrapper.eq(UserInfoAll::getPhoneNumber, pageVO.getPhoneNumber());
        }
        if(StringUtils.isNotEmpty(pageVO.getTechnicalStatusDescription())) {
            queryWrapper.eq(UserInfoAll::getTechnicalStatusDescription, pageVO.getTechnicalStatusDescription());
        }
        return ResultUtils.success(userInfoAllService.page(page, queryWrapper));
    }

    @PostMapping("list")
    @ApiOperation("全字段列表")
    public BaseResponse list(@RequestBody UserInfoAllPageVO vo){
        LambdaQueryWrapper<UserInfoAll> queryWrapper = new LambdaQueryWrapper<>();

                if(vo.getTechnicalDirection() != null){
            queryWrapper.eq(UserInfoAll::getTechnicalDirection, vo.getTechnicalDirection());
        }
            if(StringUtils.isNotEmpty(vo.getUserName())) {
            queryWrapper.like(UserInfoAll::getUserName, vo.getUserName());
        }
            if(StringUtils.isNotEmpty(vo.getPhoneNumber())) {
            queryWrapper.eq(UserInfoAll::getPhoneNumber, vo.getPhoneNumber());
        }
            if(StringUtils.isNotEmpty(vo.getTechnicalStatusDescription())) {
            queryWrapper.eq(UserInfoAll::getTechnicalStatusDescription, vo.getTechnicalStatusDescription());
        }
        return ResultUtils.success(userInfoAllService.list(queryWrapper));
    }

    @GetMapping("get/{id}")
    @ApiOperation("根据Id查询")
    public BaseResponse get(@PathVariable(value="id") Integer userInfoId) {
        UserInfoAll entity = this.userInfoAllService.getById(userInfoId);
        return entity!=null ? ResultUtils.success(entity) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
    }


        private final ITechnicalDirectionStatusService technicalDirectionStatusService;

        @GetMapping("get/technical_direction_status_list")
        @ApiOperation("查询下拉框的外键信息")
        public BaseResponse get_technical_direction_status_list() {
            List<TechnicalDirectionStatus> list = this.technicalDirectionStatusService.list();
            final List<SelectVO> selectVoList = list.stream().map(p ->
                new SelectVO(p.getTechnicalStatusId(), p.getTechnicalStatusDescription().toString()))
                        .collect(Collectors.toList());
            return ResultUtils.success(selectVoList);
        }

}
