package ChristodoulouPanagiotis.tk;

import java.awt.Color;

import java.util.ArrayList;
import edu.princeton.cs.introcs.StdDraw;

/**
 * Avth einai h kiria klash mas dhladh h klash sth opoia xrisimopoiunte oi prohgumenes me skopo th anaparastash kai exaxwgh twn dedomenwn.
 * H klash anaparista to pedio dhladh kapoio xwro me idio mhkos kai platos-tetragwno xwro.
 * Apoteleti apo ena disdiastato pinaka me cells(kelia),to onoma tu Field(ths xwra), kai mia statikh metavlhth count pu th xrhsimopoiw 
 *  Epishs exei to infectionPercentage pu einai h pithanothta epimolhnshs.
 * Epipleon exw to statiko pedio count to opoio metra poses xwres exw dhmiourghsei epitixws.
 * 
 * @author pchris19, npapak01
 *
 */
public class Field {

	private String name;
	private static int count = 0;
	private Cell[][] board;
	
	private QuarantineCellNumber quarantineCell;
	private HospitalCellNumber hospitalCell;
	
	private double infectionPercentage;
    /**
     * EInai o katsevasths apla dexete enan akereo kai dhmiourga me avto to megethos to pedio dhl ton disdiastato pinaka apo cells,
     * arxikopoei to round me 0 kai to infectioperxcentage me 0.
     * 
     * @param board_size dexete san parametro to megethos tu xwru.
     */
    public Field(int board_sizeM,int board_sizeP) {
    	name = null; 
    	quarantineCell=null;
    	hospitalCell=null;
    	board = new Cell[board_sizeP][board_sizeM];
	   
	   for(int i=0;i<board_sizeP;i++)
		   for(int j=0;j<board_sizeM;j++)
			   board[i][j]= new Cell();
	   
	   infectionPercentage=0.0;
    }   
    /**
     * Getter methodos gia na pairnw to disdiastato pinaka me ta kelia mu.
     * 
     * @return ena disdiastato pinaka tipou Cell
     */
	public Cell[][] getBoard(){
    	return board;
    }
	/**
	 * getter methodos pu epistrefei to platos tu pinaka
	 * 
	 * @return
	 */
	public int getLengthP() {
		return board.length;
		
	}
	/**
	 * getter methodos pu epistrefei to mhkos tu pinaka
	 * 
	 * @return
	 */
    public int getLengthM() {
    	return board[0].length;
    }
    /**
     * sinarthsh pou dimiourga to keli-zonh  karantinas me psevdotixeo tropo
     * dexetai san parametro to cap dhladh posa atoma mporei na exei mesa sth karantina.
     * Epishs dhmiourga to quarantineCell tu field sto opoio vazei to shmeio pu einai h karantina.
     * 
     */
    public void setQuarantine(int cap) {
    	boolean f=true;
        int x=-1;
        int y=-1;
    	do {
    		f=true;
    	
    	 x=(int) (Math.random()*this.getLengthM());
    	 y=(int) (Math.random()*this.getLengthP());
    	if(board[y][x].getSinoro()!=null && board[y][x].getHospital()!=null)
    		f=false;
    	}while(!f);
    	board[y][x].addQuarantine(cap);
    	quarantineCell=new QuarantineCellNumber(x,y);
    	
    }
    
    /**
     * sinarthsh pou prosthetei anthrwpo sth karanthna an exei xwro.
     * 
     * @param h dexetai kapoio anthrwpo kai ton prosthetei sth karantina
     * @return epistrefei true/false gia to an ta katafere
     */
    public boolean addToQuarantine(Human h) {
    	int x=quarantineCell.getPoint().getX();
    	int y=quarantineCell.getPoint().getY();
    	if(board[y][x].getQuarantine().getNosuntes()<board[y][x].getQuarantine().getCapacity()) {
    	     board[y][x].getQuarantine().addPerson(h);
    	     return true;
    	}
    	return false;
    }
    /**
     * H sinarthsh pou ektelei tus deigmatoliptikus elegxus gia na duume an einai kapoios arrwstos tote ton stelume sth karantina.
     * Thewrw pws kapoios den mporei na figei apo thn karantina.
     * 
     * @param a posus elegxus tha kanume
     */
    
    public void checkforInfected(int a) {
    	int counter=0;
    	for(int i=0;i<getLengthP();i++) {
    		for(int j=0;j<getLengthM()&& counter<a;j++) {
    			if(board[i][j].getHuman()!=null) {
    				if( board[i][j].getHuman().getSick() && Math.random()>=0.2) {
    					double chance=0;
    	    			double m=Math.random();
    	    			switch(board[i][j].getHuman().getAge()) {
    	    			 case 'A':
    	    			 case 'B':
    	    				 chance=0.05;
    	    				 break;
    	    			 case 'C':
    	    				 chance=0.208;
    	    				 break;
    	    			 case 'D':
    	    				 chance=0.301;
    	    				 break;
    	    			 case 'E':
    	    				 chance= 0.60;
    	    				 break;	 
    	    			}
    	    			if(m<=chance || chance>0.5) {//An einai megalhs hlikias o anthrwpos tote paei apevtheias sto nosokomeio
    	    				if(addToHospital(board[i][j].getHuman())) {
    	    				    board[i][j].removeHuman();
    	    				}
    	    						
    	    			}
    	    			else if(addToQuarantine(board[i][j].getHuman())) //an o anthrwpos einai arrwstos tote paei sth karantina kai afaireitai apo to board
        			    board[i][j].removeHuman();
    				}
    				counter++;
    		     }
    	}	    				
    		}
    		
    		
    	}
    
