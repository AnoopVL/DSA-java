class Solution {
    List<List<Integer>> ansList = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        // int index = 0;
        int n = nums.length;
        boolean[] used = new boolean[n];
        backTrack(n, nums, used, new ArrayList<>());
        return ansList;
    }
    private void backTrack(int n, int[] nums, boolean[] used, List<Integer> sublist){
        if(sublist.size() == n){
            ansList.add(new ArrayList<Integer>(sublist));
            return;
        }
        for(int i=0; i < n; i++){
            if(!used[i]){
                sublist.add(nums[i]);
                used[i] = true;
                backTrack(n, nums, used, sublist);
                sublist.remove(sublist.size() -1);
                used[i] = false;
            }
        }
    }
}