import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class DNAtools {
    
    /**********************************************************************************
     * ReadSequencesFromFile: 
     * This method takes the name of a file as parameter: 
     * the given file contains information about DNA sequences (one sequence per 
     * line, including name and sequence). 
     * It reads the information and fills an array of DNAsequences (a 1D array of 
     * elements of type DNAsequence) with this information. 
     * It returns the array of DNAsequences. 
     ***********************************************************************************/
    public static DNAsequence[] ReadSequencesFromFile(String filename) throws IOException {
        
        FileReader fr = new FileReader(filename);
        BufferedReader textReader = new BufferedReader(fr);
        textReader.mark(1000); // here we assume that the file won't be longer than 1000 lines
        
        // here we count how many DNA sequences we have: the number of DNA sequences is the number of lines in the file
        // because for each sequence there is one sequence information per line
        int numOfLines = 0; //addedByEdgar
        while (textReader.readLine()!=null) {
            numOfLines++;
        }
        
        DNAsequence[] myDNAsequences = new DNAsequence[numOfLines];

        // your code goes here
        textReader.reset();
        String[] line = new String[1];
        String seqName = "";
        String seq = "";
        for (int i = 0; i < numOfLines; i++) {
            line = textReader.readLine().split(" ");
            seqName = line[0];
            seq = line[1];
            myDNAsequences[i] = new DNAsequence(seqName,seq,seq.length());
        }
        
        textReader.close();
        return myDNAsequences; 
    }
    
    /**********************************************************************************
     * ReadTargetsFromFile: 
     * This method takes the name of a file as parameter: 
     * The given file contains information about DNA sequences (one sequence per 
     * line, which is just one string per line – no name in this case). 
     * It reads the information and fills an array of Strings with this information. 
     * It returns this array. 
     ***********************************************************************************/
    public static String[] ReadTargetsFromFile(String filename) throws IOException {
        
        FileReader fr = new FileReader(filename);
        BufferedReader textReader = new BufferedReader(fr);
        textReader.mark(1000); // here we assume that the file won't be longer than 1000 lines
        
        // here we count how many DNA sequences we have: the number of DNA sequences is the number of lines in the file
        // because for each sequence there is one sequence per line
        int numOfLines = 0;
        while (textReader.readLine()!=null) {
            numOfLines++;
        }
        
        String[] myTargets = new String[numOfLines];

        // your code goes here
        textReader.reset();
        for (int i = 0; i < numOfLines; i++) {
            myTargets[i] = textReader.readLine();
        }
        
        textReader.close();
        return myTargets; 
    }


    /**********************************************************************************
     * PrintSequenceArray: 
     * This method takes a 1D array of DNAsequences and prints it out (using the print 
     * method from the DNAsequence class).
     ***********************************************************************************/
    public static void PrintSequenceArray(DNAsequence[] A) {
        // your code goes here
        for (int i = 0; i < A.length; i++) {
            System.out.println("------");
            A[i].Print();
        }

    }
    
    /**********************************************************************************
     * FindBestMatchSequence: 
     * This method takes a 1D array of DNAsequences and a 1D array of strings (the target 
     * strings), and identifies the DNAsequence (within the given 1D array of DNAsequences) 
     * whose average of the number of occurrences in each of the target strings is highest.
     ***********************************************************************************/
    public static DNAsequence FindBestMatchSequence(DNAsequence[] A, String[] targets) {
        // your code goes here
        double avgHighest = 0;
        double avg = 0;
        DNAsequence sequenceHighest = A[0];
        double[] matches = new double[targets.length];
        int i = 0;
        int j = 0;
        int k = 0;

        for (i = 0; i < A.length; i++) {
            for (j = 0; j < targets.length; j++) {
                matches[j] = A[i].countSubStringMatch(targets[j]);
            }
            // if null?
            avg = matches[0];

            for (k = 1; k < targets.length; k++) {
                avg = avg + matches[k];
            }

            avg = avg / targets.length;


            if (avg > avgHighest) {
                avgHighest = avg;
                sequenceHighest = A[i];
            }
        }

        return sequenceHighest;
    }

    /**********************************************************************************
     * SortByBestOccurrenceAverage: 
     * This method takes a 1D array of DNAsequences and a 1D array of strings (the 
     * target strings), and sorts the 1D array of DNAsequences by the average of their 
     * number of occurrences in each of the target strings (highest to lowest).
     ***********************************************************************************/
    public static void SortByBestOccurrenceAverage(DNAsequence[] A, String[] targets) {
        // your code goes here
    }


    /**********************************************************************************
     * SortByLetter: 
     * This method takes a 1D array of DNAsequences and a letter (among A, C, G, or T) 
     * as an input and sorts the 1D array of DNAsequences by the number of such letter 
     * in each DNAsequence (in descending order of such letter). 
     ***********************************************************************************/
    /*public static void SortByLetter(DNAsequence[] A, char c) {
        // your code goes here   
    }*/
    
    
    /**********************************************************************************
     * The main method should go as follows:
     * 1.    You ask the user for a file name
     * 2.    You read the file and retrieve information about DNAsequences by calling method ReadSequencesFromFile 
     * 3.    You ask the user for a file name
     * 4.    You read the file and retrieve information about target strings by calling method ReadTargetsFromFile 
     * 5.    You run the relevant class methods from DNAsequence to fill the attributes.
     * 6.    You sort the array obtained in Step 2 using method SortByBestOccurrenceAverage and print it out. 
     * 7.    You sort the array obtained in Step 6 using method SortByLetter where the letter is A, and print it out. 
     * 8.    You sort the array obtained in Step 7 using method SortByLetter where the letter is C, and print it out. 
     * 9.    You sort the array obtained in Step 8 using method SortByLetter where the letter is G, and print it out. 
     * 10.    You sort the array obtained in Step 9 using method SortByLetter where the letter is T, and print it out. 
     ***********************************************************************************/
    public static void main(String[] args) throws IOException {
        // your code goes here
        Scanner scnr = new Scanner(System.in);
        String filename = "";
        int i = 0;

        //* 1.  You ask the user for a file name
        System.out.print("Enter file name with sequences:");
        filename = scnr.next();
        
        //* 2.    You read the file and retrieve information about DNAsequences by calling method ReadSequencesFromFile 
        DNAsequence[] myDNAsequences = ReadSequencesFromFile(filename);

        //* 3.    You ask the user for a file name
        System.out.print("Enter file name with targets:");
        filename = scnr.next();

        //* 4.    You read the file and retrieve information about target strings by calling method ReadTargetsFromFile 
        String[] myTargets = ReadTargetsFromFile(filename);

        //* 5.    You run the relevant class methods from DNAsequence to fill the attributes.
        PrintSequenceArray(myDNAsequences);
        //System.out.println("------");
        //System.out.println("Setting myDNAsequences[0].name to \"Edgars\"");
        //myDNAsequences[0].setName("Edgars");
        //System.out.println("Setting myDNAsequences[0].sequence to \"EEEEE\"");
        //myDNAsequences[0].setSequence("EEEEE");
        //System.out.println("Setting myDNAsequences[0].length to \"5\"");
        //myDNAsequences[0].setlength(5);
        //PrintSequenceArray(myDNAsequences);

        //* 6.    You sort the array obtained in Step 2 using method SortByBestOccurrenceAverage and print it out. 
        System.out.println("------");
        System.out.println("FindBestMatchSequence:");
        FindBestMatchSequence(myDNAsequences,myTargets).Print();;

    }

}
