package ufc.quixada.biblioteca.fbd.Service;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import ufc.quixada.biblioteca.fbd.Entity.Emprestimo;
import ufc.quixada.biblioteca.fbd.Entity.Usuario;
import ufc.quixada.biblioteca.fbd.Service.UsuarioService;
//import ufc.quixada.biblioteca.fbd.Service.ExemplarService;
import java.sql.SQLException;
import java.util.Date;

public class EmprestimoService 
{
	public void save(Emprestimo e)
	{
		Connection con = null;
		try
		{
			con = ConnectionFactory.getConnection();
			
			String insert = "insert into emprestimo (data_emp, data_dev, id_us, id_exemplar, data_limite) values(?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(insert);
			
			ps.setDate(1, new java.sql.Date(e.getEmprestimo().getTimeInMillis()));
			ps.setDate(2, new java.sql.Date(e.getDataDev().getTimeInMillis()));
			ps.setInt(3, e.getUser().getId());
			ps.setInt(4, e.getExemp().getId());
			ps.setDate(5, new java.sql.Date(e.getDataLimit().getTimeInMillis()));
			
			ps.executeUpdate();
		}catch(SQLException e1)
		{
			throw new DAOException("ERROR: Falaha na operação", e1);
		}finally
		{
			try
			{
				if(con != null)
					con.close();
			}catch(SQLException e1)
			{
				throw new DAOException("ERROR: Falha ao fechar a conexão", e1);
			}
		}
	}
	
	public void update(Emprestimo em)
	{
		Connection con = null;
		
		try
		{
			con = ConnectionFactory.getConnection();
			String update = "update emprestimo (data_emprestimo, data_limite, data_dev, id_us, id_exemplar) values(?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(update);
			
			ps.setDate(1, new java.sql.Date(em.getEmprestimo().getTimeInMillis()));
			ps.setDate(2, new java.sql.Date(em.getDataLimit().getTimeInMillis()));
			ps.setDate(3, new java.sql.Date(em.getDataDev().getTimeInMillis()));
			ps.setInt(4, em.getUser().getId());
			ps.setInt(5, em.getExemp().getId());
			
			ps.executeUpdate();
			
		}catch(SQLException e)
		{
			throw new DAOException("ERROR: Falha na operação");
		}
		finally
		{
			try
			{
				if(con != null)
					con.close();
			}catch(SQLException e)
			{
				throw new DAOException("ERROR: Falha ao fechar a conexão");
			}
		}
		
	}
	
	public void delete(int id)
	{
		Connection con = null;
		try
		{
			con = ConnectionFactory.getConnection();
			String del = "delete from emprestimo where id_emp = ?";
			
			PreparedStatement ps = con.prepareStatement(del);
			
			ps.setInt(1, id);
			ps.executeUpdate();
		}catch(SQLException e)
		{
			throw new DAOException("ERROR: Falha ao realizar a operação", e);
		}finally
		{
			try
			{
				if(con != null)
					con.close();
			}catch(SQLException e)
			{
				throw new DAOException("ERROR: Falha ao fechar a conexão");
			}
		}
	}
	
	public Emprestimo find(int id)
	{
		Connection con = null;
		Emprestimo em = null;
		try
		{
			con = ConnectionFactory.getConnection();
			String find = "select data_dev, data_limite, data_emp, id_emp from emprestimo where id_emp = ?";
			
			PreparedStatement ps = con.prepareStatement(find);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				em = map(rs);
			}
			
		}catch(SQLException e)
		{
			throw new DAOException("ERROR: Falha ao realizar operação", e);
		}finally
		{
			try
			{
				if(con != null)
					con.close();
			}catch(SQLException e)
			{
				throw new DAOException("ERROR: Falha ao fechar a conexão");
			}
		}
		
		return em;
	}
	
	public Emprestimo map(ResultSet rs) throws SQLException
	{
		Emprestimo em = new Emprestimo();
		Calendar dt = Calendar.getInstance();
		Date d = rs.getDate("data_dev");
		dt.setTimeInMillis(d.getTime());
		em.setDataDev(dt);
		
		d = rs.getDate("data_emp");
		dt.setTimeInMillis(d.getTime());
		em.setEmprestimo(dt);
		
		d = rs.getDate("data_limite");
		dt.setTimeInMillis(d.getTime());
		em.setDataLimit(dt);
		
		return em;
	}
}















