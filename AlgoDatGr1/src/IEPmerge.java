import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;



public class IEPmerge {
	public String iepPath;
	public String uniprotPath;
	public String mapPath;
	public HashMap<String, IEPMap> mappermap=new HashMap<>();
	public BufferedWriter bw;
	
	public IEPmerge( String iepPath,String uniprotPath,String mapPath){
		this.iepPath=iepPath;
		this.uniprotPath=uniprotPath;
		this.mapPath=mapPath;
		IEPeinlesen();
		Mapeinlesen();
		Uniproteinlesen();
		Schreiben();
	}
	
	public static void main(String[] args) {
	@SuppressWarnings("unused")
	IEPmerge test=new IEPmerge("./Rohdaten/result.csv", "./Rohdaten/gruppe1.csv", "./Rohdaten/UniprotUmwandler.tab");
	
	}

	public void IEPeinlesen(){
	try {
	    BufferedReader in = new BufferedReader(new FileReader(iepPath)); 
	    String Zeile; 
	    //System.out.println("Hallo");
	    while (( Zeile=in.readLine()) != null){
	     String[] splitted =Zeile.split(",");
	     String[] kName= splitted[0].split(" ");
	     String kName2=kName[0].substring(1, kName[0].length());
	    if (splitted.length>3) {
			 mappermap.put(kName2, new IEPMap(kName2, splitted[1], splitted[3], splitted[2]));
			 //System.out.println(kName2);
		}
	    
	    }
	    in.close();
	}
	catch (IOException e) {
	System.out.println("ERROR:Einlesefehler bei IEP");}
	}
	

 public void Mapeinlesen(){
	 try {
		    BufferedReader in = new BufferedReader(new FileReader(mapPath)); 
		    String Zeile;
		    while (( Zeile=in.readLine()) != null){
		    	//System.out.println(Zeile);
				     String[] splitted =Zeile.split("\t");
				     if (mappermap.containsKey(splitted[0])) {
				     mappermap.get(splitted[0]).setUnipprotID(splitted[1]) ;
				     System.out.println(splitted[1]);
				    }
			    }
		    in.close();
	 } catch (IOException e) {
		System.out.println("ERROR:Einlesefehler bei Map");}	 
 }
 
 public void Uniproteinlesen(){
	 try {
		    BufferedReader in = new BufferedReader(new FileReader(uniprotPath)); 
		    String Zeile;
		    while (( Zeile=in.readLine()) != null){
				     String[] splitted =Zeile.split("\t");
				     //System.out.println(splitted[0]);
				     for (String key:mappermap.keySet()) {
				    	 try{
				   if (mappermap.get(key)!=null) {	
					//System.out.println(mappermap.get(key).getUnipprotID()!=null);
					if(	mappermap.get(key).getUnipprotID().contains(splitted[0])){
						mappermap.get(key).setCount(splitted[1]);}
					}}catch (Exception e) {
						
						//e.printStackTrace();
					}
				}
				   }
			    
		    in.close();
	 } catch (IOException e) {
		System.out.println("ERROR:Einlesefehler bei Map");}	 
 }
 public void Schreiben(){
	 try{
		 System.out.println("schreib...");
		 bw =new BufferedWriter( new PrintWriter("./Rohdaten/IEPMerge.csv"));
		 bw.write("UniprotID"+"\t"+"IEPID"+"\t"+"IEP"+"\t"+"count"+"\t"+"Molekulargewicht"+"\t"+"Sequence");
	 for (String key:mappermap.keySet()) {
		 bw.write(mappermap.get(key).toString()+"\n");
	 }
	 
	 
	 }catch (Exception e) {
			System.out.println("Schreibefehler");
			}
		 System.out.println("....schrieb");
	 }
 }
