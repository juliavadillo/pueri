package model;

import javax.persistence.AttributeConverter;

public class SexoEnumConverter implements AttributeConverter<Sexo, Byte>{

	@Override
	public Byte convertToDatabaseColumn(Sexo attribute) {
		switch (attribute) {
        case MASCULINO:
            return 0;
        case FEMININO:
            return 1;
        default:
            throw new IllegalArgumentException("Unknown" + attribute);
    }
	}

	@Override
	public Sexo convertToEntityAttribute(Byte dbData) {
		switch (dbData) {
        case 0 :
            return Sexo.MASCULINO;
        case 1:
            return Sexo.FEMININO;

        default:
            throw new IllegalArgumentException("Unknown" + dbData);
    }
	}

}
