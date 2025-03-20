class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i=0, j=0;
        int minWindow = Integer.MAX_VALUE;
        int sum =0;
        while(j < nums.length){
            sum += nums[j];
            if(sum >= target){
                minWindow = Math.min(minWindow, j-i+1);
                    while(sum > target){
                        if(sum >= target){
                            minWindow = Math.min(minWindow, j-i+1);
                        }
                        sum -= nums[i];
                        i++;
                    }
                    if(sum == target){
                        minWindow = Math.min(minWindow, j-i+1);
                        // i++;
                    }
            }
            j++;
        }
        return (minWindow == Integer.MAX_VALUE) ? 0 : minWindow;
    }
}
