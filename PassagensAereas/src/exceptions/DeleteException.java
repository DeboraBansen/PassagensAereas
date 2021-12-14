package exceptions;

public class DeleteException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public DeleteException() {
		
	}
	public DeleteException(String mensagem) {
		super(mensagem);
	}
}
