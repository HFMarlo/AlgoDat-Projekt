import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;



public class DatenEinlesen {
	static HashMap<String, ProteinMap> mappingMap = new HashMap<>();
public static void main(String[] args){
	DatenEinlesen Test=new DatenEinlesen();
			Test.ExcelData();
	Test.UniProtData();
}
	public void ExcelData (){
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

	public void UniProtData (){
		try {
		    BufferedReader in = new BufferedReader(new FileReader("./Rohdaten/uniprot-yourlist%3AM2017100483C3DD8CE55183C76102DC5D3A26728BEC41F24.tab"));
		    String Zeile;
		    while (( Zeile=in.readLine()) != null ){
		     String[] splitted =Zeile.split("\t");
		     if (mappingMap.containsKey(splitted[7])) {
				mappingMap.get(splitted[7]).setNeuID(splitted[0]);
			}
		     
		    }
		    in.close();
		    
		    for(Entry<String,ProteinMap> e : mappingMap.entrySet()){
		    	System.out.println(e.getKey()+","+ e.getValue().neuID+","+e.getValue().count);
		    }
		   
		} catch (IOException e) {
		System.out.println("ERROR:Einlesefehler");}
		
		
	}

}
