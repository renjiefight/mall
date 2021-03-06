package com.renjie.mall.service;

import com.renjie.mall.dao.ApiHelpTypeMapper;
import com.renjie.mall.entity.HelpTypeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Service实现类
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2018-11-07 11:04:20
 */
@Service
public class ApiHelpTypeService {
    @Autowired
    private ApiHelpTypeMapper helpTypeDao;

    public HelpTypeVo queryObject(Integer id) {
        return helpTypeDao.queryObject(id);
    }

    public List<HelpTypeVo> queryList(Map<String, Object> map) {
        return helpTypeDao.queryList(map);
    }

    public int queryTotal(Map<String, Object> map) {
        return helpTypeDao.queryTotal(map);
    }

    public int save(HelpTypeVo helpType) {
        return helpTypeDao.save(helpType);
    }

    public int update(HelpTypeVo helpType) {
        return helpTypeDao.update(helpType);
    }

    public int delete(Integer id) {
        return helpTypeDao.delete(id);
    }

    public int deleteBatch(Integer[] ids) {
        return helpTypeDao.deleteBatch(ids);
    }
}
