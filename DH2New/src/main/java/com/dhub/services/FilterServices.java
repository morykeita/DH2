package com.dhub.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dhub.beans.FilterSubtypes;
import com.dhub.beans.Filters;
import com.dhub.dao.FilterSubtypesDaoImpl;
import com.dhub.dao.FiltersDaoImpl;

public class FilterServices {

	public FilterServices() {
		
	}
	
	/*
	 * START CHANGES BY SAMSEL
	 */
	
	public static Filters getFilterOBj(String filterName){
		//Get the filterID of the new Filter created 
		FiltersDaoImpl filterDao = new FiltersDaoImpl();
		
		Filters fObject = new Filters();
		Integer idFilter =0;
		List<Filters> filters = filterDao.getAllFilters();
		Map<String,List<String>> ls = new HashMap<String, List<String>>();
		for(int i=0;i<filters.size();i++){
			Filters fObj = filters.get(i);
			String fName = fObj.getFilter();
			Integer id = fObj.getFilterId();
			if(fName.equals(filterName)){
				idFilter=id;
				fObject.setFilter(fName);  fObject.setFilterId(id);
				break;
			}
		}
		return fObject;
	}
	
	public static FilterSubtypes getFilterSubTypeObj(Filters fObj, String curOption){
		FilterSubtypesDaoImpl fSubTypDAO = new FilterSubtypesDaoImpl();
		FilterSubtypes fsUpdate = new FilterSubtypes();
		fsUpdate.setFilter(fObj);
		Integer id = fObj.getFilterId();
		FilterSubtypes fOptToUpdate = new FilterSubtypes();
		
		//get list of filters available from Filter Table & Options from FilterSubType
		List<FilterSubtypes> fsubTypes =  fSubTypDAO.getAllFilterSubtypes();
		List<String> opt = new ArrayList<String>();
		for(int j=0;j<fsubTypes.size();j++){
			FilterSubtypes fOption = fsubTypes.get(j);
			if((fOption.getFilter() != null)&&(fOption.getFilter()).getFilterId()==id && (fOption.getFilterSubtype()).equals(curOption)){
				fOptToUpdate.setFilterSubtypeId(fOption.getFilterSubtypeId());
			}
		}
		
		return 	fOptToUpdate;	
	}
	
	public static boolean addFilters(Map<String,String> mFilter){
		System.out.println("------------------------------------------------");
		System.out.println("REQUEST: Add Filter");
		System.out.println("------------------------------------------------");
		//loop a Map
		for (Map.Entry<String,  String> entry : mFilter.entrySet()) {
			System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
			
			//Add the Key to Filters Table. return -> ID
			String filterName = entry.getKey();
			String filterOptions= entry.getValue();
			System.out.println(filterOptions.split(",").length);

			Filters filterObj=new Filters(filterName);
			FiltersDaoImpl filterDao = new FiltersDaoImpl();
			filterDao.createFilter(filterObj);
			
			//Get the filterID of the new Filter created 
			Filters fObject = new Filters();;
			Integer idFilter =0;
			List<Filters> filters = filterDao.getAllFilters();
			Map<String,List<String>> ls = new HashMap<String, List<String>>();
			for(int i=0;i<filters.size();i++){
				Filters fObj = filters.get(i);
				String fName = fObj.getFilter();
				Integer id = fObj.getFilterId();
				if(fName.equals(filterName)){
					idFilter=id;
					fObject.setFilter(fName);  fObject.setFilterId(id);
					break;
				}
			}
				
			String[] fOpt= filterOptions.split(",");
			for(int j=0;j<fOpt.length;j++){
				FilterSubtypes fs = new FilterSubtypes();
				fs.setFilter(fObject);
				fs.setFilterSubtype(fOpt[j]);
				new FilterSubtypesDaoImpl().createFilterSubtype(fs);
			}
			
			//for loop(each option -> add it to FilterSubtype table having Filter ID 
		}
		return true;
	}
	
