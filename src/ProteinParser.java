//made by Nick Agliano :)

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
import org.biojava.nbio.core.sequence.ProteinSequence;
import org.biojava.nbio.core.sequence.compound.AminoAcidCompound;

public class ProteinParser implements IPeptideProperties {

	public static void main(String[] args) throws IOException {
		
		MultipleSequenceAlignment.main(args);
		
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
           
            sb.append('\n');
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