package ufc.quixada.biblioteca.fbd.Entity;

public class Editora 
{

	private int id;
	private String nome;
	private int cod;
	
	public Editora(String nome, int cod) 
	{
		this.nome = nome;
		this.cod = cod;
	}
	
	public Editora() {}
	
	
	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public String getNome() 
	{
		return nome;
	}

	public void setNome(String nome) 
	{
		this.nome = nome;
	}

	public int getCod() 
	{
		return cod;
	}

	public void setCod(int cod) 
	{
		this.cod = cod;
	}

}
