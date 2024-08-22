class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length <= 1){
            return nums.length;
        }
        int ans =0;
        Set<Integer> set = new HashSet<>();
        for(int i=0; i< nums.length; i++){
            set.add(nums[i]);
        }
        for(int i=0; i < nums.length; i++){
            if(!set.contains(nums[i] -1)){
                int streak = 1;
                int currentNum = nums[i];
                while(set.contains(currentNum + 1)){
                    streak++;
                    currentNum++;
                }
                ans = Math.max(ans, streak);
            }   
        }
        return ans;
    }
}