package database;

public enum Col {

	BASE,
	PLUS1,
	PLUS2,
	PLUS3,
	MINUS1,
	MINUS2,
	MINUS3;

	public static Col getFromInt(int value) {

		switch (value) {
		case 0:
			return BASE;
		case 1:
			return PLUS1;
		case 2:
			return PLUS2;
		case 3:
			return PLUS3;
		case -1:
			return MINUS1;
		case -2:
			return MINUS2;
		case -3:
			return MINUS3;
		default:
			return null;

		}

	}

}
