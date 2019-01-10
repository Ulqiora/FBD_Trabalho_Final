package ufc.quixada.biblioteca.fbd.Entity;

public class Endereco 
{

	private int id;
	private String rua;
	private String bairro;
	private String complemento;
	private int numero;
	private int idUser;

	public Endereco(String rua, String bairro, String complemento, int numero) 
	{
		this.rua = rua;
		this.bairro = bairro;
		this.complemento = complemento;
		this.numero = numero;
	}
	
	public Endereco() {}
	
	
	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	
	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public String getRua()
	{
		return rua;
	}

	public void setRua(String rua) 
	{
		this.rua = rua;
	}

	public String getBairro() 
	{
		return bairro;
	}

	public void setBairro(String bairro) 
	{
		this.bairro = bairro;
	}

	public String getComplemento() 
	{
		return complemento;
	}

	public void setComplemento(String complemento) 
	{
		this.complemento = complemento;
	}

	public int getNumero()
	{
		return numero;
	}

	public void setNumero(int numero) 
	{
		this.numero = numero;
	}
	
}
