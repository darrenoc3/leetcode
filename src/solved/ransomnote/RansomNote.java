package solved.ransomnote;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class RansomNote {
	
    static void checkMagazine(String[] magazine, String[] note) {
    	HashMap<String, Integer> magazineWordCounts = new HashMap<String, Integer>();
    	for(String word : magazine) {
    		int wordCount = 1;
    		if(magazineWordCounts.containsKey(word)) {
    			wordCount += magazineWordCounts.get(word);
    		}
    		magazineWordCounts.put(word, wordCount);
    	}
    	for(String word : note) {
    		Object value = magazineWordCounts.get(word);
    		// fail case is if the magazine doesnt contain the word, or
    		// the magazine contains the word but we've used all the occurrences
    		// of it already
    		if(value == null || (int) value == 0) {
    	    	System.out.println("No");
    	    	return;
    		} else {
    			// lower the counter for this word by 1 as we've used it
    			int wordCount = magazineWordCounts.get(word);
    			magazineWordCounts.put(word, wordCount - 1);
    		}
    	}
    	System.out.println("Yes");
    }
    public static void main(String[] args) throws FileNotFoundException {
    	File file = new File("C:\\Users\\darre_000\\eclipse-workspace\\HackerRank\\unsolved\\RansomNote\\input1.txt");
    	Scanner scanner = new Scanner(file);

        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }

}
