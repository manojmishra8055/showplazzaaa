package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;




import java4s.Connection_provider;
import java4s.Dicom;

public class JDBCPacs {

	public int insertDicomData(String name) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 0;
		int outoid = 0;
		String sql = "insert into pacsdata(dicom) values(?) ";
		
		try{
			connection = Connection_provider.getconnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			
			result = preparedStatement.executeUpdate();
			
			if(result == 1){
				ResultSet resultSet = preparedStatement.getGeneratedKeys();
				if(resultSet.next()){
					outoid = resultSet.getInt(1);  
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return outoid;
	}

	public boolean checkFileExist(String name) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		boolean result = false;
		String sql = "select * from pacsdata where dicom = '"+name+"' ";
		
		try{
			connection = Connection_provider.getconnection();
			preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			if(rs.next()){
				result = true;
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	public Dicom getPacsSettingDetails() {
		PreparedStatement preparedStatement = null;
		Dicom dicom = new Dicom();
		String sql = "select destination, source, patient_name, pdate, "
				+ "ptime, imgformatprefix, imgformat, width, height from pacs_setting where id = 1";
		Connection connection = null;
		try{
			connection = Connection_provider.getconnection();
			preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			if(rs.next()){
				dicom.setDestination(rs.getString(1));
				dicom.setSource(rs.getString(2));
				dicom.setPatient_name(rs.getBoolean(3));
				dicom.setDate(rs.getBoolean(4));
				dicom.setTime(rs.getBoolean(5));
				dicom.setImgformatprefix(rs.getBoolean(6));
				dicom.setImgformat(rs.getString(7));
				dicom.setWidth(rs.getString(8));
				dicom.setHeight(rs.getString(9));
				
				
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return dicom;
	}

	public int savePacsParent(String folderName) {
		PreparedStatement preparedStatement = null;
		int result = 0;
		int autoid = 0;
		String sql = "insert into pacs_parent (foldername) values(?) ";
		
		Connection connection = null;
		try{
			connection = Connection_provider.getconnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, folderName);
			
			result = preparedStatement.executeUpdate();
			
			if(result == 1){
				ResultSet resultSet = preparedStatement.getGeneratedKeys();
				if(resultSet.next()){
					autoid = resultSet.getInt(1);  
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return autoid;
	}


}


