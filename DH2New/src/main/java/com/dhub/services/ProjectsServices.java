package com.dhub.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.dhub.beans.Projects;
import com.dhub.dao.ProjectsDaoImpl;

public class ProjectsServices {

	public ProjectsServices() {
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * START CHANGES BY SAMSEL
	 */
	public static  ArrayList<String> getAllProjects(){
		System.out.println("------------------------------------------------");
		System.out.println("REQUEST: Get All Projects");
		System.out.println("------------------------------------------------");
		ArrayList<String> aPrj = new ArrayList<String>();
		//aPrj.add("Microsoft-x");
		
		ProjectsDaoImpl pDao = new ProjectsDaoImpl();
		List<Projects> pProj = pDao.getAllProjects();
		for(int i=0;i<pProj.size();i++){
			aPrj.add(pProj.get(i).getName());
		}
		
		Collections.sort(aPrj);
		
		aPrj.add("None");
		
		return aPrj;
	}
	
	/*
	 * END OF CHANGES BY SAMSEL
	 */

}
