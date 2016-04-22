public class DNAsequence {

	/**************** ATTRIBUTES *******************************************
	/* Here go your attributes, i.e., the information that is contained in 
	 * your new "type" 
	 * We can also see these new types as "blue-prints" of "things" we are 
	 * going to build 
	 * Expected attributes are:
	 * a.	A name: of type string
     * b.	A DNA sequence: of type string
     * c.	A length: of type int
     * d.	A number of A’s: of type int
     * e.	A number of C’s: of type int
     * f.	A number of G’s: of type int
     * g.	A number of T’s: of type int
	 ***********************************************************************/
	private String name;
	private String sequence;
	private int length;
	private int As;
    private int Cs;
    private int Gs;
    private int Ts;
	
    /***************** METHODS *********************************************
     * Note that none of the methods below are static.
     * It means that once you have defined a object of type DNAsequence, 
     * let's say mySequence, then you will call these methods as:
     * mySequence.printSequence(), or mySequence.setName("this new name"),
     * etc.
     ***********************************************************************/
    
	/**************** CONSTRUCTORS *****************************************
	 * Note that the signatures are different from those we are used to 
	 ***********************************************************************/
	/* default constructor: provided to you. You should not touch the next two lines of code */
	public DNAsequence() {
	}
	
	public DNAsequence(String seqName, String seq, int seqlength) {
        // your code goes here
        name = seqName;
        sequence = seq;
        length = seqlength;
    }
	
	/***************** SETTERS / MUTATORS **********************************
	 * Methods that allow to set or modify the values of the attributes
	 * One method per attribute
	 * Note that the methods are not static (to be explained -- much -- later)
	 ***********************************************************************/
	/* one per attribute: we provide you with two, you have to provide the others */
	public void setName(String seqName) {
		name = seqName;
	}
	
	public void setSequence(String seqSequence) {
		sequence = seqSequence;
	}
	
	public void setLength(int seqlength) {
		// your code goes here
		length = seqlength;
	}
	
    // complete here with more mutators, as relevant
    
	/**************** GETTERS / ACCESSORS **********************************
	 * Methods that allow to access the values of the attributes
	 * One method per attribute
	 * Note that the methods are not static (to be explained -- much -- later)
	 ***********************************************************************/
	/* one per attribute: we provide you with the one, you have to provide the others */
	public String getName() {
		return name;
	}
	
	public String getSequence() {
		return sequence;
	}
	
	public int getLength() {
		// your code goes here
		return length;
	}
	
    // complete here with more accessors, as relevant
	
	/***********************************************************************
	 * Other methods, depending on needs 
	 ***********************************************************************/

    /***********************************************************************
	 * Here we are asking you to design a method that prints the information
	 * about any DNAsequence
     * Method Print: this method prints the name of the sequence followed by 
     * the sequence itself, then prints its length and the number of A’s, 
     * C’s, G’s, and T’s.
	 ***********************************************************************/
	public void Print() {
		// your code goes here
		System.out.println("Name: " + name);
		System.out.println("Sequence: " + sequence);
		System.out.println("Length: " + length);
		System.out.println("As: " + As);
		System.out.println("Cs: " + Cs);
		System.out.println("Gs: " + Gs);
		System.out.println("Ts: " + Ts);
    }
	
    /***********************************************************************
     * Method countSubStringMatch: 
     * as defined in Lab 8, except for the parameters: this method only takes 
     * one parameter, the target (the key is the object on which the method 
     * is applied). Note: You are free to use your iterative or recursive method.  
	 ***********************************************************************/
    public int countSubStringMatch(String target) {
        int result = 0;
        // your code goes here
        String myStr = "";

        if(target.length() < sequence.length()) {
            return 0;
        }

        myStr = target.substring(0, sequence.length());
        if (sequence.equals(myStr)) {
            result = result + 1;
        }

        return (result + countSubStringMatch(target.substring(1)));
    }
}
