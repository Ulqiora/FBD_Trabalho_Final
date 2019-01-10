package ufc.quixada.biblioteca.fbd.Service;

import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import ufc.quixada.biblioteca.fbd.Entity.Endereco;
import java.sql.SQLException;

public class EnderecoService 
{
	public void save(Endereco adress)
	{
		Connection con = null;
		
		try
		{
			con = ConnectionFactory.getConnection();
			con.setAutoCommit(false);
			
			String insert = "insert into endereco(rua, bairro, complemento, numero, id_us = ?) values(?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(insert);
			
			ps.setString(1, adress.getRua());
			ps.setString(2, adress.getBairro());
			ps.setString(3, adress.getComplemento());
			ps.setInt(4, adress.getNumero());
			ps.setInt(5, adress.getIdUser());
			
			ps.executeUpdate();
			con.commit();
			
		}catch(SQLException e)
		{
			try
			{
				con.rollback();
			}catch(SQLException e1)
			{
				throw new DAOException("Operação cancelada", e1);
			}
		}finally
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
	
	public void update(Endereco adress)
	{
		Connection con = null;
		
		try
		{
			con = ConnectionFactory.getConnection();
			con.setAutoCommit(false);
			
			String update = "update endereco set rua = ?, bairro = ?, complemento = ?, numero = ?, id_us = ? where id = ?";
			PreparedStatement ps = con.prepareStatement(update);
			ps.setString(1, adress.getRua());
			ps.setString(2, adress.getBairro());
			ps.setString(3, adress.getComplemento());
			ps.setInt(4, adress.getNumero());
			ps.setInt(5, adress.getIdUser());
			ps.setInt(6, adress.getId());
			
			ps.executeUpdate();
			con.commit();
			
		}catch(SQLException e)
		{
			try
			{
				con.rollback();
			}catch(SQLException e1)
			{
				throw new DAOException("Operação cancelada", e1);
			}
		}finally
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
	
	
	public void delete(int id)
	{
		Connection con = null;
		try
		{
			con = ConnectionFactory.getConnection();
			con.setAutoCommit(false);
			
			String del = "delete from endereco where id = ?";
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
				throw new DAOException("Operação cancelada", e1);
			}
		}finally
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
	
	public Endereco find(int id)
	{
		Connection con = null;
		Endereco adress = null;
		
		try
		{
			con = ConnectionFactory.getConnection();
			String find = "select id, rua, bairro, complemento, numero, id_us from endereco where id = ?";
			PreparedStatement ps = con.prepareStatement(find);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
				adress = map(rs);
			
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
				throw new DAOException("Não foi possível fechar a conexão", e);
			}
		}
		
		return adress;
	}
	
	public Endereco map(ResultSet rs) throws SQLException
	{
		Endereco e = new Endereco();
		e.setBairro(rs.getString("bairro"));
		e.setRua(rs.getString("rua"));
		e.setComplemento(rs.getString("complemento"));
		e.setNumero(rs.getInt("numero"));
		e.setId(rs.getInt("id"));
		e.setIdUser(rs.getInt("id_us"));
		
		return e;
	}
}











