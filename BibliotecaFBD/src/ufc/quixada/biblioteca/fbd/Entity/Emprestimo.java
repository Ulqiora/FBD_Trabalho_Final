package ufc.quixada.biblioteca.fbd.Entity;


import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Emprestimo
{
	
	private int id;
	private Usuario user;
	private Exemplar exemp;
	private Calendar dataDev;
	private Calendar dataLimit;
	private Calendar emprestimo;

	public Emprestimo(Usuario user, Exemplar exemp, Calendar dataDev, Calendar dataLimit, Calendar emprestimo) 
	{
		this.user = user;
		this.exemp = exemp;
		this.dataDev = dataDev;
		this.dataLimit = dataLimit;
		this.emprestimo = emprestimo;
	}
	
	public Emprestimo() 
	{
		this.user = new Usuario();
		this.exemp = new Exemplar();
		this.dataDev = Calendar.getInstance();
		this.dataLimit = Calendar.getInstance();;
		this.emprestimo = Calendar.getInstance();;
	}
	
	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public Usuario getUser() 
	{
		return user;
	}

	public void setUser(Usuario user) 
	{
		this.user = user;
	}

	public Exemplar getExemp() 
	{
		return exemp;
	}

	public void setExemp(Exemplar exemp) 
	{
		this.exemp = exemp;
	}

	public Calendar getDataDev() 
	{
		return dataDev;
	}

	public void setDataDev(Calendar dataDev) 
	{
		this.dataDev = dataDev;
	}

	public Calendar getDataLimit() 
	{
		return dataLimit;
	}

	public void setDataLimit(Calendar dataLimit) 
	{
		this.dataLimit = dataLimit;
	}

	public Calendar getEmprestimo() 
	{
		return emprestimo;
	}

	public void setEmprestimo(Calendar emprestimo) 
	{
		this.emprestimo = emprestimo;
	}
}









