package ChristodoulouPanagiotis.tk;

/**
 * @author npapak01 &&  pchrist19
 *
 * To Sinoro einai to antikeimeno apo to opoio mporw na metavo se allo pedio.
 */
public class Sinoro {
	private int from;
	private int to;
	private Point link;
	

	/**
	 * O kataskevastis tou Sinorou.
	 * O kataskevastis dexete ton arithmo tou pediou pou vriskete kai ton arithmo tou pediou me to opoi sindeete kathos kai ena simio
	 * to opoi antiprosopevei tis sintetagmenes me to antistixo sinoro sto pedio pou sindei
	 * 
	 * @param f
	 * @param t
	 * @param a
	 */
	public Sinoro(int f,int t, Point a) {
		from=f;
		to=t;
		link=a;
	}
	
	/**
	 * H methodos epistrefei ton arithmo tou pediou to opoio sindei to sinoro.
	 * @return int
	 */
	public int getTo() {
		return to;
	}
	
	/**
	 * H methodos epistrefei to simeio sto opoio antistixei to sinoro sto pedio pou enwnei.
	 * @return Point
	 */
	public Point getLink() {
		return link;
	}
	
	
	

}
