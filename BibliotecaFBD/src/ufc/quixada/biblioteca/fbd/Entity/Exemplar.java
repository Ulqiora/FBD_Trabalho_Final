package ufc.quixada.biblioteca.fbd.Entity;

public class Exemplar extends Livro
{
	
	private int id;
	private int numtombo;
	
	public Exemplar(String isbn, String titulo, int anoPublicacao, int qtd, Editora ed, Autor autor
			, int numtombo) 
	{
		super(isbn, titulo, anoPublicacao, qtd, ed, autor);
		this.numtombo = numtombo;
	}

	
	public Exemplar() { super(); }
	
	public int getId() 
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getNumtombo() 
	{
		return numtombo;
	}

	public void setNumtombo(int numtombo) 
	{
		this.numtombo = numtombo;
	}

	
}
