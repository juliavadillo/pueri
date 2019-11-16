package model;

public enum TipoParto {
	 CESAREA(1), FORCEPS(2), NORMAL(3);
	public int codigo;

	private TipoParto(int codigo) {
		this.codigo = codigo;
	}
	
	public String getLabel() {
	    switch (this) {
	        case NORMAL:
	            return "Normal";
	        case CESAREA:
	            return "Cesárea";
	        case FORCEPS:
	        	return "Fórceps";

	    }
	    return "NONE";
	}
	
	@Override
	public String toString() {
	    return getLabel();
	}
	
	
}
