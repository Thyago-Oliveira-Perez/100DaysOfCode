import java.util.Scanner;

public class day29 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Type a sequence of lights separated by spaces: ");
	    String lightSequence = scan.nextLine(); 
	    
	    System.out.println(TrafficLightChecker(lightSequence));
	}
	
	public static String TrafficLightChecker (String lightSequence) {
	    
	    final String correctMessage = "ACCEPT";
	    final String rejectMessage = "REJECT";
	    final String errorMessage = "ERROR";
	    final String acceptedLetters = "RYGPCX";
	    
	    char[] lightSequenceArray = lightSequence.toUpperCase().toCharArray();
	    
	    if (lightSequence.length() > 15 || lightSequence.length() <= 3 ) return errorMessage; 
	    if (!VerifyAcceptedCodes(acceptedLetters, lightSequence)) return errorMessage; 
	    if (lightSequenceArray[0] != 'R') return rejectMessage;
	    
	    for (int i = 0 ; i < lightSequenceArray.length ; i++) {
	        
	        if ((i+1) < lightSequenceArray.length) {
    	        if (lightSequenceArray[i] == 'R' && !("GC".contains(String.valueOf(lightSequenceArray[i+1])))) return rejectMessage;
                if (lightSequenceArray[i] == 'G' && lightSequenceArray[i+1] != 'Y') return rejectMessage;
                if (lightSequenceArray[i] == 'Y' && lightSequenceArray[i+1] != 'R') return rejectMessage;
	        }
	    }
	    
	    return correctMessage;
	}
	
	public static boolean VerifyAcceptedCodes (String acceptedLetters, String lightSequence) {
	    
	    char[] lightSequenceArray = lightSequence.toCharArray();
	    
        for (char symbol : lightSequenceArray) {
        	if (!acceptedLetters.contains(String.valueOf(symbol))) return false;
	    }
	    
	    return true;
	}
}