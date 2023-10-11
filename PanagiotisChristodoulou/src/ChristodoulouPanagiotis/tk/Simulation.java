package ChristodoulouPanagiotis.tk;

import java.util.Scanner;
/**
 * Se avth th klash dexomaste dedomena apo ton xrhsth rixnwntas katalalhla exceptions me vash tus analoiwtus periorismus mas
 * @author pchris19,napapk01
 *
 */
public class Simulation {
	
	/**
	 * H methodos dexete dedomena apo ton xristh gia tin arxikopoihsi tou pediou.
	 * 
	 * H methodos dexete to megethos tou pediou , ton sinoliko arithmo atomwn, ton arithmo molismenwn me tin epilogi na min dwsei kai dinete 
	 * aftomata o arithmos 1 , ton arithmo twn atomwn me anosia. Oloi oi arithmoi elexonte an pliroun ta kritiria pou thesame stous analoiwtous
	 * periorismous. Akolouthos dimiourgeite to pedio kai epistrefete
	 * 
	 * @param inf
	 * @param capH   einai  to capacity tu nosokomeiu
	 * @param capQ einai to capacity ths karantinas
	 * @return Field
	 */
	public static Field makeTheField(double inf,int capH,int capQ) {
		Scanner keyboard=new Scanner(System.in);
		
        String s,p,a,b,c,d,name;
	    Field f1=new Field(0,0);
		boolean f=true;
		do {
		   try {
			   System.out.println();
			   f=true;
			   System.out.println("Dwse to onoma ths xwras");
			   name=keyboard.next();
			   while(ExtendedField.checkName(name)) {
				   System.out.println("Iparxei xwra me avto to onoma, dwse neo onoma ");
				   name=keyboard.next();
				   
			   }
			   System.out.println("Dwse to megethos mhkkos ths xwras");
			   s=keyboard.next();
			   System.out.println("Dwse to megethos platos  ths xwras");
			   p=keyboard.next();
			   System.out.println("Dwse arithmo atomwn");
			   a=keyboard.next(); 
			   System.out.println("Dwse arithmo molismenwn atomwn/ an den theleis na dwseis dwse -");
			   b=keyboard.next();
			  
			   
				   
			   int k1=Integer.parseInt(s);//mhkos
			   int k6=Integer.parseInt(p);//platos
			   int k2=Integer.parseInt(a);//arithmos atomwn
			 
			   
			   if(k1<3 || k6<3) {
				   System.out.println("To megethos tou pediou prepei na einai megalitero h iso me to 3x3");
				   f=false;
			   }else {
				   f1=new Field(k1,k6);
			  
			   
			   
				   if(b.equals("-")) 
					   f1.initialize(k2, inf,capH,capQ,name);
			   
				   else {
					   int k3=Integer.parseInt(b);
					   f1.initialize(k2, inf,capH,capQ,name);
				   }
			  }
			   
			   
		   }catch(NumberFormatException e) {
		    	System.out.println("Na dinei arithmus");
		    	f=false;
		    }
		  
		
	}while(!f);
		
	
		return f1;
		
}
}
