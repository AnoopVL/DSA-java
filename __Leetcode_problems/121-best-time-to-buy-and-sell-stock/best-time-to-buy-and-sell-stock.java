class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit=0;
        int currentMax= 0;

        for(int i=1; i< prices.length; i++){
            currentMax = Math.max(0, currentMax += prices[i]- prices[i-1]);
            maxProfit = Math.max(maxProfit, currentMax);
        }

        return maxProfit;
    }
}