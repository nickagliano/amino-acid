import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

public class PostBLASTQuery {

   public static final String SERVICELOCATION="https://www.rcsb.org/pdb/rest/postBLAST";
   
   public static void main(String[] args) {

      String param1 = "sequence=VLSPADKTNVKAAWGKVGAHAGEYGAEALERMFLSFPTTKTYFPHFDLSHGSAQVKGHGKKVADALTAVAHVDDMPNAL";
      String param2 = "eCutOff=10.0";     
      String param3 = "matrix=BLOSUM62"; 
      String param4 = "outputFormat=HTML";  // HTML or XML. If not specified, default to plain text 
 
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
            //answer.append(line);
        	 System.out.println(line);
         }
         in.close();
            
         // Output the response
         //System.out.println(answer.toString());
      }
      catch (Exception ex) {
         ex.printStackTrace();
      }

    }
}  