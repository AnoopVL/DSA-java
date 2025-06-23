class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        List<List<Integer>> ansList = new ArrayList<>();
        int minDifference = Integer.MAX_VALUE;
        for(int i=1; i < n; i++){
            int diff = Math.abs(arr[i] - arr[i-1]);
            minDifference = Math.min(minDifference, diff);
        }
        for(int i=1; i < n; i++){
            if(Math.abs(arr[i] - arr[i-1]) == minDifference){
                List<Integer> list = new ArrayList<>();
                list.add(arr[i-1]);
                list.add(arr[i]);
                ansList.add(list);
            }
        }
        return ansList;
    }
}