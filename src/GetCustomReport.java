import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.HttpURLConnection;


public class GetCustomReport
{
   
   public static final String SERVICELOCATION="http://www.rcsb.org/pdb/rest/customReport";
   
   public static void doMagic(String[] idArr){

      String qstr = "?pdbids="+ printIds(idArr) + "&customReportColumns=structureId,macromoleculeType,classification,sequence,kabschSander&format=csv&service=wsfile";
      
      try {
         getResult(qstr);       
      }
      catch (Exception e)
      {
      	 System.out.println("Error: " + e.getMessage());
      }
   }
   
   private static String printIds(String[] idArr) {
	String str = "";
	for(int i=0;i<idArr.length;i++){
		if(i==idArr.length-1){
			str = str + idArr[i];
			return str;
		}
		str = str + idArr[i] + ",";
	}
	return str;
}

public static void getResult(String qstr) throws IOException
   {
      String urlStr = SERVICELOCATION+qstr;
      
      URL url = new URL(urlStr);
      
      HttpURLConnection conn =
          (HttpURLConnection) url.openConnection();
      
      if (conn.getResponseCode() != 200) {
         throw new IOException(conn.getResponseMessage());
       }

       // Buffer the result into a string
       BufferedReader rd = new BufferedReader(
           new InputStreamReader(conn.getInputStream()));
       StringBuilder sb = new StringBuilder();
       String line;
       while ((line = rd.readLine()) != null) {
         sb.append(line+"\n");
       }
       rd.close();
       conn.disconnect();
       
       PrintWriter pw = new PrintWriter(new File("blastresult.csv"));
       pw.write(sb.toString());
       pw.close();
     }
}