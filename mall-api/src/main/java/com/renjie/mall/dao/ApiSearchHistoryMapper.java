package com.renjie.mall.dao;

////import com.platform.entity.SearchHistoryVo;

import com.renjie.mall.entity.SearchHistoryVo;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @gitee https://gitee.com/fuyang_lipengjun/platform
 * @date 2017-08-11 09:16:46
 */
public interface ApiSearchHistoryMapper extends BaseDao<SearchHistoryVo> {
    int deleteByUserId(@Param("user_id") Long userId);
}
