package ufc.quixada.biblioteca.fbd.Service;

public class DAOException extends RuntimeException
{
	public DAOException()
	{
		super();
	}
	
	public DAOException(String mensage, Throwable causa)
	{
		super(mensage, causa);
	}
	
	public DAOException(String mensage)
	{
		super(mensage);
	}
	
	public DAOException(Throwable causa)
	{
		super(causa);
	}
}
