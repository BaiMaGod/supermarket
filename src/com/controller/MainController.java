package com.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pojo.User;
import com.service.UserService;

@Controller
public class MainController {
	@Autowired
	UserService us;
	
	private final static Logger logger= LoggerFactory.getLogger(MainController.class);
	

	/*
	 * 登录界面
	 */
	@RequestMapping("/login")
	public String login(HttpSession session) {
		logger.info("接收到一个login请求");
		
		session.removeAttribute("userOnLogin");
		return "login";
	}
	
	/**
	 * 登录界面
	 */
	@RequestMapping("/login2")
	@ResponseBody
	public String login2() {
		logger.info("接收到一个login2请求");
		
		return "登陆成功！";
	}

	/*
	 * 查询登录账号密码是否正确
	 */
	@RequestMapping(value = "/dologin", method = RequestMethod.POST)
	public String dologin(HttpSession session, @RequestParam String userCode, @RequestParam String password) {
		User u = us.login(userCode, password);
		if (u != null) {
			session.setAttribute("userOnLogin", u);
			session.removeAttribute("error");
			return "redirect:/sys/main";
		} else {
			session.setAttribute("error", "用户名或密码错误");
			session.removeAttribute("successSavePwd");
			return "redirect:/login";
		}
	}

	/*
	 * 主界面
	 */
	@RequestMapping("/sys/main")
	public String main() {
		logger.info("接收到一个sys/main请求");
		
		return "frame";
	}

	/*
	 * 退出登录
	 */
	@RequestMapping("/sys/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("userOnLogin");
		session.removeAttribute("successSavePwd");
		return "redirect:/login";
	}
	/*
	 * 401界面
	 */
//		@RequestMapping("/*")
//		public String notFound(){
//			return "401";
//		}
}
