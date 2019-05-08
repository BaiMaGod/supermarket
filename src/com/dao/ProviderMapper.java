package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.pojo.Provider;

@MapperScan
public interface ProviderMapper {
	List<Provider> findAllProvider();//获取全部供应商，未使�?
	Provider findProvider(int id);//根据id查询供应�?
	int proModify(Provider pro);//修改供应商信�?
	int	proDelete(int id);//删除单个供应�?
	int findBill(int id);//查询供应商的订单
	int proAdd(Provider pro);//添加供应�?
	//查询供应商列�?
	List<Provider> findByProCodeOrProName(@Param("proCode")String proCode,@Param("proName")String proName);
}
