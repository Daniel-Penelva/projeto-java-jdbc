package model;

public class Telefone {

	private Long id;
	private String numero;
	private String tipo;
	private Long fk_pessoa;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Long getFk_pessoa() {
		return fk_pessoa;
	}

	public void setFk_pessoa(Long fk_pessoa) {
		this.fk_pessoa = fk_pessoa;
	}

	@Override
	public String toString() {
		return "Telefone [id=" + id + ", numero=" + numero + ", tipo=" + tipo + ", fk_pessoa=" + fk_pessoa + "]";
	}

}
