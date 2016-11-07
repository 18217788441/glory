package com.uc.biz;

import java.util.List;

import com.uc.mybatis.model.UcUsers;

public interface UcUsersBiz {

	String getTimestamp(String param);

	List<UcUsers> removeAll(int id);

	List<UcUsers> getAll(UcUsers ucUsers);
}
