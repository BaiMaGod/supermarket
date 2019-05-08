package com.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.pojo.User;

public class DoTest {
	public static void main(String[] args) throws ParseException {
		User u=new User();
		u.setBirthday(new Date());
		 Date currentTime = u.getBirthday();
		   SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		   String dateString = formatter.format(currentTime);
		   System.out.println(dateString);
	}
}
