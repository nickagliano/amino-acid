import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.util.regex.Pattern;
import java.net.HttpURLConnection;


public class GetCustomReport
{
   
   public static final String SERVICELOCATION="http://www.rcsb.org/pdb/rest/customReport";
   
   public static int[] doMagic(String[] idArr){

      String qstr = "?pdbids="+ printIds(idArr) + "&customReportColumns=structureId,macromoleculeType,classification,sequence,kabschSander&format=csv&service=wsfile";
      int[] count = new int[2];
      count[0] = 0;
      count[1] = 0;
      try {
         count = getResult(qstr);   
         
      }
      catch (Exception e)
      {
      	 System.out.println("Error: " + e.getMessage());
      }
      return count;
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

public static int[] getResult(String qstr) throws IOException
   {
      String urlStr = SERVICELOCATION+qstr;
      int[] counter = new int[2];
      int dnaCount = 0;
      int rnaCount = 0;
      URL url = new URL(urlStr);
      
      HttpURLConnection conn =
          (HttpURLConnection) url.openConnection();
      
      if (conn.getResponseCode() != 200) {
         throw new IOException(conn.getResponseMessage());
       }

       // Buffer the result into a string
       BufferedReader rd = new BufferedReader(
           new InputStreamReader(conn.getInputStream()));
     //  StringBuilder sb = new StringBuilder();
       String line;
       while ((line = rd.readLine()) != null) {
       
    	 String[] tokens = line.split(",");
    	 line = tokens[2] + tokens[3];
         if(Pattern.compile(Pattern.quote("dna"), Pattern.CASE_INSENSITIVE).matcher(line).find()){
        	 dnaCount++;
         }
         if(Pattern.compile(Pattern.quote("rna"), Pattern.CASE_INSENSITIVE).matcher(line).find()){
        	 rnaCount++;
         }
       }
       rd.close();
       conn.disconnect();

       counter[0] = dnaCount;
       counter[1] = rnaCount;
       return counter;
     //  PrintWriter pw = new PrintWriter(new File("blastresult.csv"));
      // pw.write(sb.toString());
      // pw.close();
     }
}