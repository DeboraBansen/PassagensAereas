package exceptions;

public class UpdateException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public UpdateException() {
		
	}
	public UpdateException(String mensagem) {
		super(mensagem);
	}
}
