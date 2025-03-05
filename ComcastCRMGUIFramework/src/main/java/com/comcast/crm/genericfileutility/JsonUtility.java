package com.comcast.crm.genericfileutility;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtility {
 public String getDataFromJsonFile(String key) throws IOException, ParseException
 {
	 FileReader fileR = new FileReader("./configAppData/appCommonData.json");
	 
	 //Step 1 : parse Json Physical file into java object using JsonParse class
	 JSONParser parser = new JSONParser();
	Object  obj = parser.parse(fileR);
	 
	 //Step 2: Convert java object into Jsonobject using downcasting
	 JSONObject map =(JSONObject)obj;
	 
	 //Step3 : get the value from json file using key
	
	 String data  = (String) map.get(key);
	 
	 return data;
 }
}
