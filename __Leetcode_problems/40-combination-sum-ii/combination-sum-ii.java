class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        Arrays.sort(candidates);
        backTrack(list, new ArrayList<Integer>(), candidates, target, 0);
        return list;
    }
    private void backTrack(List<List<Integer>> list, List<Integer> tempList, int[] cand, int remain, int start){
        if(remain < 0){
            return;
        }
        else if(remain == 0){
            list.add(new ArrayList<>(tempList));
        }
        else{
            for(int i = start; i < cand.length; i++){
                if(i > start && cand[i] == cand[i-1]){
                    continue;
                }
                tempList.add(cand[i]);
                backTrack(list, tempList, cand, remain - cand[i], i+1);
                tempList.remove(tempList.size() -1);
            }
        }
    }
}