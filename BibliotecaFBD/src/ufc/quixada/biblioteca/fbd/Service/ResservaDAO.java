package ufc.quixada.biblioteca.fbd.Service;

import java.sql.Connection;
import java.util.Calendar;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import ufc.quixada.biblioteca.fbd.Entity.Reserva;
import ufc.quixada.biblioteca.fbd.Service.UsuarioService;
import ufc.quixada.biblioteca.fbd.Service.LivroService;

public class ResservaDAO 
{
	
	private String INSERT = "inset into reserva(data_l, data_r, id_l, id_u) values (?, ?, ?, ?)";
	private String UPDATE = "update reserva set data_l = ?, data_r = ?, id_us = ?, id_l = ? where id = ?";
	private String DELETE = "delete from reserva where id = ?";
	private String FIND = "select id, id_l, id_u, data_l, data_r from reserva where id = ?";

	public void insert(Reserva r)
	{
		Connection con = null;
		try
		{
			con = ConnectionFactory.getConnection();
			PreparedStatement ps = con.prepareStatement(this.INSERT);
			ps.setDate(1, new java.sql.Date(r.getDt_lib().getTimeInMillis()));
			ps.setDate(2, new java.sql.Date(r.getDt_reserva().getTimeInMillis()));
			ps.setInt(3, r.getTitle().getIdLivro());
			ps.setInt(4, r.getUser().getId());
			
			ps.executeUpdate();
		}catch(SQLException e)
		{
			throw new DAOException("ERROR: Falaha na operação", e);
		}
		finally
		{
			try
			{
				if(con != null)
					con.close();
			}catch(SQLException e)
			{
				throw new DAOException("ERROR: Não foi possível fechar a conexão", e);
			}
		}
	}
	
	public void update(Reserva r)
	{
		Connection con = null;
		try
		{
			con = ConnectionFactory.getConnection();
			PreparedStatement ps = con.prepareStatement(this.UPDATE);
			ps.setDate(1, new java.sql.Date(r.getDt_lib().getTimeInMillis()));
			ps.setDate(2, new java.sql.Date(r.getDt_reserva().getTimeInMillis()));
			ps.setInt(3, r.getTitle().getIdLivro());
			ps.setInt(4, r.getUser().getId());
			ps.setInt(5, r.getId());
			
			ps.executeUpdate();
		}catch(SQLException e)
		{
			throw new DAOException("ERROR: Falaha na operação", e);
		}
		finally
		{
			try
			{
				if(con != null)
					con.close();
			}catch(SQLException e)
			{
				throw new DAOException("ERROR: Não foi possível fechar a conexão", e);
			}
		}
	}
	
	public void delete(int id_r)
	{
		Connection con = null;
		try
		{
			con = ConnectionFactory.getConnection();
			PreparedStatement ps = con.prepareStatement(this.DELETE);
			ps.setInt(1, id_r);
			ps.executeUpdate();
			
		}catch(SQLException e)
		{
			throw new DAOException("ERROR: Falaha na operação", e);
		}
		finally
		{
			try
			{
				if(con != null)
					con.close();
			}catch(SQLException e)
			{
				throw new DAOException("ERROR: Não foi possível fechar a conexão", e);
			}
		}
	}
	
	public Reserva find(int id)
	{
		
	}
	
	public Reserva map(ResultSet rs) throws SQLException
	{
		Reserva
	}
}










