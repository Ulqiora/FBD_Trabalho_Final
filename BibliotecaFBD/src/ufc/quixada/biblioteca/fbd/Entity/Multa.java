package ufc.quixada.biblioteca.fbd.Entity;

public class Multa 
{
	
	private Emprestimo emp;
	private int id;
	private Double valor;

	public Multa(Emprestimo emp, Double valor) 
	{
		super();
		this.emp = emp;
		this.valor = valor;
	}
	
	public Multa()
	{
		this.emp = new Emprestimo();
	}
	
	public Emprestimo getEmp() {
		return emp;
	}

	public void setEmp(Emprestimo emp) {
		this.emp = emp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
}
