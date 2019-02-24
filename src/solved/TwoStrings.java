package solved;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class TwoStrings {

    static String twoStrings(String a, String b) {
    	Set<Character> alphabet = new HashSet<Character>();
    	
    	for(int i = 0; i < a.length(); i++) {
    		alphabet.add(a.charAt(i));
    	}
    	for(int x = 0; x < b.length(); x++) {
    		if(alphabet.contains(b.charAt(x))) {
    			return "YES";
    		}
    	}
    	return "NO";
    }
    
    public static void main(String[] args) throws IOException {
        String result = twoStrings("wouldyoulikefries", "abcabcabcabcabcabc");
        System.out.println(result);
    }
}
