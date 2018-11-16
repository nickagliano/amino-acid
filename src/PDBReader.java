import java.util.List; import
org.biojava.nbio.structure.Chain; import
org.biojava.nbio.structure.Group; import
org.biojava.nbio.structure.GroupType; import
org.biojava.nbio.structure.Structure; import
org.biojava.nbio.structure.io.FileParsingParameters; import
org.biojava.nbio.structure.io.PDBFileReader; import
org.biojava.nbio.structure.io.LocalPDBDirectory.FetchBehavior;

public class PDBReader {

   public static void main(String[] args) throws Exception {  
         
       String code =  "1aoi";  
  
       PDBFileReader pdbreader = new PDBFileReader();  
       FileParsingParameters params = new FileParsingParameters();  
       params.setParseSecStruc(true);// parse the secondary structure information from PDB file  
       params.setAlignSeqRes(true);  // align SEQRES and ATOM records  
       pdbreader.setFileParsingParameters(params);  
         
       pdbreader.setFetchBehavior(FetchBehavior.FETCH_FILES);   // fetch PDB files from web if they can't be found locally

       Structure struc = pdbreader.getStructureById(code);

       System.out.println("The SEQRES and ATOM information is available via the chains:");

       int modelnr = 0 ; // also is 0 if structure is an XRAY structure.

       List<Chain> chains = struc.getChains(modelnr);  
       for (Chain cha:chains){  
           List<Group> agr = cha.getAtomGroups(GroupType.AMINOACID);  
           List<Group> hgr = cha.getAtomGroups(GroupType.HETATM);  
           List<Group> ngr = cha.getAtomGroups(GroupType.NUCLEOTIDE);

           System.out.print("chain: >"+cha.getChainID()+"<");
           System.out.print(" length SEQRES: " +cha.getSeqResLength());  
           System.out.print(" length ATOM: " +cha.getAtomLength());  
           System.out.print(" aminos: " +agr.size());  
           System.out.print(" hetatms: "+hgr.size());  
           System.out.println(" nucleotides: "+ngr.size());    
       }

   }

}