    /**
     * Sinarthsh h opoia dhmiourgei to nosokomeio se psevdotixeo keli.
     * Epishs dhmiourga to HospitalCellNUmber tu field vazwntas to shmeio pou einai to nosokomeio.
     * 
     * @param c h xwritikothta tu nosokomeiu.
     */
    public void makeHospital(int c) {
    	boolean f=true;
        int x;
        int y;
    	do {
    		f=true;
    	
    	 x=(int) (Math.random()*this.getLengthM());
    	 y=(int) (Math.random()*this.getLengthP());
    	 if(board[y][x].getSinoro()!=null || board[y][x].getQuarantine()!=null)
    		f=false;
    	}while(!f);
    	board[y][x].addHospital(c);
    	this.hospitalCell=new HospitalCellNumber(x,y);
    	
    }
    /**
	 * sinarthsh pu stelei anthrwpus sto nosokomeio
	 * 
	 * @return epistrefei true/false an ta kaatafere
	 */
    public boolean addToHospital(Human h) {
    	int x=hospitalCell.getPoint().getX();
    	int y=hospitalCell.getPoint().getY();
    	if(board[y][x].getHospital().getNosuntes()<board[y][x].getHospital().getCapacity()) {
    		 h.getPatient().initializeHospitalTime();
    	     board[y][x].getHospital().addPerson(h);
    	    
    	     return true;
    	}
    	return false;
    }
    /**
     * H sinarthsh h opoia apofasizei pois anthrwpos prepei na stalei sto nosokomeio me vash th erevna pu ekana.
     * Epishs an to nosokomeio gemisei stamata na dexete allus anthrwpus.
     * 
     */
    public void CheckForHospital() {
    	for(int j=0;j<this.getLengthM();j++)
    		for(int i=0;i<this.getLengthP();i++) {
    			
    			if(board[i][j].getHuman()!=null && board[i][j].getHuman().getPatient().getHospitalTime()!=-1)
    				board[i][j].getHuman().getPatient().getHospitalTime();
    			
    		  if(board[i][j].getHuman()!=null && board[i][j].getHuman().getPatient().getEmfanish()) {	//an o anthrwpos exei emfanisei simptwmata
    			double m=Math.random();                                                         // mporei na paei sto nosokomeio
    			char c=board[i][j].getHuman().getGender();
    			double chance=0;
    			
    			switch(c) {
    			 case 'A':
    			 case 'B':
    				 chance=0.05;
    				 break;
    			 case 'C':
    				 chance=0.208;
    				 break;
    			 case 'D':
    				 chance=0.301;
    				 break;
    			 case 'E':
    				 chance= 0.60;
    				 break;	 
    			}
    			if(m<=chance || chance>=0.50) {//An einai megalhs hlikias o anthrwpos tote paei apevtheias sto nosokomeio
    				if(addToHospital(board[i][j].getHuman())) {
    				    board[i][j].removeHuman();
    				}
    						
    			}
    				
    		}
    		}
    }
    /**
     * Sinarthsh  sth opoia fevgei kapoios apo to nosokomeio otan ginei kala.
     * Meta apo erevna katelhxa pws o mesos anthrwpos ginete kala stis 7 meres apo th eisagwgh tu.
     * 
     */
    public void hospitalExit() {
    	int x=hospitalCell.getPoint().getX();
    	int y=hospitalCell.getPoint().getY();
    	ArrayList<Human> exitHumans=new ArrayList<>(5);
    	for(int k=0;k<board[y][x].getHospital().getNosuntes();k++) {
    		Human h=(Human)board[y][x].getHospital().getPeople().get(k);
    		if(h.getPatient().getHospitalTime()>=(7*48)) {//meta apo mia evdomada mporei na figei apo to nosokomio
    			h.setHealthy();
    			exitHumans.add(h);
    			board[y][x].getHospital().removePerson(k);
    		}
    	}
    	this.addManyPeople(exitHumans);   	
    }
    
    
    
    	
    
    
    /**
     * Sinarthsh gi na ektelw to mazema/sillogh twn anthrwpwn apo ta diafora kelia gia na tus parw sth alh xwra me to meso metaforas.
     * 
     * @meso pairnei san parametro to meso me to opoio tha tus parei
     */
    public void mesoMove(MMM meso) {
    	
    	
    	for(int j=0;j<this.getLengthM();j++) {
    		for(int i=0;i<this.getLengthP();i++) {
    			
    			if(board[i][j].getHuman()!=null && meso.getMetaferwmenus()<meso.getCapacity() && Math.random()>=0.5) {
    				meso.addPeopleList(board[i][j].getHuman());//tus prosthetw sth lista
    				board[i][j].removeHuman();
    				
    			}
    				
    		}
    	}
    	
    	
    	
    }
    /**
     * Sinarthsh pou elegxw an kapoio keli einai adeio dhladh den exei anthrwpo,den einai nosokomeio,den einai karantina.
     * 
     * @param x 
     * @param y
     * @return epistrefei true/false an ta katafere
     */
    public boolean checkEmpty(int x,int y) {
    	if(board[y][x].getHuman()!=null || board[y][x].getHospital()!=null|| board[y][x].getQuarantine()!=null || board[y][x].getSinoro()!=null)
    		return false;
    	return true;
    				
    }
    /**
     * Sinarthsh h opoia dexetai ena arrayList apo anthrwpus kai tus emfanizei tixea mesa sth xwra.
     * 
     * @param listH to arrayList me tus anthrwpus
     */
    public void addManyPeople(ArrayList<Human> listH) {
    	int k=0;
    	int megethos=listH.size();
    	while(k<megethos)
    	 {
    		boolean f=true;
    		int x,y;
    		do {
    			x=(int) (Math.random()*this.getLengthM());
    		    y=(int) (Math.random()*this.getLengthP());
    		    
    			f=checkEmpty(x,y) | board[y][x].getSinoro()!=null;

    		}while(!f);
    		board[y][x].setHuman(listH.get(k));
    		k++;
    	}
    	
    		
    	
    }
    
   
    
    
    /**
     * Avth einai h mehtodos initialize ,arxikopoiei to simulation dhladh dinei to enavsma kai kapoia arxika stoixeia gia na xekinisei.
     * Epishsh dinei ena onoma sto field apoteleitai apo to Field kai ena arithmo 0,1,...
     * 
     * @param numOfHumans arithmos twn anthrwpwn
     * @param infectionP pososto molinshs
     * @param c to capacity tu nosokomeiu
     * @param capto capacity ths zwnhs karantinas
     * @param s to onoma ths xwras
     * 
     */
    public void initialize(int numOfHumans,  double infectionP, int c,int cap,String s)  {
                  
	      
	      name = s;
	      count++;
	      infectionPercentage=infectionP;
	      int counter=0, position_x, position_y;
	      char g,a;//gender kai age group
		      position_x = (int) (Math.random() * getLengthP());
		      position_y = (int) (Math.random() * getLengthM());
		      if(counter<=16* numOfHumans)
		    	  a='A';
		      else if(counter<=38  * numOfHumans)
		    	  a='B';
		      else if(counter<=60 * numOfHumans)
		    	  a='C';
		      else if(counter<=84 * numOfHumans)
		    	  a='D';
		      else 
		    	  a='E';
		      if(counter<= 51 *numOfHumans)
		    	  g='W';
		      else 
		    	  g='M';
		    	  
		      
		      Human h = new Human("h"+counter, false , true,a,g);
		      
		      while(!board[position_x][position_y].setHuman(h)) {
			        position_x =(int) Math.random() * getLengthM();
			        position_y =(int) Math.random() * getLengthP();
		     }
		     
		     counter++;		

   	    for(int i=1; i < numOfHumans; i++) {
		 
		   position_x =(int) (Math.random() * getLengthP());
		   position_y =(int) (Math.random() * getLengthM());
		   if(counter<=16)
		    	  a='A';
		      else if(counter<=38  * numOfHumans)
		    	  a='B';
		      else if(counter<=60 * numOfHumans)
		    	  a='C';
		      else if(counter<=84 * numOfHumans)
		    	  a='D';
		      else 
		    	  a='E';
		      if(counter<= 51 *numOfHumans)
		    	  g='W';
		      else 
		    	  g='M';
		    	  
		      
		      Human h2 = new Human("h"+counter, false , false,a,g);
		 
		   while(! board[position_x][position_y].setHuman(h2)) {
			  position_x =(int) Math.random() * getLengthM();
			  position_y =(int) Math.random() * getLengthP();
		   }
		   counter++;		
	 }
   	
   	   
	    this.makeHospital(c);//dhmiourgw nosokomeio
	    this.setQuarantine(cap);//dhmiourgw zwnh-karantinas
	    this.printStatistics();
	    
	    
    }
    /**
     * Epistrefei pisw to onoma tu sigkekrimenu Field(Xwras).
     * 
     * @return epistrefei to String
     */
    public String getName() {
    	return name;
    }
  
   
    /**
     * Avth einai h methodos h opoia perna apo olo to pinaka-ola ta kelia elegxei tis 8 katevthinseis kai an arwstheis o anthrwpos tote tona arwsta me th setSick.
     * OI 8 katevthinsim apo tis opoies mporei kapoios na arwsthsei einai :
     * Aristera,dexia,panw,katw,panw aristrea,panw dexia,katw aristera ,katw dexia.
     * Epishs mono apo to dopla keli mporei kapoios na arwsthsei.
     * 
     */
    private void infectedByHuman() {
    	for(int i=0;i<getLengthP();i++)
 		   for(int j=0;j<getLengthM();j++)
    	 {
    			if(board[i][j].getHuman()!=null && !board[i][j].getHuman().getSick()) {
    			
    			if(i-1>=0 && board[i-1][j].getHuman()!=null && board[i-1][j].getHuman().getSick()) {
    				int r=(int)(Math.random()*100);
    				if(r < infectionPercentage ) {
    				    board[i][j].getHuman().setSick();
    				    break;
    				}
    			}
    			if(i+1<getLengthP() && board[i+1][j].getHuman()!=null && board[i+1][j].getHuman().getSick()) {
    				int r=(int) (Math.random()*100);
    				if(r<infectionPercentage ){
    				    board[i][j].getHuman().setSick();
    				    break;
    				}
    				   
    			}
    			if(j-1>=0 && board[i][j-1].getHuman()!=null && board[i][j-1].getHuman().getSick()) {
    				int r=(int) (Math.random()*100);
    				if(r<infectionPercentage ){
    				    board[i][j].getHuman().setSick();
    				    break;
    				}
    				    
    			}
    			
    			if(j+1<getLengthM() && board[i][j+1].getHuman()!=null && board[i][j+1].getHuman().getSick()) {
    				int r=(int) (Math.random()*100);
    				if(r<infectionPercentage ){
    				    board[i][j].getHuman().setSick();
    				    break;
    				}
    				   
    			}
    			
    			if(i-1>=0 &&j-1>=0 && board[i-1][j-1].getHuman()!=null && board[i-1][j-1].getHuman().getSick()) {
    				int r=(int) (Math.random()*100);
    				if(r<infectionPercentage ){
    				    board[i][j].getHuman().setSick();
    				    break;
    				}
    				    
    				
    			}
    			if(i+1<getLengthP() && j+1<getLengthM()  && board[i+1][j+1].getHuman()!=null && board[i+1][j+1].getHuman().getSick()) {
    				int r=(int) (Math.random()*100);
    				if(r<infectionPercentage ){
    				    board[i][j].getHuman().setSick();
    				    break;
    				}
    				    
    				
    			}
    			if(i-1>=0 &&j+1<getLengthM() && board[i-1][j+1].getHuman()!=null && board[i-1][j+1].getHuman().getSick()) {
    				int r=(int) (Math.random()*100);
    				if(r<infectionPercentage ){
    				    board[i][j].getHuman().setSick();
    				    break;
    				}
    				    
    			}
    			if(i+1<getLengthP() && j-1>=0 && board[i+1][j-1].getHuman()!=null && board[i+1][j-1].getHuman().getSick()) {
    				int r=(int) (Math.random()*100);
    				if(r<infectionPercentage ){
    				    board[i][j].getHuman().setSick();
    				    break;
    				}
    				    
    			}
    		}	
    }	}
    			
    
    	
    	
    /**
     * Avth h methodos elegxei an eimai se kapoio molismeno keli elegxei an mporw na arwthsw kai ana rwsthsw tote kanw setSick.
     * 
     */
    private void infectedByCell() {
		for(int j=0;j<getLengthM();j++) {
			for(int i=0;i<getLengthP();i++) {
				
				if(board[i][j].getHuman()!=null) {    
					
					
    				if(board[i][j].getInfection()>0.0 && !board[i][j].getHuman().getSick() &&  board[i][j].getHospital()==null && board[i][j].getQuarantine()==null   ) {
    					Point p=new Point(j,i);
    					Point p2=board[i][j].getHuman().getPrevious();
    					
    					int r=(int) (Math.random()*100 );
    					if(r<(board[i][j].getInfection()) && Point.equals(p, p2)) //afu prepei name se avto to keli 2 rounds sinexwmena gia na  kolisw
    						board[i][j].getHuman().setSick();	
			        }
				}
			}
		}
   } 
    /**
     * Avth h sinarthsh kanei an eimai arwstos tote elegxw oti mporei na arwsthsw -metadwsw ton io sto keli pu vriskome
     * kai an tixi kai metadwsw ton io tote avxanw to infection tu keliu sto miso apoti to geniko infection percentage + to ena dekato tu infectioPercentage
     * + thn hdh iparxwn molinsi tu keliu, 
     * epeidh eiinai pio diskolo na metadwthei o ios apoo ena dwmatio apoti apo anthrwpo se anthrwpo.
     * 
     */
    private void infectTheCell() {
    	for(int j=0;j<getLengthM();j++) 
    		for(int i=0;i<getLengthP();i++) {
    			
    			if(board[i][j].getHospital()==null && board[i][j].getQuarantine()==null &&board[i][j].getHuman()!=null &&    board[i][j].getHuman().getSick()) {    		
    				Point p=new Point(j,i);
					Point p2=board[i][j].getHuman().getPrevious();
					
        			int r=(int) (Math.random()*100);
        			if(r<infectionPercentage && Point.equals(p, p2)) {
    					board[i][j].setInfection( (infectionPercentage/2.0 + board[i][j].getInfection())+infectionPercentage/10); 
        			}				
    			}	
    		}	
    }
    /**
     * Avth h sinarthsh trexei mesa sto field kai elegxei osa kelia einai kena- den exun anthrwpo tote ta kanei set free.
     * Epishs miwnei to infection tu kathe kaliu kata to 1/10 tu infecitonPercentage etsi wste se 5 girus na figei entelws o ios apo to keli
     * afu meta apo erevnes apodixthike pws o ios meta apo ligo kero fevgei apo tus xwrus kai oso alazei o xronos meiwnete o ios pu iparxei se ena keli
     * kai ara miwnete kai h pithanothta avto to keli na kolhsei kapoion anthrwpo ton io mexris otu na midenisetei kai na einai entelws katharos avtos o xwros.
     * 
     */
    public void setCell() {
    	for(int j=0;j<this.getLengthM();j++)
    		for(int i=0;i<this.getLengthP();i++) {
    			if(board[i][j].getHuman()==null) 
    				board[i][j].setFree();
    			else
    	    		   board[i][j].getHuman().setMoved(false);
    			
    			if(board[i][j].getInfection()>0 &&  board[i][j].getHospital()==null && board[i][j].getQuarantine()==null ) 
    				board[i][j].setInfection(board[i][j].getInfection() - (infectionPercentage/10));
    				
    		}
    			
    }
    /**
     * Avth einai mia nea ekdoshs ths methodu move.
     * Dhladh einai mia methodos move h opoia pairnei kapoio anthrwpo se keli pou DEN einai SINORO.Epishs epistrefei boolean
     * dhladh an egine kanonika h kinhsh epistrefei true kai an eimai se sinoro kai  prospathise na paei exw apo ton pinaka epistrefei false 
     * dhladh tha allaxei Field(Xwra o sigkekrimenos anthrwpos.
     * 
     * @param i h grammh sth opoia vrisketai o anthrwpos pu thelw na metakinhsw
     * @param j h sthlh pou vriskete o sigkekrimenos anthrwpos pu thelw na metakinhsw
     * @param mustMove avth einai mia boolean metavlhth an einai false shmainei pws mporw na metakinithw ektos tu pinaka kai na allaxw Field(Xwra )se metepoito stadio.
     * @return epistrefei true metakinithike mesa sto field, false an vgainei exw apo to field (ara na  allaxei Xwra)
     */
    public boolean moveS(int i,int j,boolean mustMove) {
    	boolean f=false;
    	if(mustMove) {
    		if(!this.checkCanMove(i, j))
    			return false;
    		
    		
    	}
    	
    	do {
    		f=true;
    	int r =(int) (Math.random()*8);
    	switch(r) {
    	   case 0:
    		  if( board[i][j].getHuman()!=null &&i-1>=0 && board[i-1][j].getSinoro()==null && this.checkEmpty(j, i-1) && board[i-1][j].setHuman(board[i][j].getHuman())  ) {
    			  
    			  board[i][j].getHuman().setPrevious(new Point(j,i));
    			  
    			  board[i][j].removeHuman();
    			  board[i-1][j].getHuman().setMoved(true);
    			  
    			  f= true;
    		  }
    		  else if((board[i][j].getSinoro()!=null &&i-1<0) && !mustMove)
    			  return false;
    		  else
    		     f= false;
    		  
    		  break;
		 
    	   case 1:
    		   if(board[i][j].getHuman()!=null && i+1<getLengthP() && this.checkEmpty(j, i+1)&& board[i+1][j].getSinoro()==null &&  board[i+1][j].setHuman(board[i][j].getHuman())) {
    			  
     			   board[i][j].getHuman().setPrevious(new Point(j,i)); 
    			   board[i][j].removeHuman();
    			   board[i+1][j].getHuman().setMoved(true);
    			   f= true;
    			  
 		       }
    		   else if((board[i][j].getSinoro()!=null && i+1==getLengthP() )&&!mustMove)
    			   return false;
    		   else
      		     f= false;
      		   break;
		
    	   case 2:
    		   if(board[i][j].getHuman()!=null && j-1>=0 && board[i][j-1].getSinoro()==null && this.checkEmpty(j-1, i)&& board[i][j-1].setHuman(board[i][j].getHuman()) ) {
    			   
     			   board[i][j].getHuman().setPrevious(new Point(j,i));
    			   board[i][j].removeHuman();
    			   board[i][j-1].getHuman().setMoved(true);
    	             
    			  f= true;
    			  
     		  }
    		   else if((board[i][j].getSinoro()!=null && j-1<0) &&!mustMove )
    			   return false;
    		   else
      		     f= false;
      		  break;
    		   
    	   case 3:
    		   if(board[i][j].getHuman()!=null && j+1<getLengthM()  && board[i][j+1].getSinoro()==null && this.checkEmpty(j+1,i)&&  board[i][j+1].setHuman(board[i][j].getHuman()) ) {
    			   Point a=new Point(j,i);
     			   board[i][j].getHuman().setPrevious(new Point(j,i));
    			   board[i][j].removeHuman();
    			   board[i][j+1].getHuman().setMoved(true);
    
    			   f= true;
    		   }
    		   else if((board[i][j].getSinoro()!=null && j+1==getLengthM()) &&!mustMove)
    			   return false;
    		   else
      		     f= false;
      		  break;
    	   case 4:
    		   if(board[i][j].getHuman()!=null && i-1>=0 &&j-1>=0  && board[i-1][j-1].getSinoro()==null && this.checkEmpty(j-1, i-1)&&  board[i-1][j-1].setHuman(board[i][j].getHuman()) ) {
    			   
     			   board[i][j].getHuman().setPrevious(new Point(j,1));
    			   board[i][j].removeHuman();
    			   board[i-1][j-1].getHuman().setMoved(true);

     			   f= true;
    		   }
    		   else if((board[i][j].getSinoro()!=null && i-1<0 || j-1<0 )&&!mustMove)
    			   return false;
    		   else
      		     f= false;
      		  break;
    	   case 5:
    		   if(board[i][j].getHuman()!=null && i+1<getLengthP() &&j+1<getLengthM() && board[i+1][j+1].getSinoro()==null&& this.checkEmpty(j+1, i+1) && board[i+1][j+1].setHuman(board[i][j].getHuman()) ) {
    			 
     			   board[i][j].getHuman().setPrevious(new Point(j,i));
    			   board[i][j].removeHuman();
    			   board[i+1][j+1].getHuman().setMoved(true);
    	
    			   f= true;
    		   }
    		   else if((board[i][j].getSinoro()!=null && i+1==getLengthP() || j+1==getLengthM()) &&!mustMove)
    			   return false;
    		   else
      		     f= false;
      		  break;
    		   
    	   case 6:
    		   if(board[i][j].getHuman()!=null && i-1>=0 &&j+1<getLengthM() && board[i-1][j+1].getSinoro()==null  && board[i-1][j+1].getSinoro()==null&& this.checkEmpty(j+1, i-1)&& board[i-1][j+1].setHuman(board[i][j].getHuman())) {
    			  
     			   board[i][j].getHuman().setPrevious(new Point(j,i));
    			   board[i][j].removeHuman();
    			   board[i-1][j+1].getHuman().setMoved(true);
    			  
    			   f= true;
		       }
    		   else if((board[i][j].getSinoro()!=null && i-1<0 || j+1==getLengthM()) &&!mustMove)
    			   return false;
    		   else
      		     f= false;
      		  break;
    	   case 7:
    		   if(board[i][j].getHuman()!=null && i+1<getLengthP() && j-1>=0 && board[i+1][j-1].getSinoro()==null  &&   this.checkEmpty(j-1, i+1)&& board[i+1][j-1].setHuman(board[i][j].getHuman()) ) {
    			  
     			   board[i][j].getHuman().setPrevious(new Point(j,i));
    			   board[i][j].removeHuman();
    	
    			   board[i+1][j-1].getHuman().setMoved(true);
    			   f= true;
		       }
    		   else if((board[i][j].getSinoro()!=null && i+1==getLengthP() || j+1<0) &&!mustMove)
    			   return false;
    		   else
      		     f= false;
      		  break;
    	}   
    	}  while(!f);
		      return true;
    	
    }
    
