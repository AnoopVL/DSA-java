//1672. Richest Customer Wealth
//https://leetcode.com/problems/richest-customer-wealth/

public class RichCustomer{
    public static void main(String[] args) {
        
    }
    public static int maximumWealth(int[][] accounts) {
        int ans = Integer.MIN_VALUE;
        for (int[] account2 : accounts) {
            int sum = 0;
            for (int element : account2) {
                sum+=element;
            }
            if(sum > ans){
                ans = sum;
            }
        }
        return ans;
    }
}