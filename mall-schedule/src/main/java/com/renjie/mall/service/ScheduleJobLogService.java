package com.renjie.mall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.renjie.mall.entity.ScheduleJobLogEntity;
import com.renjie.mall.utils.PageUtilsPlus;

import java.util.Map;

/**
 * 定时任务日志
 *
 * @author 李鹏军
 */
public interface ScheduleJobLogService extends IService<ScheduleJobLogEntity> {

    /**
     * 获取分页数据
     *
     * @param params 查询参数
     * @return Page
     */
    PageUtilsPlus queryPage(Map<String, Object> params);
}
