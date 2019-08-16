package com.NewProject.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Businessmethods 
{
	public static FileInputStream fi;
	public static Properties pr;
	
	public static String Resourseproperties(String name) throws IOException
	{
		fi=new FileInputStream("E:\\Test\\NewProject\\src\\com\\NewProject\\config\\config.properties");
		pr=new Properties();
		pr.load(fi);
		return pr.getProperty(name);
	}

}
