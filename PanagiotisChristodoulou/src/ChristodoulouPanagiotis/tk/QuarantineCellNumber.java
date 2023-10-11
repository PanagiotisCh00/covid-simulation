package ChristodoulouPanagiotis.tk;
/**
 * Klash gia na xerume pou akrivws einia h zwnh-keli karantinas.
 * 
 * @author pchris19
 *
 */
public class QuarantineCellNumber {
	Point point;
	QuarantineCellNumber(int x,int y){
		point =new Point(x,y);
	}
	/**
	 * Epistrefei to shmio pu einai h karantina.
	 * 
	 * @return
	 */
	public Point getPoint() {
		return point;
	}

}
