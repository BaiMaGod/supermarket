package com.service;

import java.util.List;

import com.pojo.Bill;

public interface BillService {
	List<Bill> findAddBill();
	Bill findBillById(int id);
	boolean billAdd(Bill b);
	boolean billModify(Bill b);
	String billDel(int id);
	List<Bill> findByNameIdAndIsPayment(String productName,Integer providerId,Integer isPayment);
}
