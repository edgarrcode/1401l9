public class SequenceTesting {   
    /**********************************************************************************
     * Including FindBestMatchSequence
     * Since method "countSubStringMatch" is inside of it.
     ***********************************************************************************/
    public static DNAsequence FindBestMatchSequence(DNAsequence[] A, String[] targets) {
        // your code goes here
        double avgHighest = 0;
        double avg = 0;
        DNAsequence sequenceHighest = A[0];
        double matches = 0;
        double matchesTotal = 0;
        int i = 0;
        int j = 0;

        for (i = 0; i < A.length; i++) {
            matchesTotal = 0;
            for (j = 0; j < targets.length; j++) {
                if (A[i].getLength() > 0) {
                    // To be tested countSubStringMatch
                    matches = A[i].countSubStringMatch(targets[j]);
                    matchesTotal = matchesTotal + matches;
                }
            }

            try {
                avg = matchesTotal / targets.length;
                System.out.println("A[" + i + "] avg = " + avg);
                if(targets.length == 0) {
                    throw new ArithmeticException("Targets are empty. You are dividing by 0.");
                }
            }
            catch (ArithmeticException excpt9) {
                System.out.println(excpt9.getMessage());
            }

            if (avg > avgHighest) {
                avgHighest = avg;
                sequenceHighest = A[i];
            }
        }

        try {
            if(targets.length == 0) {
                throw new Exception("Targets array is empty. Nothing will be compared.");
            }
        }
        catch (Exception excpt4) {
            System.out.println(excpt4.getMessage());
        }


        return sequenceHighest;
    }

    
    
    /**********************************************************************************
    Main
    ***********************************************************************************/
    public static void main(String[] args) {
        // your code goes here

        // --- Testing match at the beginning of the string.
        DNAsequence[] testingDNAsequences = new DNAsequence[2];
        testingDNAsequences[0] = new DNAsequence("Test1a","CT",2);
        testingDNAsequences[1] = new DNAsequence("Test1b","XX",2);
        String[] myTargets = new String[2];
        myTargets[0] = "CTAAAAAAA";
        myTargets[1] = "AAAAAAAAA";

        //FindBestMatchSequence
        System.out.println("Testing match at the beginning of the string. Expected to print \"Test1a\".");
        FindBestMatchSequence(testingDNAsequences, myTargets).Print();


        // --- Testing match at the end of the string.
        testingDNAsequences[0].setName("Test2a");
        testingDNAsequences[0].setSequence("XX");
        testingDNAsequences[0].setLength(2);

        testingDNAsequences[1].setName("Test2b");
        testingDNAsequences[1].setSequence("CT");
        testingDNAsequences[1].setLength(2);

        myTargets[0] = "AAAAAAAAA";
        myTargets[1] = "AAAAAAACT";

        //FindBestMatchSequence
        System.out.println("\nTesting match at the end of the string. Expected to print \"Test2b\".");
        FindBestMatchSequence(testingDNAsequences, myTargets).Print();


        // --- Testing match at the middle of the string.
        testingDNAsequences[0].setName("Test3a");
        testingDNAsequences[0].setSequence("CT");
        testingDNAsequences[0].setLength(2);

        testingDNAsequences[1].setName("Test3b");
        testingDNAsequences[1].setSequence("XX");
        testingDNAsequences[1].setLength(2);

        myTargets[0] = "AAAACTAAA";
        myTargets[1] = "AAAAAAAAA";

        //FindBestMatchSequence
        System.out.println("\nTesting match at the end of the string. Expected to print \"Test3a\".");
        FindBestMatchSequence(testingDNAsequences, myTargets).Print();


        // --- Testing match multiple times.
        testingDNAsequences[0].setName("Test4a");
        testingDNAsequences[0].setSequence("XX");
        testingDNAsequences[0].setLength(2);

        testingDNAsequences[1].setName("Test4b");
        testingDNAsequences[1].setSequence("CT");
        testingDNAsequences[1].setLength(2);

        myTargets[0] = "CTCTCTCTCT";
        myTargets[1] = "AAAAAAAAAA";

        //FindBestMatchSequence
        System.out.println("\nTesting match multiple times. Expected to print \"Test4b\".");
        FindBestMatchSequence(testingDNAsequences, myTargets).Print();

    }

}
