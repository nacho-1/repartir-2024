package ar.com.grupoesfera.repartir.exceptions;

public class TotalNegativoException extends RuntimeException {
	public TotalNegativoException() {
		super("Total no puede ser negativo");
	}
}
