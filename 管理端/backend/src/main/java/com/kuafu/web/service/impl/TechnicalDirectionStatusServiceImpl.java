package com.kuafu.web.service.impl;

import java.util.List;
import org.springframework.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.kuafu.web.mapper.TechnicalDirectionStatusMapper;
import com.kuafu.web.entity.TechnicalDirectionStatus;
import com.kuafu.web.service.ITechnicalDirectionStatusService;
import lombok.extern.slf4j.Slf4j;

/**
 * <p> 技术方向枚举表 服务实现类 </p>
 *
 * @author kuafuai
 * @description
 * @date 2024/09/23 11:10
 */
@Slf4j
@Service("TechnicalDirectionStatus")
public class TechnicalDirectionStatusServiceImpl extends ServiceImpl<TechnicalDirectionStatusMapper, TechnicalDirectionStatus> implements ITechnicalDirectionStatusService {


}
