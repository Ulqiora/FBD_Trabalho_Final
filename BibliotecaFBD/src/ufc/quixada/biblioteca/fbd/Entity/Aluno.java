package ufc.quixada.biblioteca.fbd.Entity;

import java.util.ArrayList;

public class Aluno extends Usuario
{

	private String matricula;
	private String curso;
	private int id_al;

	public Aluno(String nome, String cpf, String rg, Endereco endereco, String matricula, String curso, ArrayList<Integer> tel, String email) 
	{
		super(nome, cpf, rg, endereco, tel, email);
		this.matricula = matricula;
		this.curso = curso;
	}
	
	public Aluno() 
	{
		super();
	}
	
	public int getId_al() {
		return id_al;
	}

	public void setId_al(int id_al) {
		this.id_al = id_al;
	}
		
	public String getMatricula()
	{
		return matricula;
	}
	
	public void setMatricula(String matricula) 
	{
		this.matricula = matricula;
	}
	
	public String getCurso() 
	{
		return curso;
	}
	
	public void setCurso(String curso) 
	{
		this.curso = curso;
	}
	
}
