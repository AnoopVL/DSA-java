class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> ansList = new ArrayList<>();
        int right = 0;
        int n = nums.length;
        for(int j=0; j < n; j++){
            if(nums[j] == key){
                int left = Math.max(right, j - k);
                right = Math.min(n-1, j+k) + 1;
                for(int i = left; i < right; i++){
                    ansList.add(i);
                }
            }
        }
        return ansList;       
    }
}