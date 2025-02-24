class Solution {
    List<List<Integer>> ansList = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backTrack(0, candidates, target, new ArrayList<>());
        return ansList;
    }

    private void backTrack(int startIndex, int[] candidates, int target, List<Integer> sublist) {
        if (target == 0) {
            ansList.add(new ArrayList<>(sublist));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (candidates[i] > target) {
                continue;
            }
            sublist.add(candidates[i]);
            backTrack(i, candidates, target - candidates[i], sublist);
            sublist.remove(sublist.size() - 1);
        }
    }
}