package LeetCode;

public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) minPrice = prices[i];
            else if (maxProfit < prices[i] - minPrice) maxProfit = prices[i] - minPrice;
        }
        return maxProfit;
    }
}
