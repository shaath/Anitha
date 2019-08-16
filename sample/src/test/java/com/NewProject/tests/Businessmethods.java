package com.NewProject.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.FileNameMap;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
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
	
	public static String identifyFileTypeUsingFilesProbeContentType(final String fileName)
	{
	   String fileType = "Undetermined";
	   final File file = new File(fileName);
	   try
	   {
	      fileType = Files.probeContentType(file.toPath());
	   }
	   catch (IOException ioException)
	   {
	      System.out.println(
	           "ERROR: Unable to determine file type for " + fileName
	              + " due to exception " + ioException);
	   }
	   return fileType;
	}
	
//	public String identifyFileTypeUsingMimetypesFileTypeMap(final String fileName)
//	{    
//	   final MimetypesFileTypeMap fileTypeMap = new MimetypesFileTypeMap();
//	   return fileTypeMap.getContentType(fileName);
//	}
	
	public String identifyFileTypeUsingUrlConnectionGetContentType(final String fileName)
	{
	   String fileType = "Undetermined";
	   try
	   {
	      final URL url = new URL("file://" + fileName);
	      final URLConnection connection = url.openConnection();
	      fileType = connection.getContentType();
	   }
	   catch (MalformedURLException badUrlEx)
	   {
	      System.out.println("ERROR: Bad URL - " + badUrlEx);
	   }
	   catch (IOException ioEx)
	   {
		   System.out.println("Cannot access URLConnection - " + ioEx);
	   }
	   return fileType;
	}

	public static String  whenUsingGetFileNameMap_thenSuccess(String name){
	    File file = new File(name);
	    FileNameMap fileNameMap = URLConnection.getFileNameMap();
	    String mimeType = fileNameMap.getContentTypeFor(file.getName());
	  
	    return mimeType;
	}
}
