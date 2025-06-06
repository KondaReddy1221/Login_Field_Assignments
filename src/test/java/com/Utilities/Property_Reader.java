package com.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Property_Reader {
	
	static Properties pro;

	public static Properties init_Prop() {
		
		try {
			FileInputStream file=new FileInputStream("src/test/resources/Data_Sets/Data.properties");
			
			pro=new Properties();
			
			try {
				pro.load(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pro;
	}
}