package ufc.quixada.biblioteca.fbd.Entity;

public class Autor 
{
	private int id;
	private String nome;
	private String cod_d;
	

	public Autor(String nome, String cod_d) 
	{
		this.nome = nome;
		this.cod_d = cod_d;
	}
	public Autor() {}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCod_d() {
		return cod_d;
	}

	public void setCod_d(String cod_d) {
		this.cod_d = cod_d;
	}
	
}
