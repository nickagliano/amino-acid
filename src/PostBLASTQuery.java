import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

public class PostBLASTQuery {

   public static final String SERVICELOCATION="https://www.rcsb.org/pdb/rest/postBLAST";
   
   public static void doMagic(String sequence) throws FileNotFoundException {
	  
	  PrintWriter pw = new PrintWriter(new File("blastresult.txt"));
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
         StringBuffer answer = new StringBuffer();
         BufferedReader in = new BufferedReader( new InputStreamReader( conn.getInputStream()) );
         String line;
         while ( (line = in.readLine()) != null ) {
            answer.append(line + "\n");
         }
         in.close();
            
         pw.write(answer.toString());
         pw.close();
      }
      catch (Exception ex) {
         ex.printStackTrace();
      }

    }
}  