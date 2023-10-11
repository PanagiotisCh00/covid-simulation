package ChristodoulouPanagiotis.tk;
/**
 * Exception h opeia egeirete otan to kapoios arithmos einai arnhtiko h einai kai isos me 0
 * @author pchris19,npapak01
 *
 */

public class NegativeNumberException extends Exception{
	/**
	 * sO default kataskevastis pou kalei ton super me to prokathorismeno minima.
	 */
	public NegativeNumberException() {
		super("O arithmos prepei na einai thetikos ");
	}
	/**
	 * O kataskevasteis pou kalei ton super me to minima pou dexthke ws parametro.
	 * @param s
	 */
	public NegativeNumberException(String s) {
		super(s);
	}

	
}
