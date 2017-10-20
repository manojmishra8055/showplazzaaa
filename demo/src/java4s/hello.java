package java4s;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.tomcat.util.http.fileupload.FileUtils;

public class hello {
	
	public static void main(String[] args) {
		/*File file = new File("C:\\v/sms.txt");
		file.delete();
		System.out.println("deleted");*/
		
	/*	File folder = new File("c:/dicom");
    	File[] listOfFiles = folder.listFiles();

    	for (int i = 0; i < listOfFiles.length; i++) {
    	  File file = listOfFiles[i];
    	  if (file.isFile()) {
    	    System.out.println(file.getName());
    	     do somthing with content 
    	  } 
    	}*/
		
		DateFormat dateFormat = new SimpleDateFormat("HH:mm");
		Calendar cal = Calendar.getInstance();
		String fromDate = dateFormat.format(cal.getTime());
		System.out.println(fromDate);
	}

}
