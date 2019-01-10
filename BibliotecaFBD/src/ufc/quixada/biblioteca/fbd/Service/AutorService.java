package ufc.quixada.biblioteca.fbd.Service;

import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import ufc.quixada.biblioteca.fbd.Entity.Autor;
import java.sql.SQLException;

public class AutorService 
{
	public void save(Autor a)
	{
		Connection con = null;
		
		try
		{
			con = ConnectionFactory.getConnection();
			con.setAutoCommit(false);
			
			String insert = "insert into autor (nome, cod_cat) values  (?, ?)";
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setString(1, a.getNome());
			ps.setString(2, a.getCod_d());
						
			ps.executeUpdate();
			con.commit();
		}catch(SQLException e)
		{
			try
			{
				con.rollback();
			}catch(SQLException e1)
			{
				throw new DAOException("Operação Cancelada", e);
			}
		}finally
		{
			try
			{
				if(con != null)
					con.close();
			}catch(SQLException e)
			{
				throw new DAOException("Não foi possível fechar a conexão");
			}
		}
	}
	
	public void update(Autor a, String cod_cat)
	{
		Connection con = null;
		try
		{
			con = ConnectionFactory.getConnection();
			con.setAutoCommit(false);
			
			String update = "update autor set id = ?, nome = ?, cod_cat = ? where cod_cat = ?";
			PreparedStatement ps = con.prepareStatement(update);
			ps.setInt(1, a.getId());
			ps.setString(2, a.getNome());
			ps.setString(3, a.getCod_d());
			ps.setString(4, cod_cat);
			
			ps.executeUpdate();
			con.commit();
		}catch(SQLException e)
		{
			try
			{
				con.rollback();
			}catch(SQLException e1)
			{
				throw new DAOException("Operação Cancelada", e);
			}
		}finally
		{
			try
			{
				if(con != null)
					con.close();
			}catch(SQLException e)
			{
				throw new DAOException("Não foi possível fechar a conexão");
			}
		}
		
	}
	
	public void delete(String cod_cat)
	{
		Connection con = null;
		try
		{
			con = ConnectionFactory.getConnection();
			con.setAutoCommit(false);
			
			String del = "delete from autor where cod_cat = ?";
			PreparedStatement ps = con.prepareStatement(del);
			ps.setString(1, cod_cat);
			ps.executeUpdate();
			con.commit();
		}catch(SQLException e)
		{
			try
			{
				con.rollback();
			}catch(SQLException e1)
			{
				throw new DAOException("Operação Cancelada", e);
			}
		}finally
		{
			try
			{
				if(con != null)
					con.close();
			}catch(SQLException e)
			{
				throw new DAOException("Não foi possível fechar a conexão");
			}
		}
	}
	
	public Autor find(String cod_cat)
	{
		Connection con = null;
		Autor a = null;
		
		try
		{
			con = ConnectionFactory.getConnection();
			String find = "select id_a, cod_cat, nome from autor where cod_cat = ?";
			PreparedStatement ps = con.prepareStatement(find);
			ps.setString(1, cod_cat);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
				a = map(rs);
		}catch(SQLException e)
		{
			
				throw new DAOException("Operação Cancelada", e);
		}finally
		{
			try
			{
				if(con != null)
					con.close();
			}catch(SQLException e)
			{
				throw new DAOException("Não foi possível fechar a conexão");
			}
		}
		return a;
	}
	
	public Autor map(ResultSet rs) throws SQLException
	{
		Autor a = new Autor();
		a.setCod_d(rs.getString("cod_cat"));
		a.setId(rs.getInt("id_a"));
		a.setNome(rs.getString("nome"));
		
		return a;
	}
}










