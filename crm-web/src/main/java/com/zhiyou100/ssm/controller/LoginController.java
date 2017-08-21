package com.zhiyou100.ssm.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.zhiyou100.ssm.model.User;
import com.zhiyou100.ssm.service.LoginService;

@Controller
public class LoginController {
	@Autowired
	LoginService ls;
	
    @RequestMapping("/login.action")
	public String login(String username,String password,Model md,HttpServletRequest req){
		List<User> list = ls.getUser(username,password);
		if(list.size()==0){
			md.addAttribute("resule", 1);
			return "forward:/index";
		}else{
			User user = list.get(0);
			System.out.println(user);
			req.getSession().setAttribute("user", user);
			return "/admin";
		}
	}
    @RequestMapping(value="/updateUser.action",method=RequestMethod.GET)
    public String updateUser(Integer id,Model md){
    	User u = ls.findUserById(id);
    	md.addAttribute("list", u);
    	return "/user/updateUser";
    }
    @RequestMapping(value="/updateUser.action",method=RequestMethod.POST)
    public String updateUser(User u,MultipartFile pic) throws Exception{
    	String name = UUID.randomUUID().toString().replaceAll("-", "");
    	String extension = FilenameUtils.getExtension(pic.getOriginalFilename());
    	String filename = name+"."+extension;
    	u.setuPic(filename);
    	 ls.updateUserById(u);
    	 String path = "D:\\upload";
    	 pic.transferTo(new File(path+"\\"+filename));
    	return "/admin";
    }
}
