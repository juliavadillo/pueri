package model;

public enum Sexo {
	MASCULINO(1), FEMININO(2);
	public int codigo;

	private Sexo(int codigo) {
		this.codigo = codigo;
	}
}