    /**
     * Se avth th voithitikh sinarthsh  ektelite h kinhsh dhladh thewrw pws afu kalesthke h sinarthsh mporw na kinithw
     * kai dinw san parametro th twrinh thesh  kai dhmiourgw tixeo arithmoa po to 0 mexri 7 gia tis 8 katevthineis kai an mporw na paw se ekini th katevthinsh tote
     * phgen kai kai vazw ton anthrwmo setMove(true) dhladh kinithike gia avto to round kai an den katafere na kinithei xanaparagw tixeo arithmo mexris wtu na kinithei.
     * 
     * @param i to x pu vriskete o anthrwpos
     * @param j to y pu vriskete o anthrwpos
     */
    public void move(int i,int j) {
    	boolean f=true;
    	
    
        do {
        	
    	int r =(int) (Math.random()*8);
    	
    	switch(r) {
    	   case 0:
    		  if( i-1>=0 && board[i-1][j].setHuman(board[i][j].getHuman())) {
    			  Point a=new Point(j,i);
    			  board[i][j].getHuman().setPrevious(a);
    			  board[i-1][j].getHuman().setMoved(true);
    			     f= true;
    			     
    			
    		  }
    		  else
    
    		     f= false;
    		  
    		  break;
		 
    	   case 1:
    		   if(i+1<getLengthP() &&  board[i+1][j].setHuman(board[i][j].getHuman())) {
    			   Point a=new Point(j,i);
     			   board[i][j].getHuman().setPrevious(a);
    			   board[i+1][j].getHuman().setMoved(true);
    
    			    f= true;
 		       }
    		   else
      		     f= false;
      		   break;
		
    	   case 2:
    		   if(j-1>=0 &&  board[i][j-1].setHuman(board[i][j].getHuman())) {
    			   Point a=new Point(j,i);
     			   board[i][j].getHuman().setPrevious(a);
    			   board[i][j-1].getHuman().setMoved(true);
    	
    			  f= true;
    			  
     		  }
    		   else
      		     f= false;
      		  break;
    		   
    	   case 3:
    		   if(j+1<getLengthM() &&  board[i][j+1].setHuman(board[i][j].getHuman())) {
    			   Point a=new Point(j,i);
     			   board[i][j].getHuman().setPrevious(a);
    			   board[i][j+1].getHuman().setMoved(true);
    
    			   f= true;
    		   }
    		   else
      		     f= false;
      		  break;
    	   case 4:
    		   if(i-1>=0 &&j-1>=0 &&board[i-1][j-1].setHuman(board[i][j].getHuman())) {
    			   Point a=new Point(j,i);
     			   board[i][j].getHuman().setPrevious(a);
    			   board[i-1][j-1].getHuman().setMoved(true);

     			   f= true;
    		   }
    		   else
      		     f= false;
      		  break;
    	   case 5:
    		   if(i+1<getLengthP() &&j+1<getLengthM()  && board[i+1][j+1].setHuman(board[i][j].getHuman())) {
    			   Point a=new Point(j,i);
     			   board[i][j].getHuman().setPrevious(a);
    			   board[i+1][j+1].getHuman().setMoved(true);
    	
    			   f= true;
    		   }
    		   else
      		     f= false;
      		  break;
    		   
    	   case 6:
    		   if(i-1>=0 &&j+1<getLengthM() && board[i-1][j+1].setHuman(board[i][j].getHuman())) {
    			   Point a=new Point(j,i);
     			   board[i][j].getHuman().setPrevious(a);
    			   board[i-1][j+1].getHuman().setMoved(true);
    			  
    			   f= true;
		       }
    		   else
      		     f= false;
      		  break;
    	   case 7:
    		   if(i+1<getLengthP() && j-1>=0 &&board[i+1][j-1].setHuman(board[i][j].getHuman())) {
    			   Point a=new Point(j,i);
     			   board[i][j].getHuman().setPrevious(a);
    	
    			   board[i+1][j-1].getHuman().setMoved(true);
    			   f= true;
		       }
    		   else
      		     f= false;
      		  break;
    	}   
		      
    	}while(!f);
    }
    		   			
    
    
    
    /**
     * Afth h methodos dimiourgei to epomeno stadio tis prosomoioshs.
     * kalei tis methodous infectTheCell(), infectedByHuman(), infectedByCell(). 
     * 
     */
    public void nextGen() {
    	infectTheCell();
    	infectedByHuman();
    	infectedByCell();
  
    	
    }
     /**
      * Methodos pou dexetai shmeio pou eimai sto pinaka kai epistrefei an einai dinath metakinhsh apo avto to shmeio se ena allo shmeio pu den einai sinoro.
      *    
      * @param i einai to y
      * @param j einai to x
      * @return epistrefei boolean true an mporw na metakinithw , false an den mporw na metakinithw
      */
    public boolean checkCanMove(int i,int j) {
    	if  ( (i-1>=0 && getBoard()[i-1][j].getCanMove() && getBoard()[i-1][j].getSinoro()==null ) || ( i+1<getLengthP() && getBoard()[i+1][j].getCanMove() && getBoard()[i+1][j].getSinoro()==null )
    			|| (j-1>=0 && getBoard()[i][j-1].getCanMove() && getBoard()[i][j-1].getSinoro()==null   )|| (j+1<getLengthM() && getBoard()[i][j+1].getCanMove() && getBoard()[i][j+1].getSinoro()==null )|| (i-1>=0 &&j-1>=0 && getBoard()[i-1][j-1].getCanMove() && getBoard()[i-1][j-1].getSinoro()==null) 
    			|| (i+1<getLengthP() &&j+1<getLengthM()  && getBoard()[i+1][j+1].getCanMove()  && getBoard()[i+1][j+1].getSinoro()==null)|| ((i-1>=0 &&j+1<getLengthM() && getBoard()[i-1][j+1].getCanMove()  && getBoard()[i-1][j+1].getSinoro()==null )
    			|| (i+1<getLengthP() &&j-1>=0 && getBoard()[i+1][j-1].getCanMove()  && getBoard()[i+1][j-1].getSinoro()==null)))
    		return true;
    	
    	return false;
    }
	/**
	 * Afth h methodos aneparista graphika tin prosomoiosi.
	 * 
	 * H methodos katharizei ton kamva kai perimenei gia 1000ms. Thetei to scale tou kamva afinontas perithorio 1 gyro apo to plegma , thetei 
	 * to xrwma tis penas se mavro kai to radius sinartisi tou megethous tou mikous tou xwrou.
	 * H methodos kanei xrisi tis voihthikis methodou printGrid() pou ektiponei to plegma kai stin sinexeia diatrexdei ola ta kelia tou xwrou.
	 * Otan ena kelei exei molinthei legotero apo to infectionpercentage parousiazete ws kitrino enw an molinthike perisotero parousiazete
	 * ws portokali. Otan sto keli yparxei yparxei kapios anthropos ektyponete me blue ean exei anwsia, me kokkino ean exei molinthi kai me 
	 * prasino ean einai ygieis kai den exei anwsia. H methodos perimeni gia 1000ms kai telionei. An o athropos pernei katw apo 0.35 
	 * ektipwnete xrwma roz ,katw apo 0.66 ektipwnete xrwma xriso kai panw apo 0.66 light blue. Epiprostheta ena keli to opoio einai sinoro
	 * xerwis omos na einai molismenos parousiazete ws xrwma dark blue ,an exei molinthei legotero apo to infectionpercentage parousiazete ws
	 * purple enw an molinthike perisotero parousiazete ws Indigo(Pio skouro purple)
	 */
    
