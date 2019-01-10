package ufc.quixada.biblioteca.fbd.Entity;

import java.util.ArrayList;

public class Usuario 
{
	private int id;
	private String nome;
	private String cpf;
	private String rg;
	Endereco endereco;
	private ArrayList<Integer> telefone;
	private String email;
	
	public Usuario(String nome, String cpf, String rg, Endereco endereco, ArrayList<Integer> tel, String emails) 
	{
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.endereco = endereco;
		this.telefone = tel;
		this.email = emails;

	}
	
	public Usuario() 
	{
		this.endereco = new Endereco();
	}
	

	public ArrayList<Integer> getTelefone() {
		return telefone;
	}

	public void setTelefone(ArrayList<Integer> telefone) {
		this.telefone = telefone;
	}
	
	public void setTelefone(int n)
	{
		this.telefone.add(n);
	}
	
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

	public String getCpf() 
	{
		return cpf;
	}

	public void setCpf(String cpf) 
	{
		this.cpf = cpf;
	}

	public String getRg() 
	{
		return rg;
	}

	public void setRg(String rg) 
	{
		this.rg = rg;
	}

	public Endereco getEndereco() 
	{
		return endereco;
	}

	public void setEndereco(Endereco endereco) 
	{
		this.endereco = endereco;
	}
	
	
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getEmail()
	{
		return this.email;
	}
}
