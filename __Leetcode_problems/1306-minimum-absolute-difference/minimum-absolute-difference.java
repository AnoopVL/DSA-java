class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        List<List<Integer>> ansList = new ArrayList<>();
        int minDifference = Integer.MAX_VALUE;
        for(int i=1; i < n; i++){
            int diff = Math.abs(arr[i] - arr[i-1]);
            if(diff < minDifference){
                minDifference = diff;
                ansList.clear();
                ansList.add(Arrays.asList(arr[i-1], arr[i]));
            }else if(diff == minDifference){
                ansList.add(Arrays.asList(arr[i-1], arr[i]));
            }
        }
        
        return ansList;
    }
}