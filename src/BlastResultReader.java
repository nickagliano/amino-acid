import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BlastResultReader  {

	public static String[] getIds(int n) throws IOException{ //pass in the number of sequences you want to grab
	
	BufferedReader br = new BufferedReader(new FileReader("blastresult.txt"));
	
	String line = "";
	String[] idArr = new String[n]; //where the first n sequences will be stored
	
	while ((line = br.readLine()) != null) {
		
		if(line.startsWith("Sequences producing significant alignments")){ //find where blastresult starts listing sequence id's
			line = br.readLine(); //skip the blank line
			for(int i=0;i<n;i++){
				line = br.readLine();
				idArr[i] = line.substring(0,4); //grabs the id
			}
		}
	}
	br.close();
	return idArr;
	}
}