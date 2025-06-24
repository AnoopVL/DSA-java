class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> ansList = new ArrayList<>();
        List<Integer> jList = new ArrayList<>();
        int n = nums.length;
        for(int i=0; i< n; i++){
            if(nums[i] == key) jList.add(i);
        }
        int jn = jList.size();
        for(int i=0; i < n; i++){
            for(int j=0; j < jn; j++){
                if(ansList.contains(i)) break;
                if(Math.abs(i- jList.get(j)) <= k) ansList.add(i); 
            }
        }
        Collections.sort(ansList);
        return ansList;
    }
}