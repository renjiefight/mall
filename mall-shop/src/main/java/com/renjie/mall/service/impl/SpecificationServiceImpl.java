package com.renjie.mall.service.impl;

import com.renjie.mall.dao.SpecificationDao;
import com.renjie.mall.entity.SpecificationEntity;
import com.renjie.mall.service.SpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("specificationService")
public class SpecificationServiceImpl implements SpecificationService {
	@Autowired
	private SpecificationDao specificationDao;
	
	@Override
	public SpecificationEntity queryObject(Integer id){
		return specificationDao.queryObject(id);
	}
	
	@Override
	public List<SpecificationEntity> queryList(Map<String, Object> map){
		return specificationDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return specificationDao.queryTotal(map);
	}
	
	@Override
	public void save(SpecificationEntity specification){
		specificationDao.save(specification);
	}
	
	@Override
	public void update(SpecificationEntity specification){
		specificationDao.update(specification);
	}
	
	@Override
	public void delete(Integer id){
		specificationDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		specificationDao.deleteBatch(ids);
	}
	
}
