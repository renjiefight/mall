package com.renjie.mall.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.renjie.mall.dao.SysLogDao;
import com.renjie.mall.entity.SysLogEntity;
import com.renjie.mall.service.SysLogService;
import com.renjie.mall.utils.PageUtilsPlus;
import com.renjie.mall.utils.QueryPlus;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author 李鹏军
 */
@Service("sysLogService")
public class SysLogServiceImpl extends ServiceImpl<SysLogDao, SysLogEntity> implements SysLogService {

    @Override
    public PageUtilsPlus queryPage(Map<String, Object> params) {
        //排序
        params.put("sidx", "create_date");
        params.put("asc", false);
        Page<SysLogEntity> page = new QueryPlus<SysLogEntity>(params).getPage();
        return new PageUtilsPlus(page.setRecords(baseMapper.selectSysLogPage(page, params)));
    }
}
