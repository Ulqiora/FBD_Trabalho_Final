package ufc.quixada.biblioteca.fbd.Entity;

import java.util.ArrayList;

public class Professor extends Usuario 
{
	private int cod;
	private int id_p;

	public Professor(String nome, String cpf, String rg, Endereco endereco, int cod, ArrayList<Integer> tel , String email) 
	{
		super(nome, cpf, rg, endereco, tel, email);
		this.cod = cod;
	}

	public Professor() 
	{
		super();
	}
	
	public int getId_p() {
		return id_p;
	}

	public void setId_p(int id_p) {
		this.id_p = id_p;
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
