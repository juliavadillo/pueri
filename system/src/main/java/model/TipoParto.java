package model;

public enum TipoParto {
	NORMAL(1), CESAREA(2);
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

	    }
	    return "NONE";
	}
	
	@Override
	public String toString() {
	    return getLabel();
	}
	
	
}
