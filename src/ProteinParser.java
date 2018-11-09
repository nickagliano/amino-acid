import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.xml.bind.JAXBException;
import org.biojava.nbio.aaproperties.*;
import org.biojava.nbio.aaproperties.xml.AminoAcidCompositionTable;
import org.biojava.nbio.core.*;
import org.biojava.nbio.core.sequence.ProteinSequence;
import org.biojava.nbio.core.sequence.compound.AminoAcidCompound;
import org.biojava.nbio.structure.*;

public class ProteinParser implements IPeptideProperties {

	public static void main(String[] args) throws IOException {
		
        PrintWriter pw = new PrintWriter(new File("testoutput.csv"));
        StringBuilder sb = new StringBuilder();
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
        sb.append("A");
        sb.append(',');
        sb.append("B");
        sb.append(',');
        sb.append("C");
        sb.append(',');
        sb.append("D");
        sb.append(',');
        sb.append("E");
        sb.append(',');
        sb.append("F");
        sb.append(',');
        sb.append("G");
        sb.append(',');
        sb.append("H");
        sb.append(',');
        sb.append("I");
        sb.append(',');
        sb.append("J");
        sb.append(',');
        sb.append("K");
        sb.append(',');
        sb.append("L");
        sb.append(',');
        sb.append("M");
        sb.append(',');
        sb.append("N");
        sb.append(',');
        sb.append("O");
        sb.append(',');
        sb.append("P");
        sb.append(',');
        sb.append("Q");
        sb.append(',');
        sb.append("R");
        sb.append(',');
        sb.append("S");
        sb.append(',');
        sb.append("T");
        sb.append(',');
        sb.append("U");
        sb.append(',');
        sb.append("V");
        sb.append(',');
        sb.append("W");
        sb.append(',');
        sb.append("X");
        sb.append(',');
        sb.append("Y");
        sb.append(',');
        sb.append("Z");
        sb.append(',');
        sb.append("_");
        sb.append(',');
        sb.append("*");
        sb.append(',');
        sb.append("-");
        sb.append(',');
        sb.append(".");
        sb.append('\n');
        
        
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        
        br = new BufferedReader(new FileReader("sequences_training.csv"));
       
        while ((line = br.readLine()) != null) {
            String[] parsedLine = line.split(cvsSplitBy);
            String sequence = parsedLine[0];
            
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
            Map<String, Double> composition = PeptideProperties.getAACompositionString(sequence);
    		for(String aa:composition.keySet()){
    			   sb.append(composition.get(aa));
    			   sb.append(',');
    			}
            sb.append('\n');
        }
        
        br.close();
        
        pw.write(sb.toString());
        pw.close();
        System.out.println("done!");
		
	
		/*
		System.out.println("Molecular Weight: " + PeptideProperties.getMolecularWeight(sequence));
		
		System.out.println("Isoelectric Point: " + PeptideProperties.getIsoelectricPoint(sequence));
	
		System.out.println("Net Charge: " + PeptideProperties.getNetCharge(sequence));
		
		System.out.println("Average Hydropathy Value: " + PeptideProperties.getAvgHydropathy(sequence));
		
		System.out.println("Aliphatic index: " + PeptideProperties.getApliphaticIndex(sequence));
		
		Map<String, Double> composition = PeptideProperties.getAACompositionString(sequence); 
		for(String aa:composition.keySet()){
			   System.out.println("Composition of " + aa + ": " + composition.get(aa));
			}
		*/
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
