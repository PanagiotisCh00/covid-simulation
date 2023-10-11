package ChristodoulouPanagiotis.tk;

/**
 * @author npapak01 & pchris19
 * 
 * Exception h opeia egeirete otan to plithos twn anthropwn xeperna to emvadon tou xwrou. Klironomei apo tin class Exception
 *
 */
public class OutOfAreaException extends Exception {
	
	/**
	 * O default kataskevastis pou kalei ton super me to prokathorismeno minima.
	 */
	public OutOfAreaException() {
		super("The number of People are more than the Area of the space");
	}
	
	/**
	 * O kataskevasteis pou kalei ton super me to minima pou dexthke ws parametro.
	 * @param message
	 */
	public OutOfAreaException(String message) {
		super(message);
	}

}
