package ChristodoulouPanagiotis.tk;
/**
 * Avth h klash antiprosopevei kapoio shmeio-point dhladh kapoio shmeio sto xwro(pinaka) 
 * poy apoteleitai apo to ipsos sto opoio vriskete(dhladh grammh tu ppinaka) to Y kai to mhkos sto opoio vriskete (dhladh arithmo stlhs sto pinaka) to X.
 * 
 * @author pchris19,npapak01
 *
 */
public class Point {
	
	private int x;
	private int y;
	/**
	 * Avto einai o kataskevasths pu dexete dio akereus kai dhmiurga to point.
	 * 
	 * @param x0 akereos pou dhlwnei to x tu point
	 * @param y0 akereos pu dhlwnei to y tu point
	 */
	public Point(int x0, int y0) {
		x=x0;
		y=y0;
	}
	/**
	 * Getter method pu epistrefei to x tu shmeiu.
	 * 
	 * @return epistrefei to x (einai akereo)
	 */
	public int getX() {
		return x;
	}
	/**
	 * Getter method pu epistrefei to y tu shmeiu.
	 * 
	 * @return epistrefei to y (einai akereo)
	 */
	public int getY() {
		return y;
	}
	/**
	 * Thetei neo x gia to shmeio mu.
	 * 
	 * @param newX dexete akereo me to neo x tu shmeiu
	 */
	public void setX(int newX) {
		x=newX;
	}
	/**
	 * Thetei neo y gia to shmeio mu.
	 * 
	 * @param newX dexete akereo me to neo y tu shmeiu
	 */
	public void setY(int newY) {
		y=newY;
	}
	/**
	 * Sinarthsh equals dexete dio point pu an einai ta idia tote epistrefei true/false analoga.
	 * 
	 * @param p
	 * @param p2
	 * @return
	 */
	public static boolean equals(Object p,Object p2) {
		if(p==null || p2==null)
			return false;
		else if(p.getClass()!=p2.getClass())
			return false;
		Point c=(Point)p;
		Point c2=(Point)p2;
		if(c2.x==c.x && c2.y== c.y)
			return true;
		return false;
					
	}
}
