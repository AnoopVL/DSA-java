class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int i = 0;
        int j = 0;
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        int ans = 0;
        while(j < nums.length){
            int k = nums[j];
            while(set.contains(k)){
                set.remove(nums[i]);
                sum -= nums[i];
                i++;
            }
            set.add(k);
            sum += k;
            ans = Math.max(ans, sum);
            j++;
        }  
        return ans;
    }
}