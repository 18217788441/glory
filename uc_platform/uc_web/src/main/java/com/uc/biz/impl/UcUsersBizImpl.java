package com.uc.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.uc.biz.UcUsersBiz;
import com.uc.mybatis.mapper.UcUsersMapper;
import com.uc.mybatis.model.UcUsers;

@Service(value="ucUsersBizImpl")
public class UcUsersBizImpl implements UcUsersBiz{
	
	@Autowired
	private UcUsersMapper ucusersMapper;
	
	@Override
	@Cacheable(value="cacheTest",key="#ucUsers.userId")
	public List<UcUsers> getAll(UcUsers ucUsers) {
		List<UcUsers> list=ucusersMapper.select(ucUsers);
		return list;
	}
	@Override
	@CacheEvict(value="cacheTest",key="#id")
	public List<UcUsers> removeAll(int id) {
		return null;
	}
	@Override
	@Cacheable(value="cacheTest",key="#param")
	public String getTimestamp(String param) {
        Long timestamp = System.currentTimeMillis();
        return timestamp.toString();
    }
}
