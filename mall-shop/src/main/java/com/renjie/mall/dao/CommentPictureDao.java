package com.renjie.mall.dao;

import com.renjie.mall.entity.CommentPictureEntity;

/**
 * 评价图片Dao
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-29 14:45:55
 */
public interface CommentPictureDao extends BaseDao<CommentPictureEntity> {
    /**
     * 根据commentId删除
     *
     * @param commentId
     * @return
     */
    int deleteByCommentId(Integer commentId);
}
