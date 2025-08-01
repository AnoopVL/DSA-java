class Solution {
    public List<List<Integer>> generate(int n) {
        if (n == 0) return new ArrayList<>();
        if (n == 1) {
            List<List<Integer>> result = new ArrayList<>();
            result.add(Arrays.asList(1));
            return result;
        }
        List<List<Integer>> prevRows = generate(n - 1);
        List<Integer> newRow = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            newRow.add(1);
        }
        for (int i = 1; i < n - 1; i++) {
            newRow.set(i, prevRows.get(n - 2).get(i - 1) + prevRows.get(n - 2).get(i));
        }
        prevRows.add(newRow);
        return prevRows;
    }
}