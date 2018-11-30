package Data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class loadProperties {

public static Properties userData= loadProperties(System.getProperty("user.dir")+"\\src\\main\\java\\properties\\userData.properties");
	//public static Properties userData= loadProperties("D:\\Omnia Files\\taf\\src\\main\\java\\properties\\userData.properties");

	private static Properties loadProperties(String path) 
	{
		Properties prop=new Properties();
		try {
			FileInputStream stream =new FileInputStream(path);
			prop.load(stream);
		} catch (FileNotFoundException e) {
			System.out.println("Error"+e.getMessage());
		} catch (IOException e) {
			System.out.println("Error"+e.getMessage());
		}
		return prop;
}}
