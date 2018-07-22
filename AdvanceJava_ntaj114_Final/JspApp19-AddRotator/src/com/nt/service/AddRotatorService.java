package com.nt.service;

import java.util.Random;

public class AddRotatorService {
	private String images[]={"raymond.jpg","onlyvimal.jpg","siyarams.jpg","ramraj.jpg","peterengland.jpg"};
	private  String links[]={"http://www.raymond.in/","http://onlyvimal.co.in/","http://www.siyaram.com/","https://www.ramrajcotton.in/","https://www.peterengland.com/"};
	int index;
	
	public void nextAdvertisement(){
		Random rad=null;
		rad=new Random();
		index=rad.nextInt(5);
	}
	
	public String getImage(){
		return images[index];
	}
	
	public String getLink(){
		return links[index];
	}
	
}//class
