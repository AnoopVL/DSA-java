class Solution {
        public int[] xorQueries(int[] A, int[][] queries) {
        int[] ans = new int[queries.length], q;

        for (int i = 1; i < A.length; ++i){
            A[i] ^= A[i - 1];
        }

        for (int i = 0; i < queries.length; ++i) {
            q = queries[i];
            ans[i] = q[0] > 0 ? A[q[0] - 1] ^ A[q[1]] : A[q[1]];
        }
        return ans;
    }
}