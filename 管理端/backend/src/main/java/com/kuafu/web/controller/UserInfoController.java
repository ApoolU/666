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
import com.kuafu.web.entity.UserInfo;
import com.kuafu.web.service.IUserInfoService;
import com.kuafu.web.vo.UserInfoPageVO;
import com.kuafu.web.vo.UserInfoVO;


/**
 * <p> 用户表 接口 </p>
 *
 * @author kuafuai
 * @description
 * @date 2024/09/23 11:10
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/userInfo")
@Api(tags = {"用户表"})
public class UserInfoController  {

    private final IUserInfoService userInfoService;

    @PostMapping("page")
    @ApiOperation("分页")
    public BaseResponse page( @RequestBody UserInfoPageVO pageVO){
        IPage<UserInfo> page = new Page<>(pageVO.getCurrent(), pageVO.getPageSize());
        LambdaQueryWrapper<UserInfo> queryWrapper = new LambdaQueryWrapper<>();

            if(StringUtils.isNotEmpty(pageVO.getUserName())) {
            queryWrapper.like(UserInfo::getUserName, pageVO.getUserName());
        }
            if(StringUtils.isNotEmpty(pageVO.getPhoneNumber())) {
            queryWrapper.eq(UserInfo::getPhoneNumber, pageVO.getPhoneNumber());
        }
            if(pageVO.getTechnicalDirection() != null){
            queryWrapper.eq(UserInfo::getTechnicalDirection, pageVO.getTechnicalDirection());
        }
        return ResultUtils.success(userInfoService.page(page, queryWrapper));
    }

    @PostMapping("list")
    @ApiOperation("列表")
    public BaseResponse list( @RequestBody UserInfoVO vo){
        LambdaQueryWrapper<UserInfo> queryWrapper = new LambdaQueryWrapper<>();

            if(StringUtils.isNotEmpty(vo.getUserName())) {
            queryWrapper.like(UserInfo::getUserName, vo.getUserName());
        }
            if(StringUtils.isNotEmpty(vo.getPhoneNumber())) {
            queryWrapper.eq(UserInfo::getPhoneNumber, vo.getPhoneNumber());
        }
                if(vo.getTechnicalDirection() != null){
            queryWrapper.eq(UserInfo::getTechnicalDirection, vo.getTechnicalDirection());
        }
        return ResultUtils.success(userInfoService.list(queryWrapper));
    }


            @PostMapping("get_select_list")
            @ApiOperation("获取所有的下拉列表")
            public BaseResponse get_select_list( ){
                LambdaQueryWrapper<UserInfo> queryWrapper = new LambdaQueryWrapper<>();
                queryWrapper.select(UserInfo::getUserInfoId);

        List<UserInfo> list =userInfoService.list(queryWrapper);
        final List<SelectVO> selectVOS = list.stream().map(l -> new SelectVO(l.getUserInfoId(), l.getUserInfoId().toString())).collect(Collectors.toList());
        return ResultUtils.success(selectVOS);

                }

    @PostMapping("add")
    @ApiOperation("新增")
    public BaseResponse add( @RequestBody UserInfoVO vo) {
        UserInfo entity =  UserInfo.builder()
                    .userName(vo.getUserName())
                    .phoneNumber(vo.getPhoneNumber())
                    .technicalDirection(vo.getTechnicalDirection())
                .build();
        boolean flag =this.userInfoService.save(entity);
        return flag ? ResultUtils.success() : ResultUtils.error(ErrorCode.OPERATION_ERROR);
    }

    @PutMapping("update")
    @ApiOperation("更新")
    public BaseResponse update( @RequestBody UserInfoVO vo) {
        UserInfo entity =  UserInfo.builder()
                    .userInfoId(vo.getUserInfoId())
                    .userName(vo.getUserName())
                    .phoneNumber(vo.getPhoneNumber())
                    .technicalDirection(vo.getTechnicalDirection())
                .build();
        boolean flag = this.userInfoService.updateById(entity);
        return flag ? ResultUtils.success() : ResultUtils.error(ErrorCode.OPERATION_ERROR);
    }


    @GetMapping("get/{id}")
    @ApiOperation("根据Id查询")
    public BaseResponse get(@PathVariable(value="id") Integer userInfoId) {
        UserInfo entity = this.userInfoService.getById(userInfoId);
        return entity!=null ? ResultUtils.success(entity) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
    }


    @DeleteMapping("delete/{id}")
    @ApiOperation("删除")
    public BaseResponse delete(@PathVariable(value="id") Integer userInfoId) {
        boolean flag = this.userInfoService.removeById(userInfoId);
        return flag ? ResultUtils.success() : ResultUtils.error(ErrorCode.OPERATION_ERROR);
    }


    @PostMapping("pageList")
    @ApiOperation("列表")
    public BaseResponse pageList( @RequestBody UserInfoVO vo){
        LambdaQueryWrapper<UserInfo> queryWrapper = new LambdaQueryWrapper<>();

        if(StringUtils.isNotEmpty(vo.getUserName())) {
            queryWrapper.like(UserInfo::getUserName, vo.getUserName());
        }
        if(StringUtils.isNotEmpty(vo.getPhoneNumber())) {
            queryWrapper.eq(UserInfo::getPhoneNumber, vo.getPhoneNumber());
        }
        if(vo.getTechnicalDirection() != null){
            queryWrapper.eq(UserInfo::getTechnicalDirection, vo.getTechnicalDirection());
        }
        return ResultUtils.success(userInfoService.list(queryWrapper));
    }

}
