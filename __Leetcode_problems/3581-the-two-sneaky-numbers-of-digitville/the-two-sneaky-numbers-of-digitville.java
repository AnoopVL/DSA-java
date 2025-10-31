class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];
        int i = 0;
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0)+1);
            if(map.get(num) > 1){
                ans[i] = num;
                i++;
            }
        }
        return ans;
    }
}