package ufc.quixada.biblioteca.fbd.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory 
{
	public static Connection getConnection() throws SQLException
	{
		return DriverManager.getConnection("jdbc:postgresql://localhost/data" , "postgres" , "aline0805");
	}

}
