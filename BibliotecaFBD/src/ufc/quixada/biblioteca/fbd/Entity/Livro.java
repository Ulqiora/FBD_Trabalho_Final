package ufc.quixada.biblioteca.fbd.Entity;

public class Livro 
{

	private String isbn;
	private String titulo;
	private int anoPublicacao;
	private int idLivro;
	private int qtd;
	private Editora ed;
	private Autor autor;

	public Livro(String isbn, String titulo, int anoPublicacao, int qtd, Editora ed, Autor autor) 
	{
		this.isbn = isbn;
		this.titulo = titulo;
		this.anoPublicacao = anoPublicacao;
		this.qtd = qtd;
		this.ed = ed;
		this.autor = autor;
	}
	
	public Livro() 
	{
		this.ed = new Editora();
		this.autor = new Autor();
	}
	

	public String getIsbn() 
	{
		return isbn;
	}


	public void setIsbn(String isbn) 
	{
		this.isbn = isbn;
	}


	public String getTitulo() 
	{
		return titulo;
	}


	public void setTitulo(String titulo) 
	{
		this.titulo = titulo;
	}


	public int getAnoPublicacao() 
	{
		return anoPublicacao;
	}


	public void setAnoPublicacao(int anoPublicacao) {
		
		this.anoPublicacao = anoPublicacao;
	}


	public int getIdLivro() 
	{
		return idLivro;
	}


	public void setIdLivro(int idLivro) 
	{
		this.idLivro = idLivro;
	}


	public int getQtd() 
	{
		return qtd;
	}


	public void setQtd(int qtd) 
	{
		this.qtd = qtd;
	}


	public Editora getEd() 
	{
		return ed;
	}


	public void setEd(Editora ed) 
	{
		this.ed = ed;
	}


	public Autor getAutor() 
	{
		return autor;
	}


	public void setAutor(Autor autor) 
	{
		this.autor = autor;
	}
}
