package com.nt.el;

import java.util.Calendar;

public class WishMessageGenerator {
	
	public static String generateWishMsg(String user){
		String msg=null;
		Calendar calendar=null;
		int hour=0;
		//get System Date
		calendar=Calendar.getInstance();
		//get current hour
		hour=calendar.get(Calendar.HOUR_OF_DAY);
		//generate Wish Message
		if(hour<=12)
			return "GM::"+user;
		else if(hour<=16)
			return "GA::"+user;
		else if(hour<=20)
			return "GE::"+user;
		else
			return "GN::"+user;
	}//method
}//class