	public void Print() {
		
    	StdDraw.clear(StdDraw.WHITE);
    	
    	StdDraw.pause(1000);
    	
    	StdDraw.setXscale(-1,getLengthM());				
    	StdDraw.setYscale(-1, getLengthP());
    	StdDraw.setPenColor(StdDraw.BLACK);
    	
    	StdDraw.setPenRadius(0.34/(getLengthM()+5));
    	
    	printGrid();
    	
    	
    	for(int j=0; j<getLengthM(); j++)
    		for(int i=0; i<getLengthP(); i++) {
    			
    			if(board[i][j].getInfection()>0) {
    				if(board[i][j].getInfection()<=infectionPercentage/2 && board[i][j].getSinoro()==null) {
    					StdDraw.setPenColor(StdDraw.YELLOW);
    					StdDraw.filledSquare(i, j, 0.4);
    				}
    				else  if(board[i][j].getInfection()>infectionPercentage/2  && board[i][j].getSinoro()==null) {
    					StdDraw.setPenColor(StdDraw.ORANGE);
    					StdDraw.filledSquare(i, j, 0.4);
    				}
    			}
    			if(board[i][j].getInfection()==0.0 && board[i][j].getSinoro()!=null) {
    				StdDraw.setPenColor(new Color(0,0,139));  //Dark Blue
    				StdDraw.filledSquare(i, j, 0.4);
    			}
    			else if(board[i][j].getInfection()<=infectionPercentage/2 && board[i][j].getSinoro()!=null) {
    				StdDraw.setPenColor(new Color(128,0,128));  //Purple
    				StdDraw.filledSquare(i, j, 0.4);
    			}
    			else  if(board[i][j].getInfection()>infectionPercentage/2  && board[i][j].getSinoro()!=null) {
    				StdDraw.setPenColor(new Color(75,0,130)); //Indigo
    				StdDraw.filledSquare(i, j, 0.4);
    			}
    				
    			if(board[i][j].getHuman()!=null) {
    				if(board[i][j].getHuman().getAnwsia()) {
        				StdDraw.setPenColor(new Color(65,105,255)); //Royal Blue
        				StdDraw.filledCircle(i, j, 0.25);
        			}
    				
    			else if(board[i][j].getHuman().getSick()) {
    					StdDraw.setPenColor(StdDraw.RED);
    					StdDraw.filledCircle(i, j, 0.25);
    				}
    			
    			else if(!board[i][j].getHuman().getSick()) {
    					StdDraw.setPenColor(new Color(0,128,0)); //Green
    					StdDraw.filledCircle(i, j, 0.25);
    				}
    				
    		
    		
    	}
    			
    }
    	StdDraw.pause(1000);

}
    
    
 
   
        /**
        * Afth h voihthiki methodos ektiponei to plegma ston kamva.
        * 
        *  H methodos ektiponei kathetes kai orizonties me diafora 1. To plegma ektiponete me offset 0.5 gia na ektipononte sto kentro twn kelion oi anthropoi.
        */
        private void printGrid() {
	   
	          for(double line=-0.5; line<=getLengthM(); line++) {
			       StdDraw.line(line, getLengthM()-0.5, line, -0.5);
			       StdDraw.line(-0.5, line, getLengthM()-0.5, line);
	         	}
        }


