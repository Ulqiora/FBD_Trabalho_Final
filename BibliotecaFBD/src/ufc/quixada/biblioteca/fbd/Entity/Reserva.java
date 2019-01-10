package ufc.quixada.biblioteca.fbd.Entity;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Reserva 
{
	private int id;
	private Usuario user;
	private Livro title;
	private Calendar dt_reserva;
	private Calendar dt_lib;
	

	public Reserva(Usuario user, Livro title, Calendar dt_reserva, Calendar dt_lib) 
	{
		super();
		this.user = user;
		this.title = title;
		this.dt_reserva = dt_reserva;
		this.dt_lib = dt_lib;
	}
	
	public Reserva()
	{
		this.user = new Usuario();
		this.title = new Livro();
		this.dt_lib = Calendar.getInstance();
		this.dt_reserva = Calendar.getInstance();
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

	public Livro getTitle() 
	{
		return title;
	}

	public void setTitle(Livro title) 
	{
		this.title = title;
	}

	public Calendar getDt_reserva() 
	{
		return dt_reserva;
	}

	public void setDt_reserva(Calendar dt_reserva) 
	{
		this.dt_reserva = dt_reserva;
	}

	public Calendar getDt_lib() 
	{
		return dt_lib;
	}

	public void setDt_lib(Calendar dt_lib) 
	
	{
		this.dt_lib = dt_lib;
	}
}
