package com.dhub.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.dhub.beans.FilterSubtypes;
import com.dhub.beans.Filters;
import com.dhub.beans.Users;
import com.dhub.dao.UsersDaoImpl;

@Component
public class UserServices
{

	UsersDaoImpl usersDaoImpl = new UsersDaoImpl();

	public boolean auth(String username, String password)
	{

		Users users = usersDaoImpl.getCredentials(username);
		if (users != null)
		{

			if (users.getPassword().equals(password))
			{
				return true;
			} else
			{
				return false;
			}
		}
		return false;

	}
	
	public Users getUserByUsername(String username)
	{
		return usersDaoImpl.getCredentials(username);
	}
	
	/*
	 * CHANGES BY SAMSEL START 
	 */
	
	public static Map/*List<Users>*/ search(Map<String,String> mFilters){
		List<Users> fUsers = new ArrayList<Users>();
		
		//get users for the filters in mFilters(key,value) == (filtertype , option) 
		System.out.println("------------------------------------------------");
		System.out.println("REQUEST: Search Users with given skills");
		System.out.println("------------------------------------------------");
		//System.out.println(mFilters);
		List<FilterSubtypes> fOption = new ArrayList<FilterSubtypes>();
		for (String key : mFilters.keySet()) {
			   System.out.println("key: [" + key + "] value: [" + mFilters.get(key)+"]");
			   
			   Filters fObj = FilterServices.getFilterOBj(key);
			   FilterSubtypes fOpt = FilterServices.getFilterSubTypeObj(fObj, mFilters.get(key));
			   fOption.add(fOpt);
		}
		
		System.out.println("Filter Options user selected : "+fOption.size());
		
		UsersDaoImpl userDao = new UsersDaoImpl();
		List<Users> uAll = userDao.getAllUsers(); 
		
		for(int i=0;i<uAll.size();i++){	
			List<FilterSubtypes> uSkills = uAll.get(i).getFilterSubtype();
			//System.out.println("User id : ["+uAll.get(i).getUserId()+"] ");
			//System.out.println("Skills : ");
			int iCntSkills = 0;
			for(int x=0;x<fOption.size();x++){
				Integer id1=fOption.get(x).getFilterSubtypeId();
				for(int j=0;j<uSkills.size();j++){
					//System.out.print(uSkills.get(j)+"  ");
					//FilterSubtypes uSkill = uSkills.get(j);
					Integer id2 = uSkills.get(j).getFilterSubtypeId();
					if(id2==id1){
						iCntSkills++;
						break;
					}
				}
			}
			
			//if user satisfies all the skill's requested then add to resultSet (return to View)
			if((fOption.size())==iCntSkills){
				fUsers.add(uAll.get(i));
			}
			
		}
		
		System.out.println("================================================");
		System.out.println("Users IDs : Count ["+fUsers.size()+"]");
		System.out.println("User id :");
		
		Map<String,List<String>> ls = new HashMap<String, List<String>>();
		for(int i=0;i<fUsers.size();i++){
			List<String> opt = new ArrayList<String>();
			
			Integer userId = fUsers.get(i).getUserId();
			String sUserId = userId.toString();
			
			String username= fUsers.get(i).getFirstName()+" "+fUsers.get(i).getLastName();
			String emailID= fUsers.get(i).getEmail();
			String phone = fUsers.get(i).getPhone();
			
			opt.add(username);
			opt.add(emailID);
			opt.add(phone);
			ls.put(sUserId, opt);	
			
			System.out.print(sUserId+ " ");
		}
		System.out.println();
		System.out.println("================================================");
		
		/*Map<String,List<String>> ls = new HashMap<String, List<String>>();
		List<String> opt = new ArrayList<String>();
		opt.add("Sara Fhinn");
		opt.add("saraFhinn30@yahoo.com");
		opt.add("+15813023434");
		ls.put("1601", opt);	
		
		List<String> opt1 = new ArrayList<String>();
		opt1.add("John Tailedes");
		opt1.add("TailedesJ@yahoo.com");
		opt1.add("+1588023434");
		ls.put("1602", opt1);
		
		List<String> opt2 = new ArrayList<String>();
		opt2.add("Finner Paul");
		opt2.add("Paul23@yahoo.com");
		opt2.add("+1581300434");
		ls.put("1603", opt2);
		*/
		
		return ls;
	}
	
	public static void delUsers(String userIds){
		System.out.println("------------------------------");
		System.out.println("REQUEST : Delete User Profile : ");
		System.out.println("------------------------------");
		String userId[]=userIds.split(";");
		for(String uId: userId){
			System.out.println(uId);
		}
	}
	
	public static void addUser(String fname, String lname, String desig, String gender,
			   String Project, String uDOB,
			   String uDOJ, String uAddress,
			   String uPhone){
		
		System.out.println("------------------------------");
		System.out.println("REQUEST : Add User Profile : ");
		System.out.println("------------------------------");
		System.out.println("Fist Name : "+fname);
		System.out.println("Last Name : "+lname);
		System.out.println("Designation : "+desig);
		System.out.println("Gender : "+gender);
		System.out.println("Project : "+Project);
		System.out.println("Date of Birth : "+uDOB);
		System.out.println("Date of Joining : "+uDOJ);
		System.out.println("Address : "+uAddress);
		System.out.println("Phone Number : "+uPhone);
		
		UsersDaoImpl userDao = new UsersDaoImpl();
		if(fname!=null){
			String uName = fname.charAt(0) + lname;
			String password = "password";
			
			
		}
		
		List<Users> uAll = userDao.getAllUsers(); 
	}
	
	public static void updateUser(String fname, String lname, String uname, String pwd,String email, String phone){
		System.out.println("---------------------------------------------");
		System.out.println("REQUEST: Updating User");
		System.out.println("---------------------------------------------");
		
		UsersDaoImpl userDao = new UsersDaoImpl();
		List<Users> uAll = userDao.getAllUsers(); 
		
		Users uToUpdate = new Users();
		for(int i=0;i<uAll.size();i++){	
			if((uAll.get(i).getUserName()).equals(uname)){
				uToUpdate=uAll.get(i);
				break;
			}
		}
		
		uToUpdate.setEmail(email);
		uToUpdate.setFirstName(fname);
		uToUpdate.setLastName(lname);
		uToUpdate.setUserName(uname);
		uToUpdate.setPassword(pwd);
		uToUpdate.setPhone(phone);
		
		userDao.updateUser(uToUpdate);
	}
	
	/*
	 * END OF CHANGES BY SAMSEL
	 */
}
