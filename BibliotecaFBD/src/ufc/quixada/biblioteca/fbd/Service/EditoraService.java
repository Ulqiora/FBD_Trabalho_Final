package ufc.quixada.biblioteca.fbd.Service;

import java.sql.Connection;
import java.util.ArrayList;

import ufc.quixada.biblioteca.fbd.Entity.Editora;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class EditoraService 
{
	
	
	public Editora map(ResultSet rs) throws SQLException
	{
		Editora e1 = new Editora();
		e1.setId(rs.getInt("id"));
		e1.setCod(rs.getInt("cod"));
		e1.setNome(rs.getString("nome"));
		
		return e1;
	}
	public void save(Editora e)
	{
		Connection con = null;
		
		try
		{
			con = ConnectionFactory.getConnection();
			String insertEditora = "insert into editora(cod, nome) values (?, ?)";
			PreparedStatement ps = con.prepareStatement(insertEditora);
			
			ps.setInt(1, e.getCod());
			ps.setString(2, e.getNome());
			ps.executeUpdate();
			
		}catch(SQLException e1)
		{
			throw new DAOException("Não foi possível concluir a operação", e1);
		}finally
		{
			try
			{
				if(con != null)
					con.close();
			}catch(SQLException e1)
			{
				throw new DAOException("Não foi possível fechar a conexão", e1);
			}
		}
	}
	
	public void update(Editora e1, int id)
	{
		Connection con = null;
		
		try
		{
			con = ConnectionFactory.getConnection();
			String update = "update editora set cod = ?, nome = ?, id = ? where id = ?";
			PreparedStatement ps;
			
			ps = con.prepareStatement(update);
			ps.setString(2, e1.getNome());
			ps.setInt(1, e1.getCod());
			ps.setInt(3, e1.getId());
			ps.setInt(4, id);
			
			ps.executeUpdate();
			
		}catch(SQLException e)
		{
			throw new DAOException("Não foi possível concluir a operação", e);
		}
		finally
		{
			try
			{
				if(con != null)
					con.close();
			}catch(SQLException e)
			{
				throw new DAOException("Não foi possível fechar a conexão", e);
			}
		}
	}
	
	public void delete(int cod)
	{
		Connection con = null;
		try
		{
			con = ConnectionFactory.getConnection();
			con.setAutoCommit(false);
			
			String delete = "delete fom editora where cod = ?";
			PreparedStatement ps = con.prepareStatement(delete);
			ps.setInt(1, cod);
			ps.executeUpdate();
			
			con.commit();
		}catch(SQLException e)
		{
			try
			{
				con.rollback();
			}catch(SQLException e1)
			{
				throw new DAOException("Não soi possível concluir a operação", e1);
			}
		}
		finally
		{
			try
			{
				if(con != null)
					con.close();
			}catch(SQLException e)
			{
				throw new DAOException("Não foi possível fechar a conexão", e);
			}
		}
	}
	
	public Editora find(int id)
	{	Editora ed = null;
		Connection con = null;
		try
		{
			con = ConnectionFactory.getConnection();
			String find = "select nome, cod, id from editora where id = ?";
			PreparedStatement ps = con.prepareStatement(find);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				ed = map(rs);
			}
		}catch(SQLException e)
		{
			throw new DAOException("Operação cancelada");
		}
		finally
		{
			try
			{
				if(con != null)
					con.close();
			}
			catch(SQLException e)
			{
				throw new DAOException("Não foi possível fechar a conexão", e);
			}
		}
		
		return ed;
	}
	
	public ArrayList<Editora> search()
	{
		ArrayList<Editora> ed = new ArrayList<Editora>();
		Connection con = null;
		
		try
		{
			con = ConnectionFactory.getConnection();
			String findAll = "select id, cod, nome from editora";
			PreparedStatement ps = con.prepareStatement(findAll);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				ed.add(map(rs));
			}
		}catch(SQLException e)
		{
			throw new DAOException ("Operação cancelada", e);
		}
		finally
		{
			try
			{
				if(con != null)
					con.close();
			}catch(SQLException e)
			{
				throw new DAOException("Não foi possível fechar a conexão", e);
			}
		}
		
		return ed;
	}
	
	
}
