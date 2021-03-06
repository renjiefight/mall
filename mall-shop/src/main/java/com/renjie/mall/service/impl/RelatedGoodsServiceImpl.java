package com.renjie.mall.service.impl;

import com.renjie.mall.dao.RelatedGoodsDao;
import com.renjie.mall.entity.RelatedGoodsEntity;
import com.renjie.mall.service.RelatedGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("relatedGoodsService")
public class RelatedGoodsServiceImpl implements RelatedGoodsService {
	@Autowired
	private RelatedGoodsDao relatedGoodsDao;
	
	@Override
	public RelatedGoodsEntity queryObject(Integer id){
		return relatedGoodsDao.queryObject(id);
	}
	
	@Override
	public List<RelatedGoodsEntity> queryList(Map<String, Object> map){
		return relatedGoodsDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return relatedGoodsDao.queryTotal(map);
	}
	
	@Override
	public void save(RelatedGoodsEntity relatedGoods){
		relatedGoodsDao.save(relatedGoods);
	}
	
	@Override
	public void update(RelatedGoodsEntity relatedGoods){
		relatedGoodsDao.update(relatedGoods);
	}
	
	@Override
	public void delete(Integer id){
		relatedGoodsDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		relatedGoodsDao.deleteBatch(ids);
	}
	
}