	public static boolean uFilters(String command, String toOption, String fromOption,String filterName){
		System.out.println("------------------------------------------------");
		System.out.println("REQUEST: Update Filter");
		System.out.println("------------------------------------------------");
		System.out.println("Filter\t\tCommand\t\tTo\t\tFrom");
		System.out.println(filterName+"\t"+command+"\t"+toOption+"\t"+fromOption);
		Filters fObj = getFilterOBj(filterName);
		FilterSubtypesDaoImpl fSubTypDAO = new FilterSubtypesDaoImpl();
		switch(command){
			case "add": 
						FilterSubtypes fsAdd = new FilterSubtypes();
						fsAdd.setFilter(fObj);
						fsAdd.setFilterSubtype(toOption);
						fSubTypDAO.createFilterSubtype(fsAdd);
						break;
			case "update": 
						FilterSubtypes fsUpdate = new FilterSubtypes();
						fsUpdate.setFilter(fObj);
						Integer id = fObj.getFilterId();
						FilterSubtypes fOptToUpdate = new FilterSubtypes();
						
						//get list of filters available from Filter Table & Options from FilterSubType
						List<FilterSubtypes> fsubTypes =  fSubTypDAO.getAllFilterSubtypes();
						List<String> opt = new ArrayList<String>();
						for(int j=0;j<fsubTypes.size();j++){
							FilterSubtypes fOption = fsubTypes.get(j);
							if((fOption.getFilter()).getFilterId()==id && fOption.getFilterSubtype().equals(fromOption)){
								fOptToUpdate.setFilterSubtypeId(fOption.getFilterSubtypeId());
							}
						}
						
						fOptToUpdate.setFilter(fObj);
						fOptToUpdate.setFilterSubtype(toOption);
						fSubTypDAO.updateFilterSubtype(fOptToUpdate); 
				
						break;
			case "Delete": 
						FilterSubtypes fToUpdate = getFilterSubTypeObj(fObj,toOption);	
						fSubTypDAO.deleteFilterSubtype(fToUpdate);
						break;
		}
		return true;
	}
	
	public static boolean delFilter(String filterName){
		System.out.println("------------------------------------------------");
		System.out.println("REQUEST: Delete Filter");
		System.out.println("------------------------------------------------");
		System.out.println("Filter : "+filterName);
		
		//Filters filterObj=new Filters(filterName);
		//new FiltersDaoImpl().deleteFilter(filterObj);
		
		Filters fObj = getFilterOBj(filterName);
		new FiltersDaoImpl().deleteFilter(fObj);
		
		return true;
	}
	
	public static Map getFilters(){
		System.out.println("------------------------------------------------");
		System.out.println("REQUEST: Get All Filter");
		System.out.println("------------------------------------------------");
		
		//get list of filters available from Filter Table & Options from FilterSubType
		List<FilterSubtypes> fsubTypes =  new FilterSubtypesDaoImpl().getAllFilterSubtypes();
		List<Filters> filters = new FiltersDaoImpl().getAllFilters();
		
		Map<String,List<String>> ls = new HashMap<String, List<String>>();
		for(int i=0;i<filters.size();i++){
			Filters fObj = filters.get(i);
			String fName = fObj.getFilter();
			Integer id = fObj.getFilterId();
			System.out.println("FType : "+fName);
			
			List<String> opt = new ArrayList<String>();
			for(int j=0;j<fsubTypes.size();j++){
				FilterSubtypes fOption = fsubTypes.get(j);
				if((fOption.getFilter())!=null && ((fOption.getFilter()).getFilterId())==id){
					String option = fOption.getFilterSubtype();
					opt.add(option);
				}
			}
			Collections.sort(opt);
			ls.put(fName, (opt));
			
		}
		return ls;
	}
	
	/*
	 * END OF CHANGES BY SAMSEL
	 */
}

