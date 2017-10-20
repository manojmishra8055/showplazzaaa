package java4s;
 
import java.io.FileInputStream;
import java.util.Properties;
import javaConstants.Constants;
 
public class ReadPropertiesFile
{
	public  static void readConfig() throws Exception
	{
		try
		{
 
		    Properties pro = new Properties();
		   /* String path = System.getProperty("c:/v/java4_Props.properties");
		    pro.load(new FileInputStream(path));*/	   
 
		    Constants.delay = "1s";
		    Constants.timetoquery = "10s";
		    Constants.setFrom = "manojmishra443@gmail.com";
		   		   
 
		}
		catch(Exception e)
		{
            throw new Exception(e);
		}
 
	}
 
}