import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;


public class PostXMLQuery
{

   public static final String SERVICELOCATION="http://www.rcsb.org/pdb/rest/search";

   
   
   public static void main(String[] args){

      String xml =
         "<orgPdbCompositeQuery version=\"1.0\">"+

         " <queryRefinement>"+

         "  <queryRefinementLevel>0</queryRefinementLevel>"+

         "  <orgPdbQuery>"+
         "    <queryType>org.pdb.query.simple.SequenceQuery</queryType>"+

         "    <description><![CDATA[Sequence Search (Structure:Chain = 1HIV:A, Expectation Value = 10.0, Search Tool = blast)]]></description>"+
         "    <structureId><![CDATA[1HIV]]></structureId>"+
         "    <chainId><![CDATA[A]]></chainId>"+

         "    <sequence><![CDATA[PQVTLWQRPLVTIKIGGQLKEALLDTGADDTVLEEMSLPGRWKPKMIGGIGGFIKVRQYDQILIEICGHKAIGTVLVGPTPVNIIGRNLLTQIGCTLNF]]></sequence>"+
         "    <eCutOff><![CDATA[10.0]]></eCutOff>"+
         "    <searchTool><![CDATA[blast]]></searchTool>"+

         "  </orgPdbQuery>"+

         " </queryRefinement>"+
         " <queryRefinement>"+

         "  <queryRefinementLevel>1</queryRefinementLevel>"+
         "  <conjunctionType>and</conjunctionType>"+

         "  <orgPdbQuery>"+

         "    <queryType>org.pdb.query.simple.ExpTypeQuery</queryType>"+
         "    <description><![CDATA[Experimental Method Search: Experimental Method=X-RAY]]></description>"+
         "    <runtimeMilliseconds>1389</runtimeMilliseconds>"+

         "    <mvStructure.expMethod.value><![CDATA[X-RAY]]></mvStructure.expMethod.value>"+
         "  </orgPdbQuery>"+

         " </queryRefinement>"+

         "</orgPdbCompositeQuery>" ;
      
      
         PostXMLQuery t = new PostXMLQuery();

         try {
            List<String> pdbIds = t.postQuery(xml);

            for (String string : pdbIds)
            {
               System.out.println(string);

            }
         } catch (Exception e){
            e.printStackTrace();

         }
         
   }
   
   /** post am XML query (PDB XML query format)  to the RESTful RCSB web service
    * 
    * @param xml
    * @return a list of PDB ids.
    */
   public List<String> postQuery(String xml) throws IOException{

      URL u = new URL(SERVICELOCATION);

      String encodedXML = URLEncoder.encode(xml,"UTF-8");

      InputStream in =  doPOST(u,encodedXML);
      
      List<String> pdbIds = new ArrayList<String>();

      BufferedReader rd = new BufferedReader(new InputStreamReader(in));

      String line;
      while ((line = rd.readLine()) != null) {

        pdbIds.add(line);
         
      }      
      rd.close();
    
      return pdbIds;   
   }
   
   /** do a POST to a URL and return the response stream for further processing elsewhere.
    * 
    * 
    * @param url
    * @return
    * @throws IOException
    */
   public static InputStream doPOST(URL url, String data)

   throws IOException 
   {

   // Send data
      
      URLConnection conn = url.openConnection();

      conn.setDoOutput(true);
      
      OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());

      wr.write(data);
      wr.flush();

  
      // Get the response
      return conn.getInputStream();
                
   }
}