package model;

import javax.persistence.AttributeConverter;

public class PartoEnumConverter implements AttributeConverter<TipoParto, Byte> {

	@Override
	public Byte convertToDatabaseColumn(TipoParto attribute) {
		switch (attribute) {
		case NORMAL:
			return 0;
		case CESAREA:
			return 1;
		default:
			throw new IllegalArgumentException("Unknown" + attribute);
		}
	}

	@Override
	public TipoParto convertToEntityAttribute(Byte dbData) {
		switch (dbData) {
		case 0:
			return TipoParto.NORMAL;
		case 1:
			return TipoParto.CESAREA;

		default:
			throw new IllegalArgumentException("Unknown" + dbData);
		}
	}

}
