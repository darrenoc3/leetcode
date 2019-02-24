package solved.luckbalance;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LuckBalance {

	static final int IMPORTANT = 1;
    static int luckBalance(int canLose, int[][] contests) {
    	int luckBalance = 0;
    	ArrayList<Integer> importantContests = new ArrayList<Integer>(contests.length);
    	// find important contests
    	for (int[] contest : contests)
    	{
    		int luck = contest[0];
    		int importance = contest[1];
    		if(importance == IMPORTANT) {
    			importantContests.add(luck);
    		} else {
    			// unimportant contest, lose it as there is no restriction
    			// on losing unimportant contests
    			luckBalance += luck;
    		}

    	}
    	// put important contests in descending order, as we 
    	// want to lose the contests with the most luck value first
    	Collections.sort(importantContests);
    	Collections.reverse(importantContests);
    	while(!importantContests.isEmpty()) {
    		int contestLuck = importantContests.remove(0);
    		// lose the contest if we can afford to
    		if(canLose > 0) {
    			// lose the contest
    			luckBalance += contestLuck;
        		// decrease the counter of how many more contests we can afford
    			// to lose
        		canLose--;
    		} else {
    			// if we cant afford to lose any more contests, we have to win all
    	    	// the remaining ones (meaning that their luck value is subtracted
    			// from our balance)
        		luckBalance -= contestLuck;
    		}

    	} 
    	return luckBalance;
    }


    public static void main(String[] args) throws IOException {
    	File file = new File("C:\\Users\\darre_000\\eclipse-workspace\\HackerRank\\unsolved\\LuckBalance\\input0.txt");
    	Scanner scanner = new Scanner(file);

    	String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[][] contests = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] contestsRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int contestsItem = Integer.parseInt(contestsRowItems[j]);
                contests[i][j] = contestsItem;
            }
        }
        
        int result = luckBalance(k, contests);
        System.out.println(result);

        scanner.close();
    }
}
