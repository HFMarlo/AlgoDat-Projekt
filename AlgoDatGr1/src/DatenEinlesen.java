import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;




public class DatenEinlesen {
	//Vars
	static HashMap<String, ProteinMap> mappingMap = new HashMap<>();
	public BufferedWriter bw;
	
	//Constructor (ungenutzt)
	public DatenEinlesen() {	
	}
	
public static void main(String[] args){
	DatenEinlesen Test=new DatenEinlesen(); //Durchführung als test
			Test.ExcelData();
			Test.UniProtData();
}
	public void ExcelData (){//Auslesen der Exceltabelle als csv mit tabs getrennt und einspeichern in Hashmap (mappingMap)
		try {
	    BufferedReader in = new BufferedReader(new FileReader("./Rohdaten/gruppe1.csv")); 
	    String Zeile;
	    while (( Zeile=in.readLine()) != null){
	     String[] splitted =Zeile.split("\t");
	     mappingMap.put(splitted[0], new ProteinMap(splitted[0], splitted[1]));
	    }
	    in.close();
	    
//	    for(Entry<String,ProteinMap> e : mappingMap.entrySet()){
//	    	System.out.println(e.getKey()+","+e.getValue().count);
//	    }
	   
	} catch (IOException e) {
	System.out.println("ERROR:Einlesefehler");}
	
	}

	public void UniProtData (){		//Einlesen von Uniprot schreiben()
		try {
		    BufferedReader in = new BufferedReader(new FileReader("./Rohdaten/uniprot-yourlist%3AM2017100483C3DD8CE55183C76102DC5D3A26728BEC41F24.tab"));
		   bw =new BufferedWriter( new PrintWriter("./Rohdaten/DatenMerge.txt"));
		    String Zeile;
		    while (( Zeile=in.readLine()) != null ){
		     String[] splitted =Zeile.split("\t");
		     if (mappingMap.containsKey(splitted[7])) {
				mappingMap.get(splitted[7]).setNeuID(splitted[0]);
				//Schreiben
				Schreiben(splitted);
			}
		    
		    }
		    in.close();
		    bw.flush();	
			bw.close();
//		    for(Entry<String,ProteinMap> e : mappingMap.entrySet()){
//		    	System.out.println(e.getKey()+","+ e.getValue().neuID+","+e.getValue().count);
//		    }
		   
		} catch (IOException e) {
		System.out.println("ERROR:Einlesefehler");}
		
		
	}
	
	public void Schreiben(String[] UniProtdata){//ausschreiben der Daten von Uniprot+Hashmap in neue Datei: Datenmerge
		
		try {
			
			for (int i = 0; i < UniProtdata.length; i++) {
				bw.write(UniProtdata[i]+ "\t");
				System.out.print(UniProtdata[i] + "\t");
			}
			bw.write(mappingMap.get(UniProtdata[7]).getCount()+"\n");
			//bw.newLine();
					System.out.println();
				
		} catch (Exception e) {
			System.out.println("Schreibefehler");		}
		
		
	}
}
