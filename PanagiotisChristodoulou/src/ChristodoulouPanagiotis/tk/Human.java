package ChristodoulouPanagiotis.tk;

import java.util.Scanner;

/**
 * @author npapak01 & pchris19
 * age: 0- 14 :A 
 *      15-29 B
 *      30-44 C
 *      45-64 D
 *      65 +  E
 *gender:
 *      Man M
 *      Woman:W 
 * O anthrwpos apoteleitai apo to onoma,an exei anwsia,an exei kinhthei,to ilikiako group tu, to filo tu, to prohgemno point[keli pu htan
 * kai to patient dhladh an einai asthenhs(sxetikes plhrofories me th astheneia tu.
 * 
 */
public class Human implements Cloneable {
	
	private String name;
    private boolean anwsia;
	
	private boolean moved=false;
	private char age;
	private char gender;
	private Patient patient;
	private Point previous=null;
	
	
	/**
	 * O kataskevastis arxikopoih ta pedia stis times pou dexete ws parametrous.
	 * 
	 * @param s
	 * @param anwsia
	 * @param sick
	 * @param a
	 * @param b
	 */
	public Human(String s, boolean anwsia, boolean sick, char a,char b) {
		name=s;
		this.patient=new Patient(sick);
		this.anwsia=anwsia;
		age =a;
		gender=b;
		
	}
	/**
	 * O kataskevastis arxikopoih ta pedia stis times pou dexete ws parametrous.
	 * 
	 * @param s
	 * @param anwsia
	 * @param p
	 * @param a
	 * @param b
	 */
	public Human(String s, boolean anwsia, Patient p, char a,char b) {
		name=s;
		this.patient=p;
		this.anwsia=anwsia;
		age =a;
		gender=b;
		
	}
	/**
	 * epistrefei to prohgumeno point pu htan o anthrwpos.
	 * 
	 * @return
	 */
	public Point getPrevious() {
		return previous;
	}
	/**
	 * Epistrefei to ilikiako tu group.
	 * 
	 * @return
	 */
	public char getAge() {
		return age;
	}
	/**
	 * Epistrefei to filo tu.
	 * 
	 * @return
	 */
	public char getGender() {
		return gender;
	}
	/**
	 * meta pu xeperasei ton io ton kanei igih kai exei anwsia.
	 * 
	 */
	public void setHealthy() {
		anwsia=true;
		patient.setHealthy();
	}
	/**
	 * Afth h methodos dimiourgei ena antigrafo tou anthropou.
	 * 
	 * @return Object(upscaled human)
	 */
	public Object Clone() {
		
		 Human h= new Human(this.name,this.anwsia,this.patient,this.age,this.gender);
	   
	     return h;
	}
	
	/**
	 * Afth h methodos epistrefei to pedio moved.
	 * 
	 * To pedio moved parousiazei ean o anthropos exei metakinithei
	 * 
	 * @return boolean
	 */
	public boolean getMoved() {
		return moved;
	}
	
	/**
	 * Afth h methodos thetei tin timi tou pediou moved stin timi pou dexthike ws parametro.
	 *
	 * @param boolean a
	 */
	public void setMoved(boolean a) {
		moved=a;
	}
	
	
	
	
	/**
	 * Afth h methodos epistrefei to onoma tou anthropou.
	 * 
	 * @return String 
	 */
	public String getName() {
		return name;
	}
	
	
	/**
	 * Afth h methodos epistrefei to pedio anwsia.
	 * 
	 * Ean o anthropos exei anwsia tote epistrefei true alios epistrefei false
	 * 
	 * @return boolean
	 */
	public boolean getAnwsia() {
		return anwsia;
	}
	
	/**
	 * Afth h methodos epistrefei to pedio sick.
	 * 
	 * Ean o anthropos einai arwstos tote epistrefei true alios epistrefei false
	 * 
	 * @return boolean
	 */
	public boolean getSick() {
		return patient.getSick();
	}
	
	/**
	 * Afth h methodos thetei ton anthropo ws arwsto.
	 * 
	 * H methodos elenxei ean o anthropos exei anwsia etsi wsta na min orisei ws arwsto ena anthropo pou exei anwsia
	 */
	public void setSick() {
		if(!anwsia)
		   patient.setSick();
	}
	public void setAnwsia() {
		anwsia=true;
	}
	
	/**
	 * H methodos epistrefei ena string me tis times twn pedion sick, anwsia, name tou anthropou.
	 * 
	 * @return String
	 */
	public String toString() {
		return " "+patient.getSick()+" "+anwsia+" "+name;
	}
	/**
	 * epistrefei to pedio patient.
	 * 
	 * @return
	 */
	public Patient getPatient() {
		return patient;
	}
	/**
	 * vazei to point sto opoio vriskotan prin.
	 * 
	 * @param a
	 */
	public void setPrevious(Point a) {
		previous=a;
		
		
	}
	
	
	
	
	
	
}
