package solved;

import java.io.IOException;

public class Anagrams {
    static int makeAnagram(String a, String b) {
    	StringBuilder aSorted = a.chars().sorted()
    			.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append);
    	StringBuilder bSorted = b.chars().sorted()
    			.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append);
    	StringBuilder bBuffer = new StringBuilder(bSorted);
    	//System.out.println("a sorted: " +aSorted);
    	//System.out.println("b sorted: " +bSorted);
    	int deletions = 0;
    	for(int i = 0; i < aSorted.length(); i++) {
    		char c = aSorted.charAt(i);
    		int index = bBuffer.toString().indexOf((Character.toString(c)));
    		if(index == -1) {
    			aSorted.deleteCharAt(i);
    			deletions++;
    			// if the adjacent letter is the same character, delete it too
    			if(i < aSorted.length() && aSorted.charAt(i) == c) {
    				aSorted.deleteCharAt(i);
    				deletions++;
    			}
    			i--;
    		} else {
    			bBuffer.deleteCharAt(index);
    		}
    	}
    	//System.out.println("anagram: " +aSorted);
    	//System.out.println("buffer: " +bBuffer);
    	deletions += bBuffer.length();

    	return deletions;
    }


    public static void main(String[] args) throws IOException {
        int res = makeAnagram("bugexikjevtubidpulaelsbcqlupwetzyzdvjphn", "lajoipfecfinxjspxmevqxuqyalhrsxcvgsdxxkacspbchrbvvwnvsdtsrdk");
        System.out.println(res);
    }
}
