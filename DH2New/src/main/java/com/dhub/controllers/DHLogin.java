package com.dhub.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dhub.beans.Users;
import com.dhub.services.UserServices;

@Controller
@RequestMapping(value="/DHApp")
public class DHLogin
{

	
	/* @Autowired 
	 Users emptyUser;*/
	 
	 UserServices userService = new UserServices();
	 

	@RequestMapping(method = RequestMethod.GET)
	public String doLogin(ModelMap model)
	{
		
		return "testLogin";
	}

	@RequestMapping(value = "/DHLogin", method = RequestMethod.POST)
	public String doLogin(@RequestParam("userName") String name, @RequestParam("password") String pass, HttpServletRequest request)
	{
		//String username = request.getParameter("uname");
		//String password = request.getParameter("password");
		
		if (userService.auth(name, pass))
		{
			request.getSession().setAttribute("currentUser", userService.getUserByUsername(name));
			System.out.println(userService.getUserByUsername(name));
			return "redirect:/DHDashboard.jsp";
		}
		else
		{
			return "redirect:/testLogin.jsp";
		}
	}
	
	
	@RequestMapping(value = "/DHLogin", method = RequestMethod.GET)
	public String redoLogin(@RequestParam("userName") String name, @RequestParam("password") String pass, HttpServletRequest request)
	{

		//String username = request.getParameter("uname");
		//String password = request.getParameter("password");
		
		if (userService.auth(name, pass))
		{
			request.getSession().setAttribute("currentUser", userService.getUserByUsername(name));
			System.out.println(userService.getUserByUsername(name));
			return "DHDashboard";
		}
		else
		{
			return "testLogin";
		}
		

	}
}
