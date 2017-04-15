package com.dhub.services;

public class MeetingsServices {

	public MeetingsServices() {
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * START OF CHANGES DONE BY SAMSEL
	 */
	public static void setupMeeting(String emailIds, 
			String body, 
			String userID, 
			String eSubject, 
			String date,
			String fTime, 
			String tTime)
	{
	System.out.println("------------------------------------------------");
	System.out.println("REQUEST: Set-up a Meeting");
	System.out.println("------------------------------------------------");
	System.out.println("Meeting details recieved");	
	System.out.println("To Eamil_IDs 	: "+emailIds);
	System.out.println("Body 			: "+body);
	System.out.println("From User ID 	: "+userID);
	System.out.println("Subject 		: "+eSubject);
	System.out.println("Date 			: "+date);
	System.out.println("From Time 		: "+fTime);
	System.out.println("To Time 		: "+tTime);
	
	}
	
	/*
	 * END OF CHANGES DONE BY SAMSEL
	 */

}
