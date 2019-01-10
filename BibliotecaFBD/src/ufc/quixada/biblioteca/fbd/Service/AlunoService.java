package ufc.quixada.biblioteca.fbd.Service;

import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import ufc.quixada.biblioteca.fbd.Entity.Aluno;
import ufc.quixada.biblioteca.fbd.Service.EnderecoService;
import java.sql.SQLException;

public class AlunoService 
{
	public void save(Aluno a)
	{
		Connection con = null;
		
		try
		{
			con = ConnectionFactory.getConnection();
			con.setAutoCommit(false);
			
			String insert = "insert into aluno (matricula, curso) values(?,?)";
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setString(1, a.getMatricula());
			ps.setString(2, a.getCurso());
			
			ps.executeUpdate();
			con.commit();
		}catch(SQLException e)
		{
			try
			{
				con.rollback();
			}catch(SQLException e1)
			{
				throw new DAOException("Error: Não foi possivel concluir a operação", e1);
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
	
	
	public void update(Aluno a)
	{
		Connection con = null;
		
		try
		{
			con = ConnectionFactory.getConnection();
			con.setAutoCommit(false);
			
			String update = "update aluno set matricula = ?, curso = ? where id = ?";
			PreparedStatement ps = con.prepareStatement(update);
			ps.setString(1, a.getMatricula());
			ps.setString(2, a.getCurso());
			ps.setInt(3, a.getId());
			
			ps.executeUpdate();
			con.commit();
		}catch(SQLException e)
		{
			try
			{
				con.rollback();
			}catch(SQLException e1)
			{
				throw new DAOException("Error: Não foi possivel concluir a operação", e1);
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
	

	public void delete(String matricula)
	{
		Connection con = null;
		try
		{
			con = ConnectionFactory.getConnection();
			con.setAutoCommit(false);
			String del = "delete from aluno where matricula = ?";
			PreparedStatement ps = con.prepareStatement(del);
			
			ps.setString(1, matricula);
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
				throw new DAOException("ERROR: não foi possível fechar a conexão", e);
			}
		}
	}
	
	public Aluno find(String mat)
	{
		Connection con = null;
		Aluno a = null;
		try
		{
			con = ConnectionFactory.getConnection();
			String find = "select id_al, matricula, curso, id_usuario from aluno where matricula = ?";
			PreparedStatement ps = con.prepareStatement(find);
			
			ps.setString(1, mat);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
				a = map(rs);
		}catch(SQLException e)
		{
			throw new DAOException("ERROR: Falaha na operação", e);
		}finally
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
		
		return a;
	}
	
	public Aluno map(ResultSet rs) throws SQLException
	{
		Aluno a1 = new Aluno();
		a1.setMatricula(rs.getString("matricula"));
		a1.setCurso(rs.getString("curso"));
		a1.setId(rs.getInt("id_usuario"));
		a1.setId_al(rs.getInt("id_al"));
		
		return a1;
	}
}









