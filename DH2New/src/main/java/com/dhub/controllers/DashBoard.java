package com.dhub.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dhub.services.FilterServices;
import com.dhub.services.MailServices;
import com.dhub.services.MeetingsServices;
import com.dhub.services.ProjectsServices;
import com.dhub.services.UserServices;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping(value="/home")
public class DashBoard {

	//@ModelAttribute("someInfo")
	public void msg(){;
		System.out.println("Home Page");
	}
	
	@RequestMapping(value = "/AddFilter", method = RequestMethod.POST, consumes="application/json")
	@ResponseBody
	public String addFilter(@RequestBody String[] newFilter) {
		
		HashMap filterM = new HashMap();
		JSONArray jsonArray = new JSONArray(newFilter);
		System.out.println()	;
		for(int i = 0 ; i < jsonArray.length() ; i++){
			JSONObject json =new JSONObject(jsonArray.getString(i));
		    Iterator<String> keys = json.keys();			
		   
		    while (keys.hasNext()) {
		        String key = keys.next();
		        //System.out.println("Key :" + key + "  Value :" + json.get(key));
		        filterM.put(key,json.get(key));
		    } 
		    System.out.println(filterM);
		    
		    FilterServices.addFilters(filterM);
		}
		return("OK");
	}
	
	@RequestMapping(value = "/UpdateFilter", method = RequestMethod.POST)
	@ResponseBody
	public String updateFilter(String command, String toOption, String fromOption, String filterName){
		//System.out.println(command+" "+toOption+" "+fromOption);
		FilterServices.uFilters(command,toOption, fromOption,filterName);
		return "OK";
	}
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public String getFiltersToSave(){
		//ModelAndView mq=new ModelAndView();
		//mq.addObject("name", "samsel");
		Map listOfFilters = FilterServices.getFilters();
		
		ObjectMapper mapper = new ObjectMapper();
        String json = "";
        try {
            json = mapper.writeValueAsString(listOfFilters);
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		return json;
	}
	
	@RequestMapping(value="/mail" ,method=RequestMethod.GET)
	@ResponseBody
	public String sendM(String emailIds, String body, String userID, String eSubject){
		MailServices.sendMail(emailIds, body, userID, eSubject);
		return "OK";
	}
	
	@RequestMapping(value="/updateUser" ,method=RequestMethod.GET)
	@ResponseBody
	public String updateUser(String fname, String lname, String uname, String pwd,String email, String phone){
		UserServices.updateUser(fname, lname, uname, pwd,email,phone);
		return "OK";
	}
	
	
	
	@RequestMapping(value="/DeleteFilter" ,method=RequestMethod.GET)
	@ResponseBody
	public String deleteFilter(String filterName){
		FilterServices.delFilter(filterName);
		return "OK";
	}
	
	@RequestMapping(value="/meet" ,method=RequestMethod.GET)
	@ResponseBody
	public String sendMeet(String emailIds, String body, String userID, String eSubject, String date,
			String fTime, String tTime){
		MeetingsServices.setupMeeting(emailIds, body, userID, eSubject,date,fTime,tTime);
		return "OK";
	}
	
	@RequestMapping(value="/AddProfile" ,method=RequestMethod.GET)
	@ResponseBody
	public String addUsers(String fname, String lname, String desig, String gender,
						   String Project, String uDOB,
						   String uDOJ, String uAddress,
						   String uPhone){
		UserServices.addUser(fname,lname,desig,gender,Project,uDOB,uDOJ,uAddress,uPhone);
		return "OK";
	}
	
	@RequestMapping(value="/DeleteProfiles" ,method=RequestMethod.GET)
	@ResponseBody
	public String deleteProfiles(String userIds){
		UserServices.delUsers(userIds);
		return "OK";
	}
	
	@RequestMapping(value="/GetAllProjects" ,method=RequestMethod.GET)
	@ResponseBody
	public ArrayList<String> GetAllProjects(){
		ArrayList<String> aPrj = ProjectsServices.getAllProjects();
		return aPrj;
	}
	
	@RequestMapping(value = "/SearchUsers", method = RequestMethod.POST, consumes="application/json")
	@ResponseBody
	public String Search(@RequestBody String[] dataFilters) {
		Map mFilters = new HashMap(); 
		JSONArray jsonArray = new JSONArray(dataFilters);
		System.out.println()	;
		for(int i = 0 ; i < jsonArray.length() ; i++){
			JSONObject json =new JSONObject(jsonArray.getString(i));
		    Iterator<String> keys = json.keys();			
		   
		    while (keys.hasNext()) {
		        String key = keys.next();
		        //System.out.println("Key :" + key + "  Value :" + json.get(key));
		        mFilters.put(key,json.get(key));
		    }
		}
		
		Map ls =UserServices.search(mFilters);
		ObjectMapper mapper = new ObjectMapper();
        String json = "";
        try {
            json = mapper.writeValueAsString(ls);
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		return json;
	}
}
