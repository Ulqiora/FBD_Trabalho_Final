package ufc.quixada.biblioteca.fbd.Service;


import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import ufc.quixada.biblioteca.fbd.Entity.Professor;
import ufc.quixada.biblioteca.fbd.Service.EnderecoService;
import java.sql.SQLException;

public class ProfessorService 
{
	private void save(Professor p)
	{
		Connection con = null;
		try
		{
			con = ConnectionFactory.getConnection();
			con.setAutoCommit(false);
			
			String insert = "insert into ptofessor(cod_reg, id_usuario) values(?, ?)";
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setInt(1, p.getCod());
			ps.setInt(2, p.getId());
			
			ps.executeUpdate();
			con.commit();
		}catch(SQLException e)
		{
			try
			{
				con.rollback();
			}catch(SQLException e1)
			{
				throw new DAOException("ERROR: Não foi possível realizar a operação", e1);
			}
		}finally
		{
			try
			{
				if(con != null)
					con.close();
			}catch(SQLException e)
			{
				throw new DAOException("ERROR: Não foi possível fecha  a conexão", e);
			}
		}
	}
	
	private void update(Professor p)
	{
		Connection con = null;
		
		try
		{
			con = ConnectionFactory.getConnection();
			con.setAutoCommit(false);
			
			String update = "update professor set cod_reg,  = ?, id_usuario where id = ?";
			PreparedStatement ps = con.prepareStatement(update);
			ps.setInt(1, p.getCod());
			ps.setInt(2, p.getId());
			
			ps.executeUpdate();
			con.commit();
		}catch(SQLException e)
		{
			try
			{
				con.rollback();
			}catch(SQLException e1)
			{
				throw new DAOException("ERROR: Não foi possível realizar a operação", e1);
			}
		}finally
		{
			try
			{
				if(con != null)
					con.close();
			}catch(SQLException e)
			{
				throw new DAOException("ERROR: Não foi possível fecha  a conexão", e);
			}
		}
	}
	
	public void delete(int del)
	{
		Connection con = null;
		try
		{
			con = ConnectionFactory.getConnection();
			con.setAutoCommit(false);
			
			String delete = "delete from professor where id_au =?";
			PreparedStatement ps = con.prepareStatement(delete);
			ps.setInt(1, del);
			ps.executeUpdate();
			
			con.commit();
		}catch(SQLException e)
		{
			try
			{
				con.rollback();
			}catch(SQLException e1)
			{
				throw new DAOException("ERROR: Não foi possível realizar a operação", e1);
			}
		}finally
		{
			try
			{
				if(con != null)
					con.close();
			}catch(SQLException e)
			{
				throw new DAOException("ERROR: Não foi possível fecha  a conexão", e);
			}
		}
	}
	
	public Professor findNome(String nome)
	{
		Connection con = null;
		Professor p = null;
		try
		{
			con = ConnectionFactory.getConnection();
			String fnd = "select id_au, cod_reg, id_usuario from professor, usuario as u where id_usuario = uy.id and u.nome = ?";
			PreparedStatement ps = con.prepareStatement(fnd);
			ps.setString(1, nome);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
				p = map(rs);
			
			
		}catch(SQLException e)
		{
			try
			{
				con.rollback();
			}catch(SQLException e1)
			{
				throw new DAOException("ERROR: Não foi possível realizar a operação", e1);
			}
		}finally
		{
			try
			{
				if(con != null)
					con.close();
			}catch(SQLException e)
			{
				throw new DAOException("ERROR: Não foi possível fecha  a conexão", e);
			}
		}
		
		return p;
	}
	
	public Professor findId(int id)
	{
		Connection con = null;
		Professor p = null;
		try
		{
			con = ConnectionFactory.getConnection();
			String fnd = "select id_au, cod_reg, id_usuario from professor, usuario as u where id_usuario = uy.id and id_au = ?";
			PreparedStatement ps = con.prepareStatement(fnd);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
				p = map(rs);
			
			
		}catch(SQLException e)
		{
			try
			{
				con.rollback();
			}catch(SQLException e1)
			{
				throw new DAOException("ERROR: Não foi possível realizar a operação", e1);
			}
		}finally
		{
			try
			{
				if(con != null)
					con.close();
			}catch(SQLException e)
			{
				throw new DAOException("ERROR: Não foi possível fecha  a conexão", e);
			}
		}
		
		return p;
	}
	
	private Professor map(ResultSet rs) throws SQLException 
	{
		Professor p1 = new Professor();
		p1.setCod(rs.getInt("cod_reg"));
		p1.setId_p(rs.getInt("id_au"));;
		p1.setId(rs.getInt("id_usuario"));
		
		return p1;
	}
}