       /**
       * H methodos dimioiurgei  statistika.
       * 
       *  H methodso diatrexei ola ta kelia kai vriskei to sinolo twn: arwston anthropwn, igieis anthropwn, arwston anthropwn kai arwston kelion.
       *  Telos epistrefei ena pinaka me ta statistika.
       */
       public int[] statistics() {
	         int sickP=0,anwsP=0,igieisP=0,sickCells=0;
	        
			 
	         for(int j=0;j<getLengthM();j++)
		         for(int i=0;i<getLengthP();i++) {
		          if(board[i][j].getHospital()==null && board[i][j].getQuarantine()==null)	 {
			         if(board[i][j].getInfection()>0.0)
				       sickCells++;
			         if(board[i][j].getHuman()!=null ) {
				 
				     if(board[i][j].getHuman().getAnwsia())
					   anwsP++;
				     else if(!board[i][j].getHuman().getSick())
				    	 igieisP++;
				     else  
					   sickP++;
				     
				   
			   }
		          }
		   }
	       int x=this.hospitalCell.getPoint().getX();
	       int y= this.hospitalCell.getPoint().getY();  
	       int inHospital=board[y][x].getHospital().getNosuntes(); 
	       x=this.quarantineCell.getPoint().getX();
	       y= this.quarantineCell.getPoint().getY();  
	       int inQuarantine=board[y][x].getQuarantine().getNosuntes(); 
	       
	       
	      
	       int res[]= {igieisP,sickP,anwsP,inHospital,inQuarantine};
	       return res;
      }
       /**
        * Inarthsh pou ektipwnei ta statistika gia th xwra.
        * 
        */
       public void printStatistics() {
    	   System.out.println(this.getName());
    	   System.out.println();
    	   int c[]=this.statistics();
    	   System.out.println("Anthrwpoi igieis: "+ c[0]);
	       System.out.println("Arrwstoi anthrwpoi: "+ c[1]);
	       System.out.println("Anthrwpoi me anwsia: "+ c[2]);
	       System.out.println("Arwstoi anthrwpoi sto Nosokomeio: "+ c[3]);
	       System.out.println("Arwstoi anthrwpoi sth karantina : "+ c[4]);
       }
       
