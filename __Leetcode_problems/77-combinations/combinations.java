class Solution {
    List<List<Integer>> ansList = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        int index = 1;
        backTrack(n, k, index, new ArrayList<Integer>());
        return ansList;
    }

    private void backTrack(int n, int k, int index, List<Integer> sublist){
        if(sublist.size() == k){
            ansList.add(new ArrayList<Integer>(sublist));
            return;
        }
        for(; index <= n; index++){
            sublist.add(index);
            backTrack(n, k, index+1, sublist);
            sublist.remove(sublist.size() - 1);
        }
    }
}