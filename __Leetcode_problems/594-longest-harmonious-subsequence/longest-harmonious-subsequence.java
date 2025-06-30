class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        // Count frequencies
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // Check for harmonious subsequences
        for (int num : nums) {
            int minNum = num;
            int maxNum = num + 1;

            if (map.containsKey(maxNum)) {
                result = Math.max(result, map.get(minNum) + map.get(maxNum));
            }
        }
        return result;
    }
}