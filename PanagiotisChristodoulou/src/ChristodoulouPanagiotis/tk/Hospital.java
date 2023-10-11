package ChristodoulouPanagiotis.tk;

import java.util.ArrayList;
/**
 * Avth h sinarthsh anaparista ena nosokomeio.
 * Apoteleitai apo to megisto arithhmo atomwn pou mporei naxei,kai th lista me tus arrwstus pu einia mesa sto nosokomeio.
 * 
 * @author pchris19
 *
 */
public class Hospital {
	private int capacity;
	private ArrayList<Human> peopleList;
	
	public Hospital(int c) {
		capacity =c;
		peopleList=new ArrayList(capacity);
	}
	/**
	 * epistrefei to capacity tu hospital.
	 * 
	 * @return
	 */
	public int getCapacity() {
		return capacity;
	}
	/**
	 * epistrefei posa atoma exume sto hospital
	 * @return
	 */
	public int getNosuntes() {
		return peopleList.size();
		
	}
	/**
	 * Prosthetei ena atomo sto nosokomeio.
	 * 
	 * @param h
	 */
	public void addPerson(Human h) {
		peopleList.add(h);
	}
	/**
	 * Afairw kapoio anthrwpo apo sigkekrimenh thesh
	 * 
	 * @param i
	 */
	public void removePerson(int i) {
		
		peopleList.remove(peopleList.get(i));
	}
	/**
	 * Epistrefei arrayList me olus tus anthrwpus pu einia sto nosokomeio.
	 * 
	 * @return
	 */
	public ArrayList getPeople() {
		return peopleList;
	}
	

}
