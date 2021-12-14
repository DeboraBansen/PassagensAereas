package exceptions;

public class SelectException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public SelectException() {
		
	}
	public SelectException(String mensagem) {
		super(mensagem);
	}
}
