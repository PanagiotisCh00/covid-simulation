package ChristodoulouPanagiotis.tk;

import java.util.ArrayList;
/**
 * Sinarthsh pu antiproswpevei th zwnh karantinas.
 * Apoteleitai apo ta posa atoma mporei na exei kai mia lista me tus anthrwpus pu exei.
 * 
 * @author pchris19
 *
 */
public class QuarantineZone {
	private int capacity;
	private ArrayList<Human> peopleList;
	
	
	public QuarantineZone(int cap) {
		capacity=cap;
		peopleList=new ArrayList(capacity);
	}
	/**
	 * Epistrefei ta atoma pou mporun na einai se karantina.
	 * 
	 * @return
	 */
	public int getCapacity() {
		return capacity;
	}
	/**
	 * epistrefei posa atoma exume sth zonh karantinas
	 * @return
	 */
	public int getNosuntes() {
		return peopleList.size();
		
	}
	/**
	 * Prosthetei atomo sth karantina.
	 * 
	 * @param h
	 */
	public void addPerson(Human h) {
		peopleList.add(h);
	}
	
	

}
