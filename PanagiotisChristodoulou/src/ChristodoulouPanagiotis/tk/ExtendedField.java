package ChristodoulouPanagiotis.tk;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * Avto einai ena antikeimeno gia thn omadopoihsh twn diaforwn fields-xwrwn. Dhladh exw ena pinaka me fields(Me xwres), mia statikh metavlhth draw poy deixnei pia xwra
 * tha zwgrafisw me stdDraw kai to round pu deixnei se poio round vriskomai.
 * 
 * @author pchris19,npapak01
 *
 */
public class ExtendedField {
	
	private static int draw=0;
	private static ArrayList<Field> list;
	private static int round=0;
	private static int time=0;//antiproswpevei to xorno se lepta
	private ArrayList<MMM> mesa;
	
	
	
	/**
	 * Kataskevasths dexomai to megethos tu pinaka kai to infection san parametrus.Ousiastika Xrhsimopoiw th makeThefield gia na dhmiourghsw ta fields,
	 * kai se avth th methodo dexomai apo to xrhsth me poia xwra tha sinorwvei h kathe xwra me vash tus analoiwtus periorismus mas.
	 * 
	 * @param size   to megethos tu pinaka
	 * @param infection   to pososto epimolinshs
	 * @throws NegativeNumberException elegxw an to size<=0 h to infection einai arnhtiko tote kanw throw avto to exception
	 */
	public ExtendedField(int size,double infection,int capH,int capQ) throws NegativeNumberException{
		
		
		if(size<=0)
			throw new NegativeNumberException("To plithos twn pedion den mporei na einai oute arnitiko oute 0");
		else if(infection<0.0)
			throw new NegativeNumberException("To pososto molinsis den mporei na einai arnitiko");
		
		list=new ArrayList<Field>(size);
		for(int i=0;i<size;i++) {
			Field f=Simulation.makeTheField(infection,capH,capQ);
			list.add(f);
		}
		Scanner scanE=new Scanner(System.in);
		boolean valid;
		String s="";
		if(size>1) {
			
		for(int i=0;i<size;i++) {
			
			if(numberOfConnections(i)<size-1) {
				do {
					valid = true;
					System.out.println("Dwse to onoma tis xwra pou theleis na sinorevei me tin  "+list.get(i).getName()+ " ( dwse -1 otan teleiwseis )");
					s =scanE.next();
			
					if(s.equals("-1")) {
						valid=true;
					}
					
					else if(!checkName(s)) {
						System.out.println("Den yparxei afth h xwra");
						valid = false;
					}else if(list.get(i).getName().equalsIgnoreCase(s)) {
						valid=false;
						System.out.println("Den mporei kapia xwra  na sinorevei me ton eavto tou");
					}
					
				  else if(CheckForConnection(i,checkNamePlace(s))) {
						valid = false;
						System.out.println("Yparxoun idei sinora anamesa se aftes tis  2 xwres");
					}
				
				}while(!valid);
			
			}else {
				System.out.println("H xwra "+ list.get(i).getName() + " sinorevei me oles tis alles xwres"); 
			}
			System.out.println("dwse se posa kelia tha einai to sinoro");
			int n=scanE.nextInt();
		    while(!s.equals("-1")){
		    	 int a=checkNamePlace(s);
		    	 Point a1[]=list.get(i).createRandomwithN(n);
		    	 Point a2[]=list.get(a).createRandomwithN(n);
		    	 if(a1==null || a2==null) 
		    		 System.out.println("Einai full den mporw na valw alo sinoro");
		    		 
		    	 else {
		    		 list.get(i).setSinoro(i, a, a1, a2,3);
		    		 list.get(a).setSinoro(a, i, a2, a1,3);
		    	 }
		    	 
		    	 if(numberOfConnections(i)<size-1)
		    		 do {
		    			 valid=true;
		    			 System.out.println("Dwse to onoma tis xwra pou theleis na sinorevei me tin "+list.get(i).getName()+" ( dwse -1 otan teleiwseis )");
		    			 s=scanE.next();
		    			 
		    			 if(s.equals("-1")) {
		    				 valid=true;
		    			 }
					
		    			 else if(!checkName(s)) {
		    				 System.out.println("Den yparxei afth h xwra");
		    				 valid = false;
		    			 }else if(list.get(i).getName().equalsIgnoreCase(s)) {
		    				 valid=false;
		    				 System.out.println("Den mporei kapia xwra  na sinorevei me ton eavto tou");
		    			 }
					
		    			 else if(CheckForConnection(i,checkNamePlace(s))) {
		    				 valid = false;
		    				 System.out.println("Yparxoun idei sinora anamesa se aftes tis  2 xwres");
		    			 }
						
		    		 }while(!valid);
		    	 
		    	 else {
		    		 s="-1";
		    		System.out.println("H xwra "+ list.get(i).getName() + " sinorevei me oles tis alles xwres"); 
		    	 }
		     } 
		}
	}
		for(int i=0;i<list.size();i++) {
			 list.get(i).printStatistics();
	         
		}
		
	
	}
	public  static int getRound() {
		return round;
	}
	
