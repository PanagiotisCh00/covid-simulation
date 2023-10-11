package ChristodoulouPanagiotis.tk;
/**
 * Object pu ekprosswpei ta mesa amzikhs anaforas.

 * Apoteleitai apo to megethos tu mmm,apo poia xwra einia,se poia xwra paei,mia lista me tus anthrwpus pu exei,poses fores taxidevei mesa sth mera.
 * 
 */
import java.util.ArrayList;

public class MMM {
	private int capacity;
	private int from;
	private int to;
	private ArrayList<Human> peopleList;
	private int times;
	
	public MMM(int a,int b,int c,int t) {
		capacity=a;
		from=b;
		to=c;
		times=t;
		peopleList=new ArrayList(capacity);//arxika den exei anthrwpus to meso mazikhs metaforas
	}
	/**
	 * Epistrefei to arithmo atomwn pou forei to mmm.
	 * 
	 * @return
	 */
	public int getCapacity() {
		return capacity;
	}
	/**
	 * Epistrefei tis fores pou taxidevei sth mera.
	 * 
	 * @return
	 */
	public int getTimes() {
		return times;
	}
	/**
	 * epistrefei th xwra apo th opoia xekina.
	 * 
	 * @return
	 */
	public int getFrom() {
		return from;
	}
	/**
	 * epistrefei th xwra pou paei.
	 * 
	 * @return
	 */
	public int getTo() {
		return to;
	}
	/**
	 * prosthetei kapoio atomo sto mmm.
	 * 
	 * @param h
	 */
	public void addPeopleList(Human h) {
		peopleList.add(h);
	}
	/**
	 * Epistrefei to arithmo atomwn pou metaferei.
	 * 
	 * @return
	 */
	public int  getMetaferwmenus() {
	
		
		return peopleList.size();
	}
	/**
	 * epistrefei ena arrayList me ta atoma pou metaferei.
	 * 
	 * @return
	 */
	public ArrayList<Human> getPeople() {
		return peopleList;
	}
	/**
	 * Sinarthsh pou katharizei/ exafanizei olus tus anthrwpus apo to MMM.
	 * 
	 */
	public void removeAll() {
		peopleList=new ArrayList<Human>(capacity);
	}
	

}
