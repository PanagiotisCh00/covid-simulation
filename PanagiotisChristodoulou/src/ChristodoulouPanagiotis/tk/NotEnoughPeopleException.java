package ChristodoulouPanagiotis.tk;
/**
 * Avto to exception einai gia otan o arithmos twn anthrwpwn einai pio ligos apoti to athroisma twn anthrwpwn me anwsia kai mlolismenwn anthrwpwn.
 * 
 * @author pchris19,npapak01
 *
 */
    public class NotEnoughPeopleException extends Exception{
	    /**
	     * o default constructor tu exception pu metaferei to analogo minima.
	     * 
	    */
	    public NotEnoughPeopleException() {
		    super("O arithmos twn anthrwown einai ligotero apo to athroisma tnw molismenwn kai twn anthrwpwn me anwsia");
	    }
	    /**
	     * o constructor stu opoiu dinume parametro kapoia simvolosira me analogo minima.
	     * 
	     * @param s -simvolosira
	     */
	     public NotEnoughPeopleException(String s) {
		    super(s);
	   }

}
