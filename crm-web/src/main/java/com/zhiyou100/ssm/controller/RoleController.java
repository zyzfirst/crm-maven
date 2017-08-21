package com.zhiyou100.ssm.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.zhiyou100.ssm.model.Role;
import com.zhiyou100.ssm.model.RoleVO;
import com.zhiyou100.ssm.service.RoleService;
import com.zhiyou100.ssm.util.Page;

@Controller
@RequestMapping("/role")
public class RoleController {

	@Autowired
	RoleService rs;
	@RequestMapping("/role.action")
	public String roleList( RoleVO rv,Model md,Page p){
		if(rv.getKey() == null|| rv.getField() == null){
			rv.setKey("");
			rv.setField("r_name");
		}
		int total = rs.findRoleCountByString(rv);
		rv.setTotal(total);
		int curuntpage = p.getPage();
		if(p.getPage()==0){
			curuntpage=1;
		}
		rv.setCuruntpage(curuntpage);
		Page<Role> page = rs.findRoleByString(rv);
		md.addAttribute("key", rv.getKey());
		md.addAttribute("field", rv.getField());
		md.addAttribute("page", page);
		return "role/role";
	}
	/*@RequestMapping(value="/role.action",method=RequestMethod.GET)
	public String roleList(Page p,Model md,RoleVO rv){
		int page = p.getPage();
		int size = p.getSize();
		int startpage =(page-1)*size;
		//RoleVO rv = new RoleVO();
		rv.setCuruntpage(page);
		rv.setSize(size);
		rv.setStartpage(startpage);
		
		int total = rs.findAllRoleCountByString(rv);
		rv.setTotal(total);
		
		Page<Role> page2 = rs.findAllRoleByString(rv);
		md.addAttribute("page", page2);
		return "role/role";
	}*/
	
	@RequestMapping("/multieditRole.action")
	public ModelAndView role05(RoleVO rv){
		System.out.println(rv.getList());
		//rs.updateRoleById(rv.getList());
		rs.multieditRole(rv.getList());
		ModelAndView mv = new ModelAndView();
		return mv;
		}
	@RequestMapping("/deleteRole.action")
	public String deleteRole(Integer id){
		rs.deleteRole(id);
		return "redirect:/role/role.action";
		
	}
	@RequestMapping(value="/addRole.action",method=RequestMethod.GET)
	public String addRole(){
		return "role/addRole";
	}
	@RequestMapping(value="/addRole.action",method=RequestMethod.POST)
	public String addRole(Role r){
		rs.addRole(r);
		return "redirect:/role/role.action";
	}
	
	@RequestMapping(value="/updateRole.action",method=RequestMethod.GET )
	public String updateRole(Integer id,Model mo){
		Role role = rs.findRoleById(id);
		mo.addAttribute("list", role);
		return "/role/updateRole";
	}
	@RequestMapping(value="/updateRole.action",method=RequestMethod.POST )
	public String updateRole(RoleVO rv,MultipartFile pic) throws Exception{
		 
		String str = UUID.randomUUID().toString().replaceAll("-", "");
		String extension = FilenameUtils.getExtension(pic.getOriginalFilename());
		String filedName = str+"."+extension;
		rv.getR().setrPic(filedName);
		rs.updateRole(rv.getR());
		
		String path = "D:\\upload";
		pic.transferTo(new File(path+"\\"+filedName));
		
		
		return "redirect:/role/role.action";
	}
	
	
	
	@RequestMapping("/role/role.action")
	public ModelAndView role02(@RequestParam("id") Integer theId){
		System.out.println(theId);
		ModelAndView mv = new ModelAndView();
		
		
		return mv;
	}
	/*@RequestMapping()
	public ModelAndView role01(MultipartFile pic ){
		String name = FilenameUtils.getExtension(pic.getOriginalFilename());
		String str = UUID.randomUUID().toString().replaceAll("-", "");
		String filename = name+"."+str;
		
		String path = "D:\\upload";
		pic.transferTo(path+"\\"+filename);
		
		System.out.println(theId);
		ModelAndView mv = new ModelAndView();
		
		
		return mv;
	}*/
	/*@RequestMapping("/role/jumpRole.action")
	public ModelAndView role01(){
		List<Role> list = rs.findRole() ;
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);
		mv.setViewName("/role/role");
		return mv;
	}*/
	/*@RequestMapping("/role/addRole.action")
	public ModelAndView role03(@RequestParam() Integer theId ){
		System.out.println(r);
		ModelAndView mv = new ModelAndView();
		rs.addRole(r);
		return mv;
	}*/
	/*@RequestMapping("/findRole.action")
	public ModelAndView role01(@RequestParam("id") Integer theId){
		Role r = rs.findRoleById(theId) ;
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", r);
		mv.setViewName("/role/updateRole");
		return mv;
		}*/
	/*@RequestMapping("/role/editRole.action")
	public ModelAndView role02(HttpRequestHandler req,HttpRequestHandler res,HttpSession session,Model mo,ModelMap mm){
		
		ModelAndView mv = new ModelAndView();
		
		return mv;
		}*/
	/*@RequestMapping("/editRole.action")
	public ModelAndView role02(RoleVO rv){
		rs.updateRoleById(rv.getR()) ;
		ModelAndView mv = new ModelAndView();
		return mv;
		}*/
	/*@RequestMapping("/jumpRole.action")
	public ModelAndView jumpRole(){
	    List<Role> list = rs.findRoleByName("师");
	    System.out.println(list);
	    ModelAndView mv = new ModelAndView();
		mv.setViewName("role/addRole");
		return mv;
	}*/
}
