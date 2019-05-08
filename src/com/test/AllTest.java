package com.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dao.BillMapper;
import com.dao.ProviderMapper;
import com.dao.UserMapper;
import com.pojo.Bill;
import com.pojo.Page;
import com.pojo.Provider;
import com.pojo.Role;
import com.pojo.User;
import com.service.BillService;
import com.service.ProviderService;
import com.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class AllTest {
	@Resource
	BillService bs;
	@Resource
	ProviderMapper pm;
	@Resource
	ProviderService ps;
	@Resource
	UserService us;
	@Resource
	UserMapper um;
	@Resource
	BillMapper bm;
	
	@Test
	public void test01(){
		Page page=new Page();
		page.setCurrentpage(3);
		List<User> list=us.findUserByCount(null, null, page);
		for (User u : list) {
			System.out.println(u);
		}
	}
	@Test
	public void test02(){
		List<Bill> list=bm.findAllBill();
		for (Bill b : list) {
			System.out.println(b);
		}
	}
}
