package ChristodoulouPanagiotis.tk;
/**
 * Antikeimeno pou mas dixnei gia kapoion an asthenei.
 * Apoteleitai apo to an exei ton io,poses meres ton exei,an emfanisthkan ta simptwmata tu,kai an einai sto nosokomeio-pote mphke sto nosokomeio.
 * 
 * @author pchris19
 *
 */
public class Patient {
	private boolean sick;//an exei ton io
	private int days;//poses meres ton exei ton io
	private boolean emfanish;// an emfanisthke pws einai arrwstos
	private int hospitalTime;// o kathe anthrwpos an mphke  sto nosokomeio ginete 1 an den mphke einai -1
	
	public Patient(boolean s) {
		sick=s;
		days=0;
		emfanish=false;	
		hospitalTime=-1;
	}
	/**
	 * sinarthsh pu kanei ton anthrwpo arrwsto.
	 * 
	 */
	public void setSick() {
		sick=true;
		days=1;
		emfanish=false;
	}
	/**
	 * Sinarthsh pou kanei ton anthrwpo igih.
	 * 
	 */
	public void setHealthy(){
		sick=false;
		days=0;
		emfanish=false;
	}
	/**
	 * Arxikopoiei to oti mphke sto nosokomeio me 1.
	 * 
	 * @param r
	 */
	public void initializeHospitalTime() {
		hospitalTime=1;
	}
	/**
	 * epistrefei thn wra pu mphke sto nosokomeio.
	 * 
	 * @return
	 */
	public int getHospitalTime() {
		return hospitalTime;
	}
	/**
	 * Ektele kai elegxei an exei simptwmata
	 * dhladh an exei ton io apo 2 mexri 5 meres elegxei me psevdotixeo tropo an tha emfanistei kai an ton exei panw apo 5 meres tote emfanizete sigura o ios.
	 * 
	 */
	public void setEmfanish() {
		
		 if(days>5) {
			emfanish=true;
			return;}
		int a=(int) (Math.random()*4) +2; //mporei nane 2,3,4,5 meres
		if(a<=days) //an exun perasei o tixeos arithmos gia tis meres emfanishs tus iu tote emfanizete
			emfanish=true;
	}
	/**
	 * Prosthetei mia mera apotaneixe ton io.
	 * 
	 */
	public void addDay() {
		
		     days++;
	}
	/**
	 * Prosthetei ena round apotan mphke sto nosokomeio.
	 * 
	 * 
	 */
	public void addHospitalRound() {
		
		     days++;
	}

	/**
	 * Epistrefei an exei ton io.
	 * 
	 * @return
	 */
	public boolean getSick() {
		return sick;
	}
	
    /**
     * Epistrefei an emfanise simptwmata gia ton io.
     * 
     * @return
     */
	public boolean getEmfanish() {
		return this.emfanish;
		
	}
	
	

}
