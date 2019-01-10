
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import ufc.quixada.biblioteca.fbd.Service.*;
import ufc.quixada.biblioteca.fbd.Entity.Usuario;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class Principal {
	public static void main(String args[]) throws SQLException
	{
		Connection con = null;
		
		try
		{
			Calendar c = Calendar.getInstance();
			con = ConnectionFactory.getConnection();
			String insert = "insert into data (dt) values (?)";
			
			c.set(Calendar.DAY_OF_MONTH, 12);
			c.set(Calendar.MONTH, 10);
			c.set(Calendar.YEAR, 2019);
			
			PreparedStatement ps = con.prepareStatement(insert);
			
			ps.setDate(1, new java.sql.Date(c.getTimeInMillis()));
			ps.executeUpdate();
			
			System.out.println("fim");
		}catch(SQLException e)
		{
			throw new DAOException("ERROR", e);
		}
		finally 
		{
			try
			{
				if(con != null)
					con.close();
			}catch(SQLException e)
			{
				throw new DAOException("ERROR", e);
			}
		}
	}
	
}
