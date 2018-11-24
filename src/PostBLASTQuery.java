import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

public class PostBLASTQuery {

   public static final String SERVICELOCATION="https://www.rcsb.org/pdb/rest/postBLAST";
   
   
   public static String[] doMagic(String sequence) throws FileNotFoundException {
	  
	  String[] idArr = new String[10]; //where the first n sequences will be stored
      String param1 = "sequence="+sequence; //runs blast on the sequence passed in
      String param2 = "eCutOff=1.0";     
      String param3 = "matrix=BLOSUM62"; 
      String param4 = "outputFormat=HTML"; 
      
      try {
         // Send the request 
         URL url = new URL(SERVICELOCATION);
         URLConnection conn = url.openConnection();
         conn.setDoOutput(true); 
         BufferedWriter out = new BufferedWriter( new OutputStreamWriter( conn.getOutputStream()) );
            
         // Write parameters 
         out.write(param1);
         out.write("&");
         out.write(param2);
         out.write("&");
         out.write(param3);
         out.write("&");
         out.write(param4);
         out.flush();
         out.close();
         
         // Get the response
         
         BufferedReader in = new BufferedReader( new InputStreamReader( conn.getInputStream()) );
         String line;
         while ( (line = in.readLine()) != null ) {
            if (line.startsWith("Sequences producing significant alignments")){
            	line = in.readLine(); //skip the blank line
    			for(int i=0;i<10;i++){
    				if (in.readLine()==null) return idArr;
    				line = in.readLine();
    				if(line.startsWith("<")) return idArr; //out of ids
    				if(line.length()>4){
    					idArr[i] = line.substring(0,4); //grabs the id
    				}
    			}
    			in.close();
    			return idArr;
            }
         }
         
      }
      catch (Exception ex) {
         ex.printStackTrace();
      }
      return idArr;
    }
}  