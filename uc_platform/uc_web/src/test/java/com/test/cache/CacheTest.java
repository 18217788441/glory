package com.test.cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.uc.biz.UcUsersBiz;
import com.uc.mybatis.model.UcUsers;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:com.spring.config/applicationContext-all.xml" })
public class CacheTest {
	@Autowired
	private UcUsersBiz ucUsersBizImpl;

	@Test
	public void test() {
		UcUsers ucUsers=new UcUsers();
		ucUsers.setUserId(1);
		System.out.println(ucUsersBizImpl.getAll(ucUsers));
		System.out.println(ucUsersBizImpl.getAll(ucUsers));
		System.out.println(ucUsersBizImpl.getAll(ucUsers));
	}
	@Test
	public void test2() {
		System.out.println(ucUsersBizImpl.removeAll(1));
	}

	@Test
	public void test1() throws InterruptedException {
		System.out.println("第一次调用：" + ucUsersBizImpl.getTimestamp("param"));
		Thread.sleep(2000);
		System.out.println("2秒之后调用：" + ucUsersBizImpl.getTimestamp("param"));
		Thread.sleep(11000);
		System.out.println("再过11秒之后调用：" + ucUsersBizImpl.getTimestamp("param"));
	}
}
