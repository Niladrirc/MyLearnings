package src.easy;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] prices = {7,15,3,30,9,1,18,6,14,11};

        int mp = maxProfit(prices);

        System.out.println("Max Profit: " + mp);
    }

    private static int maxProfit(int[] prices) {
        int c=0;
        int min = prices[c], profit = 0;
        while (c < prices.length) {
            if (prices[c] < min) {
                min = prices[c];
            }
            if (profit < (prices[c]-min)) {
                profit = prices[c]-min;
            }
            c++;
        }
        return profit;
    }
}
