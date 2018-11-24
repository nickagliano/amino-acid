//made by Nick Agliano :)

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Map;

import javax.xml.bind.JAXBException;
import org.biojava.nbio.aaproperties.*;
import org.biojava.nbio.aaproperties.xml.AminoAcidCompositionTable;
import org.biojava.nbio.core.sequence.ProteinSequence;
import org.biojava.nbio.core.sequence.compound.AminoAcidCompound;

public class ProteinParser implements IPeptideProperties {

	public static void main(String[] args) throws Exception {
		
        PrintWriter pw = new PrintWriter(new File("testoutput.csv"));
        StringBuilder sb = new StringBuilder();
        //the feature titles
        sb.append("Molecular Weight");
        sb.append(',');
        sb.append("Isoelectric Point");
        sb.append(',');
        sb.append("Net Charge");
        sb.append(',');
        sb.append("Average Hydropathy Value");
        sb.append(',');
        sb.append("Aliphatic index");
        sb.append(',');
        sb.append("DNA Hits");
        sb.append(',');
        sb.append("RNA Hits");
        
        sb.append('\n');
        
        
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        
        br = new BufferedReader(new FileReader("sequences_training.csv"));
       
        String[] parsedLine = line.split(cvsSplitBy);
        String sequence = parsedLine[0];
        
        int[] wordHits;
        
        int progress = 0;
        while ((line = br.readLine()) != null) {
            parsedLine = line.split(cvsSplitBy);
            sequence = parsedLine[0];
            
            sb.append(PeptideProperties.getMolecularWeight(sequence));
            sb.append(',');
            sb.append(PeptideProperties.getIsoelectricPoint(sequence));
            sb.append(',');
            sb.append(PeptideProperties.getNetCharge(sequence));
            sb.append(',');
            sb.append(PeptideProperties.getAvgHydropathy(sequence));
            sb.append(',');
            sb.append(PeptideProperties.getApliphaticIndex(sequence));
            sb.append(',');
            
            String[] idArr = PostBLASTQuery.doMagic(sequence); //reads first 10 results from blast (the 10 most similar proteins)
            wordHits = GetCustomReport.doMagic(idArr); //gets number of times the words "DNA" and "RNA" are found in the descriptions similar protein
            
            sb.append(wordHits[0]); //DNA occurances
            sb.append(',');
            sb.append(wordHits[1]); //RNA occurances
            sb.append('\n');
            progress++;
            System.out.println(progress + " out of ~8795 complete. AKA " + ((double)progress/8795.0)*100 + "% done. :)");
        }
        
        br.close();
        
        pw.write(sb.toString());
        pw.close();
        System.out.println("done!");

	} //end main method
	
	@Override
	public Map<AminoAcidCompound, Double> getAAComposition(ProteinSequence arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getAbsorbance(ProteinSequence arg0, boolean arg1) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getApliphaticIndex(ProteinSequence arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getAvgHydropathy(ProteinSequence arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getEnrichment(ProteinSequence arg0, AminoAcidCompound arg1) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getExtinctionCoefficient(ProteinSequence arg0, boolean arg1) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getInstabilityIndex(ProteinSequence arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getIsoelectricPoint(ProteinSequence arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getIsoelectricPoint(ProteinSequence arg0, boolean arg1) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getMolecularWeight(ProteinSequence arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getMolecularWeight(ProteinSequence arg0, File arg1) throws JAXBException, FileNotFoundException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getMolecularWeight(ProteinSequence arg0, File arg1, File arg2)
			throws JAXBException, FileNotFoundException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getMolecularWeightBasedOnXML(ProteinSequence arg0, AminoAcidCompositionTable arg1) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getNetCharge(ProteinSequence arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getNetCharge(ProteinSequence arg0, boolean arg1) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getNetCharge(ProteinSequence arg0, boolean arg1, double arg2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public AminoAcidCompositionTable obtainAminoAcidCompositionTable(File arg0)
			throws JAXBException, FileNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AminoAcidCompositionTable obtainAminoAcidCompositionTable(File arg0, File arg1)
			throws JAXBException, FileNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
