package ufc.quixada.biblioteca.fbd.Service;

import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import ufc.quixada.biblioteca.fbd.Entity.Livro;
import ufc.quixada.biblioteca.fbd.Entity.Editora;
import ufc.quixada.biblioteca.fbd.Service.EditoraService;
import java.sql.SQLException;
import ufc.quixada.biblioteca.fbd.Service.EditoraService;
import ufc.quixada.biblioteca.fbd.Service.AutorService;

public class LivroService 
{
	public void save(Livro l)
	{
		Connection con = null;
		
		try
		{
			con = ConnectionFactory.getConnection();
			con.setAutoCommit(false);
			
			String save = "insert into livro(isbn, titulo, id_editora, ano_publicacao, qtd_exemplares) values(?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(save);
			
			ps.setString(1, l.getIsbn());
			ps.setString(2, l.getTitulo());
			ps.setInt(3, l.getEd().getId());
			ps.setInt(4, l.getAnoPublicacao());
			ps.setInt(5, l.getQtd());
			
			ps.executeUpdate();
			con.commit();
		}catch(SQLException e)
		{
			try
			{
				con.rollback();
			}catch(SQLException e1)
			{
				throw new DAOException("ERROR: Operação não concluída", e1);
			}
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
	}
	
	
	public void update(Livro l)
	{
		Connection con = null;
		
		try
		{
			con = ConnectionFactory.getConnection();
			con.setAutoCommit(false);
			
			String update = "update livro set isbn = ?, titulo = ?, ano_publicacao = ?, qtd_exemplares = ?, id_editora = ?"
					+ "id_l = ? where isbn = ?";
			PreparedStatement ps = con.prepareStatement(update);
			ps.setString(1, l.getIsbn());
			ps.setString(2, l.getTitulo());
			ps.setInt(3, l.getAnoPublicacao());
			ps.setInt(4, l.getQtd());
			ps.setInt(5, l.getEd().getId());
			ps.setInt(6, l.getIdLivro());
			
			ps.executeUpdate();
			con.commit();
		}catch(SQLException e)
		{
			try
			{
				con.rollback();
			}catch(SQLException e1)
			{
				throw new DAOException("ERROR: Operação não concluída", e1);
			}
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
		
	}
	
	public void delete(int id)
	{
		Connection con = null;
		try
		{
			con = ConnectionFactory.getConnection();
			con.setAutoCommit(false);
			
			String del = "delete from livro where id_l = ?";
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
				throw new DAOException("ERROR: Operação não concluída", e1);
			}
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
	}
	
	public Livro findIsbn(String isbn)
	{
		Connection con = null;
		Livro l = null;
		int id_e;
		EditoraService es = new EditoraService();
		
		try
		{
			con = ConnectionFactory.getConnection();
			String find = "select id_l, isbn, ano_publicacao, qtd_exemplares, titulo, id_editora from livro where isbn = ?";
			//String fEditora = "select id_editora from livro where isbn = ?";
			
			PreparedStatement ps = con.prepareStatement(find);
			//PreparedStatement ps1 = con.prepareStatement(fEditora);
			
			ps.setString(1, isbn);
			//ps1.setString(1, isbn);			
			
			ResultSet rs = ps.executeQuery();
			if(rs.next())
				l = map(rs);
			
			id_e = rs.getInt("id_editora");
			l.setEd(es.find(id_e));
			
		}catch(SQLException e)
		{
			throw new DAOException("ERROR: Operação não concluída", e);
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
		
		return l;
	}
	
	public Livro findTitle(String title)
	{
		Connection con = null;
		Livro l = null;
		int id_e;
		EditoraService es = new EditoraService();
		
		try
		{
			con = ConnectionFactory.getConnection();
			String find = "select id_l, isbn, ano_publicacao, qtd_exemplares, titulo, id_editora from livro where titulo = ?";
			//String fEditora = "select id_editora from livro where isbn = ?";
			
			PreparedStatement ps = con.prepareStatement(find);
			//PreparedStatement ps1 = con.prepareStatement(fEditora);
			
			ps.setString(1, title);
			//ps1.setString(1, isbn);			
			
			ResultSet rs = ps.executeQuery();
			if(rs.next())
				l = map(rs);
			
			id_e = rs.getInt("id_editora");
			l.setEd(es.find(id_e));
			
		}catch(SQLException e)
		{
			throw new DAOException("ERROR: Operação não concluída", e);
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
		
		return l;
	}
	
	public Livro map(ResultSet rs) throws SQLException
	{
		Livro l1 = new Livro();
		l1.setAnoPublicacao(rs.getInt("ano_publicacao"));
		l1.setIdLivro(rs.getInt("id_l"));
		l1.setTitulo(rs.getString("titulo"));
		l1.setQtd(rs.getInt("qtd_exemplares"));
		l1.setIsbn(rs.getString("isbn"));
		
		EditoraService ed = new EditoraService();
		AutorService es = new AutorService();
		l1.setEd( ed.find(rs.getInt("id_editora") ));
		
		return l1;
	}
}








