package ufc.quixada.biblioteca.fbd.Service;

import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import ufc.quixada.biblioteca.fbd.Entity.Usuario;
import ufc.quixada.biblioteca.fbd.Service.EnderecoService;
import java.sql.SQLException;

public class UsuarioService 
{
	public UsuarioService() {}
	public void save(Usuario u)
	{
		Connection con = null;
		try
		{
			con = ConnectionFactory.getConnection();
			
			String insert = "insert into usuario (cpf, rg, nome) values (?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(insert);
			
			ps.setString(1, u.getCpf());
			ps.setString(2, u.getRg());
			ps.setString(3, u.getNome());
//			ps.setString(4, u.getEmail());
			
			ps.executeUpdate();
		}catch(SQLException e)
		{
			throw new DAOException("ERROR: Operação falhou", e);
		}finally
		{
			try
			{
				if(con != null)
					con.close();
			}catch(SQLException e)
			{
				throw new DAOException("ERROR: Não é possível fechar a conexão", e);
			}
		}
	}
	
	public void update(Usuario u, int id)
	{
		Connection con = null;
		try
		{
			con = ConnectionFactory.getConnection();
			con.setAutoCommit(false);
			
			String update = "update usuario set cpf = ?, rg = ?, id = ?, email = ?, nome = ? where id = ?";
			PreparedStatement ps = con.prepareStatement(update);
			
			ps.setString(1, u.getCpf());
			ps.setString(2, u.getRg());
			ps.setInt(3, u.getId());
			ps.setString(4, u.getEmail());
			ps.setString(5, u.getNome());
			ps.setInt(6, id);
			
			ps.executeUpdate();
		}catch(SQLException e)
		{
			try
			{
				con.rollback();
			}catch(SQLException e1)
			{
				throw new DAOException("ERROR: Operação falhou", e1);
			}
		}finally
		{
			try
			{
				if(con != null)
					con.close();
			}catch(SQLException e)
			{
				throw new DAOException("ERROR: Não é possível fechar a conexão", e);
			}
		}
	}
	
	public void delete(int id)
	{
		Connection con = null;
		
		try
		{
			con = ConnectionFactory.getConnection();
			con.setAutoCommit(false);
			
			String del = "delete from usuario where id = ?";
			PreparedStatement ps = con.prepareStatement(del);
			
			ps.setInt(1, id);
			ps.executeUpdate();
			
			con.commit();
		}catch(SQLException e)
		{
			try
			{
				con.rollback();
			}catch(SQLException e1)
			{
				throw new DAOException("ERROR: Operação falhou", e1);
			}
		}finally
		{
			try
			{
				if(con != null)
					con.close();
			}catch(SQLException e)
			{
				throw new DAOException("ERROR: Não é possível fechar a conexão", e);
			}
		}
	}
	
	public Usuario findCpf(String cpf)
	{
		Connection con = null;
		Usuario user = null;
		
		try
		{
			con = ConnectionFactory.getConnection();
			String find = "select cpf, rg, email, nome, id from usuario where cpf = ?";
			PreparedStatement ps = con.prepareStatement(find);
			ps.setString(1, cpf);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
				user = map(rs);
			
		}catch(SQLException e)
		{
			throw new DAOException("ERROR: Operação falhou", e);

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
		
		return user;
	}
	
	public Usuario findNome(String nome)
	{
		Connection con = null;
		Usuario user = null;
		
		try
		{
			con = ConnectionFactory.getConnection();
			String find = "select cpf, rg, email, nome, id from usuario where nome = ?";
			PreparedStatement ps = con.prepareStatement(find);
			ps.setString(1, nome);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
				user = map(rs);
			
		}catch(SQLException e)
		{
			throw new DAOException("ERROR: Operação falhou", e);

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
		
		return user;
	}
	
	public Usuario map(ResultSet rs) throws SQLException
	{
		Usuario u1 = new Usuario();
		u1.setCpf(rs.getString("cpf"));
		u1.setId(rs.getInt("id"));
		u1.setRg(rs.getString("rg"));
		u1.setEmail(rs.getString("email"));
		u1.setNome(rs.getString("nome"));
		
		return u1;
	}
}

















