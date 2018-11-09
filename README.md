# amino-acid


Java x Maven project with the purpose of extracting features from Amino Acid sequences.

Extracted features are stored in a .csv file, and are meant to be used to form predictive models.

The program uses biojava libraries for extraction of features from amino acid sequences.

For information on biojava, visit their [GitHub](https://github.com/biojava), or [biojava.org](https://biojava.org/).


## File descriptions

- sequences_training.csv 
  - The input dataset. First column is sequence of amino acids, second column is the class. 
  - The 4 classes
    - DNA: Proteins that interact with DNA
    - RNA: Proteins that interact with RNA 
    - DRNA: Proteins that interact with DNA and RNA
    - nonDRNA: Proteins that do not interact with DNA or RNA