    /** 
     * H methodos epistrefei diathesima kelia gia tin dimiourgia sinoron.
     * 
     * H methodos epilegei tixea mia apo tis 4 plevres tou pediou kai molis vrei number sinexomena kelia ta opoia den einai sinora ta epistrefei 
     * ws Points mesa se ena pinaka.
     * 
     * Ean h plevra pou epilexthike den exei diathesima kelia tote dokimazete mia alli plevra. An oles oi plevres einai gemates tote h methodos
     * epistrefei null.
     * 
     * @return Epistrefei pinaka apo points an yparxoun diathesima kelia gia dimiourgia sinoron kai null an oxi
     */

    public Point[] createRandomwithN(int number) {
 	   
 		Boolean Left=false, Right=false , Up=false , Down=false;
 		int inRow;
 		do {
 			int side = (int)(Math.random()*4);
 		
 			switch(side) {
 				case 0:  //Left
 					Left=true;
 					inRow=0;
 					for(int y=0;y<getLengthP();y++) {
 						if(board[y][0].getSinoro()==null && board[y][0].getHospital()==null &&board[y][0].getQuarantine()==null)
 							inRow++;
 						else
 							inRow=0;
 						
 						if(inRow==number) {
 							Point[]result=new Point[number];
 							
 							for(int i=0;i<number;i++) {
 								result[i]=new Point(y-i,0);
 								
 							}
 							
 							return result;
 						}
 					}
 					break;
 					
 				case 1: //Up
 					Down = true;
 					inRow=0;
 					for(int x=0;x<getLengthM();x++) {
 						if(board[0][x].getSinoro()==null && board[0][x].getHospital()==null &&board[0][x].getQuarantine()==null)
 							inRow++;
 						else
 							inRow=0;
 						if(inRow==number) {     
 							Point[]result1=new Point[number];
 							
 							for(int i=0;i<number;i++) {
 								result1[i]=new Point(0,x-i);
 								
 							}
 							
 							return result1;
 						}
 					}
 					break;
 					
 					
 				case 2: // Right
 					Right = true;
 					inRow=0;
 					for(int y=0;y<getLengthP();y++) {
 						if(board[y][getLengthM()-1].getSinoro()==null && board[y][getLengthM()-1].getHospital()==null &&board[y][getLengthM()-1].getQuarantine()==null)
 							inRow++;
 						else
 							inRow=0;
 						
 						if(inRow==number) {
 							Point[]result2=new Point[number];
 							
 							for(int i=0;i<number;i++) {
 								result2[i]=new Point(y-i,getLengthP()-1);
 							
 							}
 							
 							return result2;
 						}
 					}
 					break;
 					
 				case 3: //Down
 					Up = true;
 					inRow=0;
 					for(int x=0;x<getLengthM();x++) {
 						if(board[getLengthP()-1][x].getSinoro()==null && board[getLengthP()-1][x].getHospital()==null &&board[getLengthP()-1][x].getQuarantine()==null )
 							inRow++;
 						else
 							inRow=0;
 						if(inRow==number) {
 							Point[]result3=new Point[number];
 							
 							for(int i=0;i<number;i++) {
 								result3[i]=new Point(getLengthM()-1,x-i);
 								
 							}
 							
 							
 							return result3;
 						}
 					}
 					break;
 				}
 			
 		}while(!Left || !Right || !Up || !Down);
 		
 		return null;
 	}
     /**
      * Me avth th methodo vazw sinora se  sigkekrimena kelia pou vriskontai sto pinaka a1 kai exun sxesh-link me ta avta tu pinaka a2.
      * 
      * @param from h xwra/Field sth opoia vriskomai
      * @param to h xwra/Field pou tha paw
      * @param a1 einai enas pinakas (me 3 stoixeia) apo points kai exei ta points -shmeia ths xwras mu ta opoia tha ginunun sinora
      * @param a2 einai enas pinakas (me 3 stoixeia) apo points kai exei ta points -shmeia ths xwras to dhladh otan thamai se kapoio sinoro diko mu tha metaferwmai sto antistoixo sinoro ths xwras to.
      */
      
    public void setSinoro(int from, int to, Point[] a1, Point[] a2,int number) {
    	
   		for(int i=0;i<number;i++) {
   			int x1 = a1[i].getX();
   			int y1 = a1[i].getY();
   			
   			board[y1][x1].addSinoro(from, to, a2[i]);
   		}
   		
   	}
     /**
      * H methodos epistrefei ton arithmo twn antikeimenon field pou dimiourgithikan.
      * 
     * @return int
     */
    public static int getCount() {
    	 return count;
     }

}
