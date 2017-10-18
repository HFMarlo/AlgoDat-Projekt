
public class ProteinMap {
	//Altes Doc
public String altID;
public String neuID;
public String count;
	

public ProteinMap (String alt, String count){
	altID=alt;
	this.count=count;
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
 public void setNeuID(String neueID){
	 neuID=neueID;
 }
 public String getNeueID(){
	 return neuID;
 }
 public String getAlteID(){
	 return altID;
 }
 public String getCount(){
	 return count;
 }
}
