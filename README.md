# Overview
A Java x Maven project with the purpose of extracting features from amino acid sequences.

Extracted features are stored in a .csv file, and are meant to be used to form predictive models.

The program uses biojava libraries for extraction of features from amino acid sequences.

For information on biojava, visit their [GitHub](https://github.com/biojava), or [biojava.org](https://biojava.org/).

## File descriptions

#### src/ProteinParser.java
- Program's main Java class
- Uses biojava libraries to extract information from DNA sequences
- Input: .csv file with raw amino acid sequences and class feature
- Output: .csv file with extracted features

#### src/PDBReader.java
- A WORK IN PROGRESS
- Function to get important structural information from PDB files

#### src/FastaWriter.java
- A WORK IN PROGRESS
- Function to convert a .csv file into a fasta file

#### src/PostBLASTQuery.java
- Sample post request from ncbi website

#### src/PostXMLQuery.java
- Sample post request from ncbi website

#### sequences_training.csv 
 - The input dataset. First column is sequence of amino acids, second column is the class. 
 - At the moment, the input dataset contains ambiguous sequences. This will be updated in the future.
 - The 4 classes
   - DNA: Proteins that interact with DNA
   - RNA: Proteins that interact with RNA 
   - DRNA: Proteins that interact with DNA and RNA
   - nonDRNA: Proteins that do not interact with DNA or RNA
#### pom.xml
- maven file
- manages the build and build dependencies, the most important of those being the biojava dependencies
#### testoutput.csv
- the output .csv file from the current build of the program

Links:

https://www.ncbi.nlm.nih.gov/pmc/articles/PMC4394471/ - overview of protein-dna interactions
https://www.ncbi.nlm.nih.gov/pmc/articles/PMC2566867/ - arguably more specific info on predicting protein-dna interactions