	public void TakeHomeSimulation(double inf) {
		Field a=new Field(200,300);
		Field b=new Field(150,100);
		Field c=new Field(250,200);
		Field d=new Field(150,100);
		Field e=new Field(80,20);
		list=new ArrayList<Field>(5);
		
		a.initialize(400, inf, 10, 10, "A");
		list.add(a);
		b.initialize(100, inf, 5, 5, "B");
		list.add(b);
		c.initialize(100, inf, 20, 20, "C");
		list.add(c);
		d.initialize(80, inf, 10, 10, "D");
		list.add(d);
		e.initialize(50, inf, 20, 20, "E");
		list.add(e);
		
		//Se sxolia iparxun oi xwres pou zhta to paradeigma.
		
		/*
		 * a.initialize(500, inf, 10, 10, "A");
		list.add(a);
		b.initialize(150, inf, 5, 5, "B");
		list.add(b);
		c.initialize(800, inf, 20, 20, "C");
		list.add(c);
		d.initialize(150, inf, 10, 10, "D");
		list.add(d);
		e.initialize(100, inf, 20, 20, "E");
		list.add(e);
		 */
			
			 //A<-->B
			 Point a1[]=list.get(0).createRandomwithN(20);// xwra A
	    	 Point a2[]=list.get(1).createRandomwithN(20);//xwra B
	    	 list.get(1).setSinoro(1, 0, a2, a1,20);//vazw ta sinora xwra B
	    	 list.get(0).setSinoro(0, 1, a1, a2,20);//vazw sinoro sth xwara A
	    	 //A<-->C
	    	 a1=list.get(0).createRandomwithN(20);// xwra A
	    	 a2=list.get(2).createRandomwithN(20);//xwra C
	    	 list.get(2).setSinoro(2, 0, a2, a1,20);//vazw ta sinora xwra C
	    	 list.get(0).setSinoro(0, 2, a1, a2,20);//vazw sinoro sth xwara A
	    	 //B<-->D
	    	 a1=list.get(1).createRandomwithN(5);// xwra B
	    	 a2=list.get(3).createRandomwithN(5);//xwra D
	    	 list.get(1).setSinoro(1, 3, a1, a2,5);//vazw ta sinora xwra B
	    	 list.get(3).setSinoro(3, 1, a2, a1,5);//vazw sinoro sth xwara D
	    	 //C<-->D
	    	 a1=list.get(2).createRandomwithN(20);// xwra C
	    	 a2=list.get(3).createRandomwithN(20);//xwra D
	    	 list.get(2).setSinoro(2, 3, a1, a2,20);//vazw ta sinora xwra C
	    	 list.get(3).setSinoro(3, 2, a2, a1,20);//vazw sinoro sth xwara D
	    	 //C<-->E	   	
	    	 a1=list.get(2).createRandomwithN(5);// xwra C
	    	 a2=list.get(4).createRandomwithN(5);//xwra E
	    	 list.get(2).setSinoro(2, 4, a1, a2,5);//vazw ta sinora xwra C
	    	 list.get(4).setSinoro(4, 2, a2, a1,5);//vazw sinoro sth xwara E
	    	 
		 
		
		//Gia ta mesa metaforas twra:
		//A-->B me 40 theseis, 3 fores th mera
		mesa=new ArrayList<MMM>(4);
		MMM m1=new MMM(40,0,1,3);  
		mesa.add(m1);
		//A-->C me 80 theseis, 3 fores th mera
		m1=new MMM(80,0,2,3);  
		mesa.add(m1);
		//A-->D me 30 theseis, 2 fores th mera
		m1=new MMM(30,0,3,2);  
		mesa.add(m1);
		//A-->E me 100 theseis, 1 for1 th mera
		m1=new MMM(100,0,4,1);  
		mesa.add(m1);
		
		
	}
	
	
	/**
	 * Einai h methodos pu kalw gia na etelesw th kinhsh enos sigkekrimenu Mesu mazikhs anforas.
	 * Ektelw kinhsh apo A-->B kai xana erxete to metaforiko meso piso sto A adeio epeidh an ektelesw xana kinhsh apo B-->A 
	 * den tha einai ebdiakrito pws kinithikan ta atoma.
	 * 
	 * @param m1 to metaforiko meso
	 */
	public  void motionbyMMM(MMM m1) {
		list.get(m1.getFrom()).mesoMove(m1);
		list.get(m1.getTo()).addManyPeople(m1.getPeople());
		
		
			
	}
	/**
	 * H sinarthsh pu apofasizei an sth parusa xronikh stigmh prepei na ginei h metafora tu MMM
	 * prwta kanw to xrono pume twra na ginei o antistoixos sto prwto 24wro(dhladh apo 1-1440 perilamvanwmenu 
	 * meta diatrexw sth lista me ta MMM vlepw an eimai sto xrono pu prepei na ektelestei h kinhsh kai h metafora tu MMM tote ta ektelw.
	 * 
	 */
	public void kinhshMesaMetaforas() {
		int t=this.time;
		while(t>1440)
			t=t-1440;

		for(int k=0;k<this.mesa.size();k++) {
	
			int s=1440/mesa.get(k).getTimes();
			if(t%s==0) {//gia nadw an einai h seira tu mmm na kanei to dromologio tu.
				
				motionbyMMM(mesa.get(k));
				mesa.get(k).removeAll();
		}}
		
		
	}
	/**
	 * Avth h sinarthsh tipwnei plhrofories-statistika gia olew tis xwres.
	 * 
	 */
	public void generalStatistics() {
		int a[]={0,0,0,0,0};
		for(int i=0;i<list.size();i++) {
			a[0]+=list.get(i).statistics()[0];
			a[1]+=list.get(i).statistics()[1];
			a[2]+=list.get(i).statistics()[2];
			a[3]+=list.get(i).statistics()[3];
			a[4]+=list.get(i).statistics()[4];
		}
		System.out.println("Anthrwpoi igieis:"+ a[0]);
	    System.out.println("Arrwstoi anthrwpoi: "+ a[1]);
	    System.out.println("Anthrwpoi me anwsia: "+ a[2]);
	    System.out.println("Arwstoi anthrwpoi sto Nosokomeio: "+ a[3]);
	    System.out.println("Arwstoi anthrwpoi sth karantina : "+ a[4]);
	}
	/**
	 * H methodos epistrefei me poses xwres sinorevi i xwra stin thesi i tis listas.
	 * 
	 * @param i
	 * @return int
	 */
	private int numberOfConnections(int i) {
		int counter=0;
		
		for(int x=0;x<list.get(i).getLengthM();x++)
			for(int y=0;y<list.get(i).getLengthP();y++)
				if(list.get(i).getBoard()[x][y].getSinoro() != null)
					counter++;
		
		return counter/3;
	}
	/**
	 * Enas default constructor gia to object mu.
	 * 
	 */
	public ExtendedField() {
		// TODO Auto-generated constructor stub
	}
	private boolean CheckForConnection(int i, int a) {	
		for(int x=0;x<list.get(i).getLengthM();x++)
			for(int y=0;y<list.get(i).getLengthP();y++)
				if(list.get(i).getBoard()[x][y].getSinoro() != null && list.get(i).getBoard()[x][y].getSinoro().getTo() == a)
					return true;
		
		return false;
		
	}
	/**
	 * Sinarthsh pu ektelei metakinhsh se ola ta fields.
	 * Avth h sinarthsh diaxwrizei th kinhsh se dio merh/otropus.
	 * An o anthrwpos mu einai se sinoro kai prospathise me th move na kinhthei kai kinhthike exw apo to field tote tu alasw xwra me th sinoraMotion alliws an kinithike
	 * pali mesa sto pinaka ola kala kai sinexizw me to epomeno shmeio sto pinaka pu exw anthrwpo
	 * alliws an den einai sinoro kai exw anthrwpo pu mporei na kinithei kapu tote ektelw kanonikh kinhsh move opws sto prohgumeno version ths ergasias.
	 * Epishs meta pu tha kinithun oloi oi anthrwpoi ths xwras ektelw sinarthsh gia na paei kapoios nosokomeio 
	 * 
	 */
	private void moveAllFields() {
		for(int k=0;k<list.size();k++) {
			list.get(k).CheckForHospital();
			list.get(k).hospitalExit();
			for(int i=0;i<list.get(k).getLengthP();i++) {
	    		for(int j=0;j<list.get(k).getLengthM();j++) {
	    			if(list.get(k).getBoard()[i][j].getHuman()!=null && list.get(k).getBoard()[i][j].getHuman().getSick()) {
	    			      
	    			    	 
	                       list.get(k).getBoard()[i][j].getHuman().getPatient().addDay();// an kapoios anthrwpos einai arrwstos tu prosthetw alh mia mera
	                       list.get(k).getBoard()[i][j].getHuman().getPatient().setEmfanish();// gia na dume an tha emfanistun ta simptwmata tu oti einai arrwstos
	    			      
	    			}
	    			
	    			      if(list.get(k).getBoard()[i][j].getHuman()!=null && !list.get(k).getBoard()[i][j].getHuman().getMoved() && list.get(k).getBoard()[i][j].getSinoro()!=null &&  !list.get(k).moveS(i, j,false)) {
	    			    	 
	    			    	  sinoraMotion(k,i,j);
	    			      }
	    			    	  
	    			      
	    			      else if( list.get(k).getBoard()[i][j].getHuman()!=null && !list.get(k).getBoard()[i][j].getHuman().getMoved() && Math.random()>= 0.50 &&( (i-1>=0 && list.get(k).getBoard()[i-1][j].getCanMove() ) || ( i+1<list.get(k).getLengthP() && list.get(k).getBoard()[i+1][j].getCanMove()) || (j-1>=0 && list.get(k).getBoard()[i][j-1].getCanMove()  )|| (j+1<list.get(k).getLengthM() && list.get(k).getBoard()[i][j+1].getCanMove() )|| (i-1>=0 &&j-1>=0 &&list.get(k).getBoard()[i-1][j-1].getCanMove()) 
	    	    			|| (i+1<list.get(k).getLengthP() &&j+1<list.get(k).getLengthM()  && list.get(k).getBoard()[i+1][j+1].getCanMove() )|| ((i-1>=0 &&j+1<list.get(k).getLengthM() && list.get(k).getBoard()[i-1][j+1].getCanMove() )
	    	    			|| (i+1<list.get(k).getLengthP() &&j-1>=0 && list.get(k).getBoard()[i+1][j-1].getCanMove())))) {
	    	    		     
	    			    	  list.get(k).move(i,j);    					  
	    			    	  list.get(k).getBoard()[i][j].removeHuman();
	                          }
	    			      
	    		}
	    	}
			
			 
			
		}
		if(getTime()%(60*24)==0 && getTime()!=0) {//an exw exw dianisei kapoia mera dhladh eimai mera 1/2/3... tote kanw to elegxo gia to coronoio.
			this.coronaCheck(10);//10 test se kathe xwra.
		}
		
		for(int i=0;i<list.size();i++)
			list.get(i).printStatistics();
		
	}
	/**
	 * Sinarthsh pu ektelei to test tu COVID-19 se oles tis xwres kata to opoio an kapoios vgei thetikos metaferete se karantina.
	 * 
	 * @param a 
	 */
	public void coronaCheck(int a) {
		for(int k=0;k<list.size();k++)
			list.get(k).checkforInfected(a);
	}
	
