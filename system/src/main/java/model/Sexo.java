package model;

public enum Sexo {
	 FEMININO(1), MASCULINO(2);
	public int codigo;

	private Sexo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getLabel() {
	    switch (this) {
	        case MASCULINO:
	            return "Masculino";
	        case FEMININO:
	            return "Feminino";

	    }
	    return "NONE";
	}
	@Override
	public String toString() {
	    return getLabel();
	}
}
