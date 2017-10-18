import java.util.ArrayList;
import java.util.HashMap;

public class Protein {

 public String IdentifierExp;
 public String IdentifierDB;
 public String Proteinname;
 public String Organismus;
 public String GenName;
 public String Beschreibung;
 public String Fasta;
 
 public ArrayList<String> Codon=new ArrayList<String>();
 public HashMap <Character, Integer> AS= new HashMap<>();
 public  int Länge=0;
  
 public Protein(String IdentifierExp,
 String IdentifierDB,
 String Proteinname,
 String Organismus,
 String GenName,
 String Beschreibung,
 String Fasta,
 int Länge){
	 this.IdentifierExp=IdentifierExp;
	 this.IdentifierDB=IdentifierDB;
	 this.Proteinname=Proteinname;
	 this.Organismus=Organismus;
	 this.GenName=GenName;
	 this.Beschreibung=Beschreibung;
	 this.Fasta=Fasta;
	 this.Länge= Länge;
	
	//Codons berechnen
	Codonrechner();
	Aminosäurezähler();
	
	}
	
public void Codonrechner(){
	int Textindex=0; //zählt Fortschritt im Text
	for (int i = 0; i < Fasta.length(); i++) {
		if (Textindex>Fasta.length()) {
			break;
		}
			Codon.add(Fasta.substring(Textindex, Math.min(Textindex+3,Fasta.length())));
				//System.out.println(Textindex);
				//System.out.println(Codon.get(i));
				Textindex +=3;
				
	}
	
}
 

 public void Aminosäurezähler(){
	 char MomAS;
	for (int i = 0; i < Fasta.length(); i++) {
		MomAS=Fasta.charAt(i);
		if(AS.get(MomAS)==null){
			AS.put(MomAS, 1);
		}
		else {
			AS.put(MomAS, AS.get(MomAS)+1);
		}
	}
 }
 
 
 public static void main(String[] args) {
	Protein testusteron= new Protein("Inden1", "Iden2", "Testus", "Java", "Javagen", "Test", "AJSNFISHAKFIEHAOFBNEJSBAIFJEABJABNFJIIWQW", 345);
	char lül;
	for (int i = 0; i < 26; i++) {
		lül=(char) (i+65);
		System.out.print( lül+" : ");
		if (testusteron.AS.get(lül)!=null) {
			System.out.println(testusteron.AS.get(lül));
		}
		else{System.out.println( "0");}
		//try{System.out.println(testusteron.Codon.get(i));}
		//finally{}
	}
	}
}
