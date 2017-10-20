package java4s;
 
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import org.apache.tomcat.util.http.fileupload.FileUtils;








import JDBC.JDBCPacs;
import javaConstants.Constants;
 
public class Testing extends TimerTask
{
 
	public void run()
	{
 
               /* GMailServer sender = new GMailServer(Constants.setFrom, Constants.setPassword);
 */
	            try {
	            	JDBCPacs jdbcPacs = new JDBCPacs();
	            	Dicom dicom = jdbcPacs.getPacsSettingDetails();
	            	
	            	//File folder = new File("c:/dicom");
	            	File folder = new File(dicom.getSource());
	            	File[] listOfFiles = folder.listFiles();
	            	
	            	DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        			Calendar cal = Calendar.getInstance();
        			String curTime = dateFormat.format(cal.getTime());
        			
        			DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        			Calendar cal1 = Calendar.getInstance();
        			String curDate = dateFormat1.format(cal1.getTime());
        			
        			String folderName = "";
        			
        			if(dicom.isPatient_name()){
        				folderName = folderName + "Pname";
        			}
        			if(dicom.isDate()){
        				folderName = folderName + "_" + curDate;
        			}
        			if(dicom.isTime()){
        				folderName = folderName + "_" + curTime;
        			}
        			if(dicom.isImgformatprefix()){
        				folderName = folderName + "_" + dicom.getImgformat();
        			}
        			
        			int pacsParent = 0;

	            	for (int i = 0; i < listOfFiles.length; i++) {
	            		if(i==0){
	            			pacsParent = jdbcPacs.savePacsParent(folderName);
	            		}
	            		
	            	  File file = listOfFiles[i];
	            	  if (file.isFile()) {
	            	    System.out.println(file.getName());
	            	    
	            	    Iterator<ImageReader> iter = ImageIO
		        				.getImageReadersByFormatName("DICOM");
		        		ImageReader reader = (ImageReader) iter.next();

		        		if (reader == null) {
		        			return;
		        		}

		        		//ImageInputStream iis = ImageIO.createImageInputStream(new File("c:/dicom/"+file.getName()));
		        		ImageInputStream iis = ImageIO.createImageInputStream(new File(dicom.getSource()+"/"+file.getName()));

		        		BufferedImage bi;
		        		try {
		        			
		        			boolean checkfileexist = jdbcPacs.checkFileExist(file.getName());
		        			if(!checkfileexist){
		        				int dicomid = jdbcPacs.insertDicomData(file.getName());
			        			
			        			reader.setInput(iis);
			        			bi = ImageIO.read(iis);
			        			
			        			//ImageIO.write(bi, "png", new File("c:/dimage/IM"+dicomid+".png"));
			        			ImageIO.write(bi, dicom.getImgformat(), new File(dicom.getDestination()+"/IM"+dicomid+"."+dicom.getImgformat()));
			        			String imagename = dicom.getDestination()+"/IM"+dicomid+"."+dicom.getImgformat();
			        			System.out.println("done");
			        			
			        			
			        			
			        			insertImageMysql(imagename,dicomid,pacsParent);
		        			}
		        			
		        			
		        			
		        			
		        		} finally {

		        		}
	            	    
	            	  } 
	            	}
	            
	            	
	            	
	        		
	        		
			}
                   catch (Exception e) {
			     e.printStackTrace();
			}  
 
				System.out.println("Email Sent Succesfully...");
 
	        }

	private void insertImageMysql(String imagename,int dicomid,int pacsparent) throws SQLException {
		Connection connection = null;
		
		try{
			
			connection = Connection_provider.getconnection();
			
			File imgfile = new File(imagename);
			  
			  FileInputStream fin = new FileInputStream(imgfile);
			 
			   PreparedStatement pre =connection.prepareStatement("update pacsdata set image=?,pacsparent=? where id="+dicomid+" ");
			 
			  
			   pre.setBinaryStream(1,(InputStream)fin,(int)imgfile.length());
			   pre.setInt(2, pacsparent);
			   pre.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
		
	
		
	}

}