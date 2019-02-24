package solved;

import java.io.IOException;
import java.util.Arrays;

public class MarksToys {

    // Complete the maximumToys function below.
    static int maximumToys(int[] prices, int money) {
    	Arrays.sort(prices);
    	int remainingMoney = money;
    	int toysBought = 0;
    	for(int price : prices) {
    		remainingMoney -= price;
    		if(remainingMoney < 0) {
    			return toysBought;
    		} else {
    			toysBought++;
    		}
    	}
    	return toysBought;
    }

    public static void main(String[] args) throws IOException {

    	int[] prices = {1, 12, 5, 111, 200, 1000, 10};
        int result = maximumToys(prices, 50);
        System.out.println(result);
    }
}
