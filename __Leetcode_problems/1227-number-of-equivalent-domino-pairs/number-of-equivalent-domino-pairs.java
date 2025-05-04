class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        // Use a fixed-size array because values are between 1 and 9.
        int[] counts = new int[100];
        int pairs = 0;
        for (int[] domino : dominoes) {
            int a = domino[0];
            int b = domino[1];
            // Normalize the domino: (a, b) and (b, a) become the same key
            int key = a < b ? a * 10 + b : b * 10 + a;
            pairs += counts[key];  // Add how many times this normalized domino has been seen
            counts[key]++;
        }
        return pairs;
    }
}
