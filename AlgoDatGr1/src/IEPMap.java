

public class IEPMap {
	

	//IEP Daten
	public String iepid;
	public String sequence;
	public String iep;
	public String molweight;

	

	//Uniprot
	public String unipprotID; //==Name des Hashmap codes
	public String  count;
	
	public IEPMap(String iepid, String seq, String iep, String molweight) {
		this.iepid=iepid;
		this.sequence=seq;
		this.iep=iep;
		this.molweight=molweight;		
	}	
	//Getter und Setter
	public String getIepid() {
		return iepid;
	}

	public void setIepid(String iepid) {
		this.iepid = iepid;
	}

	public String getSequence() {
		return sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}

	public String getIep() {
		return iep;
	}

	public void setIep(String iep) {
		this.iep = iep;
	}

	public String getMolweight() {
		return molweight;
	}

	public void setMolweight(String molweight) {
		this.molweight = molweight;
	}

	public String getUnipprotID() {
		return unipprotID;
	}

	public void setUnipprotID(String unipprotID) {
		this.unipprotID = unipprotID;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}
	public String toString(){
		return unipprotID+"\t"+iepid+"\t"+iep+"\t"+count+"\t"+molweight+"\t"+sequence;
	}
}

	
	
	


