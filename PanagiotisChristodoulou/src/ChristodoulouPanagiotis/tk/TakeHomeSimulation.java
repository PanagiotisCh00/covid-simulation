package ChristodoulouPanagiotis.tk;
/**
 * H kiria sinarthsh ths prosomoiwshs, dhmiourghsa eidiki sinarthsh sth ExtendedField gia na dimiurghsw ena extendedField me 
 * ta dedomena pu mas dinete sth askhsh.
 * 
 * @author pchris19
 *
 */ 

public class TakeHomeSimulation {
	public static void main(String args[]) {
		ExtendedField f=new ExtendedField();
		f.TakeHomeSimulation(10);//Therw pws h molinsh einai 10%
		int c=20;//o arithmos kata ton opoio tha ginei h prosomoiwsh se meres
		int coronaCheck=1;//Kathe pote tha kanume to test gia to koronoio, apofasisa na ginete kathe mera me th lixh ths meras dhl h wra 24:00.
		//Tha ton metatrepsw se lepta gia na kanei run to simulation (1 lepto ena vhma)
		int k=0;
		System.out.println("Arxika statistika");
		f.generalStatistics();
		for(int i=0;i<c*48;i++) {
			System.out.println();
			System.gc();
			System.out.println("Round "+f.getRound());
			System.out.println();
			f.nextGeneration();
			System.out.println();
            
			k++;
		}
		System.out.println("Telika statitistika");
		f.generalStatistics();
		System.out.println("End");
		
	}

}
