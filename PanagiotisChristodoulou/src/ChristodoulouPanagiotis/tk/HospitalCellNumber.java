package ChristodoulouPanagiotis.tk;
/**
 * Klash pou apoteleitai apo to shmeio sto opoio vriskete to nosokomeio.
 * 
 * @author pchris19
 *
 */
public class HospitalCellNumber {
	Point point;
	HospitalCellNumber(int x,int y){
		point =new Point(x,y);
	}
	/**
	 * Epistrefei to point pu einai to nosokomeio.
	 * 
	 * @return
	 */
	public Point getPoint() {
		return point;
	}

}