	/**
	 * Avth h sinarthsh einai gia th kinhsh anthrwpwn pu vriskonte se sinora kai apofasistike me prohgumeno algorithmo  na metaferthun se alh xwra.
	 * Se avth th methodo xrhsimopoiw ton analloiwto periorismo oti an exw ena antrhwpo se ena sinoro kai exw kai alo anthrwpo sto antistixo sinoro
	 * ths alhs xwra kai tixei o prwto na kinithei ektos pinaka dhladh na paei sth alh xwra tote avtomata kai o alos tha paei sth xwra pou tu antistoixei-dhladh th
	 * xwrra tu prwtu etsi wste na mhn vrethun 2 anthrwpoi se ena keli afu APAGOREVETAI.
	 * 
	 * @param k to shmeio tu pinaka pu vriskomai dhladh h xwra pu vriskete o anthrwpos twra prin the metakinhsh
	 * @param i to i dhladh h sthlh sto pinaka - dhladh to y
	 * @param j to j dhladh h grammh sto pinaka - dhladh to x
	 */
	private void sinoraMotion(int k,int i,int j) {

						int z= list.get(k).getBoard()[i][j].getSinoro().getTo();
						int x1=list.get(k).getBoard()[i][j].getSinoro().getLink().getX();//to x pu tha paei o anthrwpos
						int y1=list.get(k).getBoard()[i][j].getSinoro().getLink().getY();//to y pu tha paei o antrhwpos
						
						if(list.get(z).getBoard()[y1][x1].getHuman()==null ) {// Ara den  exw anthrwpo sto antistixo sinoro ths alhs xwra
						   if(list.get(z).checkCanMove(y1, x1)) {
							   list.get(z).getBoard()[y1][x1].setHuman(list.get(k).getBoard()[i][j].getHuman());
							
							System.out.println();
							System.out.println("Metakinithike o anthrwpos apo th xwra : "+list.get(k).getName()+" ("+i+","+j+") Sth xwra: "+list.get(z).getName()+" ("+y1+","+x1+")" );
							System.out.println(); 
							
							list.get(z).moveS(y1, x1,true); //afu phge sto sinoro ths neas xwras tha ton metakinisw mia kinhsh kai na mhn paei se sinoro
							list.get(k).getBoard()[i][j].removeHuman();
							}
							else//Afoy den mporw na kinithw an paw sto sinoro ths alh xwras giavto den tha ton metakinisw
								list.get(k).getBoard()[i][j].getHuman().setMoved(true);
						}
						else {// an exw anthrwpo sto sinoro-link mu tote kanw swap kai tus dio anthrwpus
						
						  if(list.get(k).checkCanMove(i, j) && list.get(z).checkCanMove(y1, x1)) {//An mporun na metakinithun apo ta sinora kai oi dio
							Human temp1=list.get(k).getBoard()[i][j].getHuman();
							Human temp2=list.get(z).getBoard()[y1][x1].getHuman();
							list.get(k).getBoard()[i][j].removeHuman();  //elevtherwnw th thesh
							list.get(z).getBoard()[y1][x1].removeHuman();//elevtherwnw th thesh
							
							list.get(k).getBoard()[i][j].setHumanForSinoroSwap(temp2);//topothete to anthrwpo sth alh xwra
							list.get(z).getBoard()[y1][x1].setHumanForSinoroSwap(temp1);//topothete ton alo anthrwpo sth alh xwra
							
							System.out.println();
							System.out.println("Metakinithike o anthrwpos apo th xwra: "+list.get(k).getName()+" ("+i+","+j+") Sth xwra: "+list.get(z).getName()+" ("+y1+","+x1+")" );
							System.out.println("Metakinithike o anthrwpos apo th xwra: "+list.get(z).getName()+" ("+y1+","+x1+") Sth xwra: "+list.get(k).getName()+" ("+i+","+j+")" );
							System.out.println();
							if(list.get(k).checkCanMove(i, j)!=false && list.get(z).checkCanMove(y1, x1)!=false) {
							      list.get(k).moveS(i, j,true); //afu phge sto sinoro ths neas xwras tha ton metakinisw mia kinhsh kai na mhn paei se sinoro
							      list.get(z).moveS(y1, x1,true); //afu phge sto sinoro ths neas xwras tha ton metakinisw mia kinhsh kai na mhn paei se sinoro
							}
						}	
						
						else {
							list.get(k).getBoard()[i][j].getHuman().setMoved(true);
							list.get(z).getBoard()[y1][x1].getHuman().setMoved(true);
						}
						}  
						
						
		
	
		
	}
	/**
	 * Edw ektelunte oio kinhseis olwn twn anthrwpwn olwn twn xwrwn,kanume setCell, kai avvxanume to round kata ena afu perase ena lepto.
	 * 
	 */
	public void nextGeneration() {
		this.moveAllFields();
		
		this.kinhshMesaMetaforas();
		for(int i=0;i<list.size();i++) {
			list.get(i).nextGen();
			list.get(i).setCell();
		}
		
		
		round++;
		time=time+30;
	
		
	}
	/**
	 * Avth einai h nea sinarthsh poy ektelei thn ektipwsh kathe fora kanw print sto kamva kapoio apo tis xwres prwta th xwra 0 meta th 1 kai paei me avto to rithmo
	 * kai kathe fora kanw print ta statistika olwn twn xwrwn etsi wste na exume analitika ola ta dedomena gia th kathe xwra.
	 * 
	 */
	public void print() {
		
		if(draw>=list.size())
			draw=0;
		System.out.println();
		System.out.println("Round "+round );
		
		for(int i=0;i<list.size();i++) {
			
			list.get(i).printStatistics();
			if(i==draw) 
				list.get(i).Print();
				
			draw++;
			
		}
	}
	/**
	 * Avth h sinarthsh elegxei an h xwra me kapoio sigkekrimeno onoma iparxei sth lista mas -xrisimopoiwntas th checkNamePlace.
	 * 
	 * @param name to onoma ths xwras
	 * @return epistrefei true an iparxei kai false an den iparxei
	 */
	public static boolean checkName(String name) {
		if(checkNamePlace(name)==-1)
			return false;
		return true;
					
	}
	/**
	 * Avth h methodos elegxei an iparxei kapoia sigkekrimenh xwra kai epistrefei th thesh ths listas sth opoia iparxei an epistrepsei -1 den iparxei.
	 * 
	 * @param name to onoma ths xwras
	 * @return epistrefei th thesh ths, an den iparxei epistrefei -1
	 */
	public static int checkNamePlace(String name) {
		for(int i=0;i<Field.getCount();i++) {
			if(list.get(i).getName().equalsIgnoreCase(name))
				return i;
		}
		return -1;
	}
	public static int getTime() {
		return time;
	}
	
}
