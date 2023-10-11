package ChristodoulouPanagiotis.tk;


/**
 * Antiprosopevei ena keli tu pinaka field.
 * Apoteleitai apo to object sinoro,human,canMove,infection.
 * 
 * @author npapak01 & pchrist19
 *
 */
public class Cell {
        private Sinoro sinoro;
		private Human human;
		private boolean canMove;
		private double infection;
		private QuarantineZone quarantine;
		private Hospital hospital;
	
	/**
	 * O default kataskevastis pou thetei ta pedia stis default times.
	 */
	public Cell() {
		sinoro=null;
        quarantine=null;
		hospital=null;
        human=null;
		
		canMove=true;
		
		infection=0.0;
		
	}
	/**
	 * prosthetei th zwnh karantinas se avto to keli.
	 * 
	 * @param cap to megethos twn atomwn pou mporei na filoxenhsei avth h arantina.
	 */
	public void addQuarantine(int cap) {
		quarantine =new QuarantineZone(cap);
	}
	/**
	 * Epistrefei th zwnh karantinas.
	 * 
	 * @return
	 */
	public QuarantineZone getQuarantine() {
		return quarantine;
	}
	/**
	 * Prosthetei nosokomeio sto keli.
	 * 
	 * @param c
	 */
	public void addHospital(int c) {
		hospital=new Hospital(c);
	}
	/**
	 * Epistrefei to nosokomeio.
	 * 
	 * @return
	 */
	public Hospital getHospital() {
		return hospital;
	}
	
	/**
	 * Epistrefei to antikeimeno sinoro an den exw sinoro savto to keli epistrefei null afu etsi thani to sinoro.
	 * 
	 * @return epistrefei antikeimeno Sinoro
	 */
	public Sinoro getSinoro() {
		return sinoro;
	}
	
	/**
	 * Afti h methodos mas epistrefei ean ena keli exei molinthi h oxi.
	 * 
	 * @return boolean
	 */
	public boolean isInfected() {
		if(this.infection>0.0)
			return true;
		
		return false;
	}


    /**
     * Afth h methodos mas epistrefei to antikeimeno human pou vriskete sto keli. 
     *
     * @return Human
     */
    public Human getHuman() {
	     return human;
    }

    /**
     * Afth h methodos mas epistrefei to pedio canMove tou keliou.Epishs an avto to keli einai nosokomeio h mero Karantinas tote epistrefei false
     * afu den mporei na paei anthrwpos se avta.
     * 
     * @return boolean
     */
    public boolean getCanMove() {
    	if(this.hospital!=null || this.quarantine!=null)
    		return false;
    	 return canMove;
    }

    /**
     * Afth h methodos epistrefei to pososto molinsis sto keli.
     * 
     * @return double
     */
    public double getInfection() {
    	return infection;
    }

    /**
     * Afth h methodos thetei enan anthropo sto keli.
     * 
     * H methodos dexete ws parametro ena human kai efoson mporei na kinithei sto keli tote ton metakini kai thetei pws to keli einai gemato
     * 
     * @param human h
     * @return H methodos kanei return true an mporese na metakinisi ton anthropo sto keli kai false an oxi
     */
    public boolean setHuman(Human h) {
    	   
    	 if(this.getCanMove()){
    		   
    		   human=h;
    		   this.setFull();
    		   return true;
    	   }
    	   return false;

   }
    public void setHumanForSinoroSwap(Human h) {
    	   
    	   human=h;
		   this.setFull();
    	
    }
     
    /**
     * Afth h methodos thetei sto pedio infection tin timi tis parametrou i.
     * 
     * @param i
     */
    public void setInfection(double i) {
    	 this.infection=i;

   }
       
    /**
     * Afth h methodos thetei to pedio canMove se true. 
     */
    public void setFree() {
    	 this.canMove=true;
   }
       
    /**
     * Afth h methodos aferei ton anthropo apo to keli kai thetei to pedio human se null.
     */
    public void removeHuman() {
    	   human=null;
       }
       
       
    /**
     * Afth h methodos thetei pws to keli yparxei eidi anthropos.
     * 
     * H methodos thetei to pedio canMove se false.
     */
    public void setFull() {
    	   this.canMove=false;
       }
    /**
     * Me avth th sinoro dhmiourgw ena neo sinoro gia avto to keli 
     * 
     * @param from se poia xwra tha einai to sinoro
     * @param to se poia xwra tha me phgainei to sinoro
     * @param destination se poio sigkekrimeno point tha me phgainei to sinoro (tipou point)
     */
	public void addSinoro(int from,int to, Point destination) {
		
		sinoro = new Sinoro(from, to, destination);	
	}



}
