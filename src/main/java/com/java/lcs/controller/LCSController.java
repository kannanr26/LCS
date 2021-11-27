package com.java.lcs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.lcs.model.LCS;
import com.java.lcs.model.LCSRequest;
import com.java.lcs.service.LCSService;

@RestController
public class LCSController {

	
	@Autowired
	private LCSService lcsService;
	
	private boolean isValid=true;
	private String msg;
	@PostMapping("/lcs")
	public ResponseEntity<LCS> lcs(@RequestBody String lcs) {
		
	String[] str=	validate(lcs);
		if(isValid) {
			String lcStr=lcsService.findLCS(str);
				String[] value= {lcStr};
				//LCS lcString= new LCS(value,"Success");	
		
		return  ResponseEntity.ok().body(new LCS(value,"Success"));
	
		}
		
		return  ResponseEntity.badRequest().body(new LCS(null,msg));
	}
	
	@PostMapping("/lcs2")
	public LCS lcs2(@RequestBody LCSRequest lcsRequest) {
		String lcStr=lcsService.findLCS(lcsRequest.getSetofStrings().getValues());
		String[] value= {lcStr};
		LCS lcs = new LCS(value,"SUCCESS");
		
		return lcs;
	
		
	}
	private String[] validate(String lcs) {
		// TODO Auto-generated method stub
		int indexArrayStart=lcs.indexOf('[');
		int indexArrayStop=lcs.indexOf(']');
		
		String errMsg="Parse Error: invalid input";
		String arrStr=lcs.substring(indexArrayStart+1,indexArrayStop);
		String[] keyValueArr=arrStr.split(",");
		String[] returnString = new String[keyValueArr.length];
		//boolean isValidInput=true;
		
		for (int i=0;i<keyValueArr.length;i++) {
		//	System.out.println(keyValueArr[i]);
			
			
			int indexStart=keyValueArr[i].indexOf('{');
			int indexStop=keyValueArr[i].indexOf('}');
			
			String valueStr=keyValueArr[i].substring(indexStart+1,indexStop);
			
			String[] strValue=valueStr.split(":");
			
						//System.out.println(":::"+);
			String key=strValue[0].replaceAll("\"", "");
			String val=strValue[1].replaceAll("\"", "");
			
			if(key.trim().equalsIgnoreCase("value")) {
				System.out.println(" Key Present");
				
			}else {
				System.out.println(" Key is not present");
				msg = "Key is not present."+errMsg;
				isValid=false;
				
			}
			System.out.println("::"+val);
			if(val.trim().isEmpty()==false) {
				returnString[i]=val;
			}else {
				isValid=false;
				msg="Value is not present."+errMsg;
			}
			
			if(!isValid)
				break;

		}
		
		/*
		if(isValidInput) {
		for (String string : returnString) {
			System.out.println(string);
		}
		}else {
			System.out.println(" Parse Error: invalid input");
		}
		 */
		return returnString;
	}
}