package java4s;









import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Connection_provider {
public static Connection getconnection() throws SQLException
{
	Connection con=null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		//con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","yuvika29","Yuvika&001");
		
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pacs","root","mysql");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	return con;
}
}
