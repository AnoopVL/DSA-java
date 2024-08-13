class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int i= 0;
        int j= 0;
        double windowSum = 0;
        double ans = Integer.MIN_VALUE;
        double avg = 0;
        while(j < nums.length){
            windowSum+= nums[j];
            if((j-i+1) < k){
                j++;
            }
            else{
                avg = windowSum/k;
                ans = Math.max(ans, avg);
                windowSum-= nums[i];
                i++;
                j++;
            }
        } 
        return ans;
    }
}