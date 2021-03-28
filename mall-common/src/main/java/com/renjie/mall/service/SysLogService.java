package com.renjie.mall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.renjie.mall.entity.SysLogEntity;
import com.renjie.mall.utils.PageUtilsPlus;

import java.util.Map;

/**
 * 系统日志
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-03-08 10:40:56
 */
public interface SysLogService extends IService<SysLogEntity> {
    /**
     * 分页
     *
     * @param params
     * @return
     */
    PageUtilsPlus queryPage(Map<String, Object> params);
}
