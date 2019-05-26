package model;

public enum TipoParto {
	NORMAL(1), CESAREA(2);
	public int codigo;

	private TipoParto(int codigo) {
		this.codigo = codigo;
	}
}
