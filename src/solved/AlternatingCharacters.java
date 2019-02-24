package solved;

import java.io.IOException;

public class AlternatingCharacters {

    static int alternatingCharacters(String s) {
    	int deletions = 0;
    	char prevChar = Character.MIN_VALUE;
    	for(int i = 0; i < s.length(); i++) {
    		if(s.charAt(i) == prevChar) {
    			deletions++;
    			prevChar = s.charAt(i-1);
    		} else {
    			prevChar = s.charAt(i);
    		}
    	}
    	return deletions;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(alternatingCharacters("AAAA"));
        System.out.println(alternatingCharacters("BBBBB"));
        System.out.println(alternatingCharacters("ABABABAB"));
        System.out.println(alternatingCharacters("BABABA"));
        System.out.println(alternatingCharacters("AAABBB"));
    }
}