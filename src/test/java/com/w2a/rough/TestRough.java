package com.w2a.rough;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestRough {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String path=System.getProperty("user.dir");
		Properties config= new Properties();
		Properties OR= new Properties();
		
		FileInputStream fis=new FileInputStream(path+"\\src\\test\\resources\\properties\\Config.properties");
		config.load(fis);
		
		fis=new FileInputStream(path+"\\src\\test\\resources\\properties\\OR.properties");
		OR.load(fis);
		
		
		System.out.println(config.getProperty("browser"));
		System.out.println(config.getProperty("url"));
		
		
		
	}

}
