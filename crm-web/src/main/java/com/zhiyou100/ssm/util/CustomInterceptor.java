package com.zhiyou100.ssm.util;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.zhiyou100.ssm.controller.LoginController;
import com.zhiyou100.ssm.model.User;

public class CustomInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object controller) throws Exception {
		boolean relese =true;
		LoginController ls = new LoginController();
		User user = (User)req.getSession().getAttribute("user");
		if(user==null){
			if(req.getServletPath().equals("/login.action")){
				relese =true;
			}else{
				res.sendRedirect(req.getContextPath()+"/index.jsp");
				relese = false;
				}
		}else{
			relese =true;
		}
		
		return relese;
	}

	}
