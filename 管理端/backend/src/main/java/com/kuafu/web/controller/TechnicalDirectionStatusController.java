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
import com.kuafu.web.entity.TechnicalDirectionStatus;
import com.kuafu.web.service.ITechnicalDirectionStatusService;
import com.kuafu.web.vo.TechnicalDirectionStatusPageVO;
import com.kuafu.web.vo.TechnicalDirectionStatusVO;


/**
 * <p> 技术方向枚举表 接口 </p>
 *
 * @author kuafuai
 * @description
 * @date 2024/09/23 11:10
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/technicalDirectionStatus")
@Api(tags = {"技术方向枚举表"})
public class TechnicalDirectionStatusController  {

    private final ITechnicalDirectionStatusService technicalDirectionStatusService;

    @PostMapping("page")
    @ApiOperation("分页")
    public BaseResponse page( @RequestBody TechnicalDirectionStatusPageVO pageVO){
        IPage<TechnicalDirectionStatus> page = new Page<>(pageVO.getCurrent(), pageVO.getPageSize());
        LambdaQueryWrapper<TechnicalDirectionStatus> queryWrapper = new LambdaQueryWrapper<>();

            if(StringUtils.isNotEmpty(pageVO.getTechnicalStatusDescription())) {
            queryWrapper.eq(TechnicalDirectionStatus::getTechnicalStatusDescription, pageVO.getTechnicalStatusDescription());
        }
        return ResultUtils.success(technicalDirectionStatusService.page(page, queryWrapper));
    }

    @PostMapping("list")
    @ApiOperation("列表")
    public BaseResponse list( @RequestBody TechnicalDirectionStatusVO vo){
        LambdaQueryWrapper<TechnicalDirectionStatus> queryWrapper = new LambdaQueryWrapper<>();

            if(StringUtils.isNotEmpty(vo.getTechnicalStatusDescription())) {
            queryWrapper.eq(TechnicalDirectionStatus::getTechnicalStatusDescription, vo.getTechnicalStatusDescription());
        }
        return ResultUtils.success(technicalDirectionStatusService.list(queryWrapper));
    }


            @PostMapping("get_select_list")
            @ApiOperation("获取所有的下拉列表")
            public BaseResponse get_select_list( ){
                LambdaQueryWrapper<TechnicalDirectionStatus> queryWrapper = new LambdaQueryWrapper<>();
                queryWrapper.select(TechnicalDirectionStatus::getTechnicalStatusId);

        List<TechnicalDirectionStatus> list =technicalDirectionStatusService.list(queryWrapper);
        final List<SelectVO> selectVOS = list.stream().map(l -> new SelectVO(l.getTechnicalStatusId(), l.getTechnicalStatusId().toString())).collect(Collectors.toList());
        return ResultUtils.success(selectVOS);

                }

    @PostMapping("add")
    @ApiOperation("新增")
    public BaseResponse add( @RequestBody TechnicalDirectionStatusVO vo) {
        TechnicalDirectionStatus entity =  TechnicalDirectionStatus.builder()
                    .technicalStatusDescription(vo.getTechnicalStatusDescription())
                .build();
        boolean flag =this.technicalDirectionStatusService.save(entity);
        return flag ? ResultUtils.success() : ResultUtils.error(ErrorCode.OPERATION_ERROR);
    }

    @PutMapping("update")
    @ApiOperation("更新")
    public BaseResponse update( @RequestBody TechnicalDirectionStatusVO vo) {
        TechnicalDirectionStatus entity =  TechnicalDirectionStatus.builder()
                    .technicalStatusId(vo.getTechnicalStatusId())
                    .technicalStatusDescription(vo.getTechnicalStatusDescription())
                .build();
        boolean flag = this.technicalDirectionStatusService.updateById(entity);
        return flag ? ResultUtils.success() : ResultUtils.error(ErrorCode.OPERATION_ERROR);
    }


    @GetMapping("get/{id}")
    @ApiOperation("根据Id查询")
    public BaseResponse get(@PathVariable(value="id") Integer technicalStatusId) {
        TechnicalDirectionStatus entity = this.technicalDirectionStatusService.getById(technicalStatusId);
        return entity!=null ? ResultUtils.success(entity) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
    }


    @DeleteMapping("delete/{id}")
    @ApiOperation("删除")
    public BaseResponse delete(@PathVariable(value="id") Integer technicalStatusId) {
        boolean flag = this.technicalDirectionStatusService.removeById(technicalStatusId);
        return flag ? ResultUtils.success() : ResultUtils.error(ErrorCode.OPERATION_ERROR);
    }

}
