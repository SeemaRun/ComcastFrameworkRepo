package com.comcast.crm.genericwebdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
  //create method for randomnumber
	public int getRandomNumber() {
		Random random = new Random();
	int randomNumber =	random.nextInt(5000);
	return randomNumber;
	}
  
	//create method for  start date format
	public String getSystemDateYYYYDDMM() {
		Date dateObj = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		 String date =sdf.format(dateObj);
		return date;
	}
	
	//create method for end date format or REquired date(next,or previous)
	public String getRequiredDateTYYYYDDMM(int days) {
		Date dateObj = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date =sdf.format(dateObj);
		Calendar cal = sdf.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		 String  reqDate = sdf.format(cal.getTime());
		 return reqDate;
		
	}
}
