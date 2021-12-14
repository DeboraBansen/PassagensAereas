package exceptions;

public class InsertException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public InsertException() {
		
	}
	public InsertException(String mensagem) {
		super(mensagem);
	}
}
