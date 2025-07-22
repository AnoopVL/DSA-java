class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int ans = 0;
        int i = 0; 
        int j = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        while (j < nums.length){
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            sum += nums[j];
            if(map.get(nums[j]) > 1){
                while(map.get(nums[j]) > 1){
                    map.put(nums[i], map.get(nums[i]) - 1);
                    if(map.get(nums[i]) == 0) map.remove(nums[i]);
                    sum -= nums[i];
                    i++;
                }
            }
            j++;
            ans = Math.max(sum, ans);
        }
        return ans;
    }
}