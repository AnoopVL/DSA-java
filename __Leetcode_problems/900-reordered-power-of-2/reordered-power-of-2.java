class Solution {
    public boolean reorderedPowerOf2(int N) {
        long c = helper(N);
        for (int i = 0; i < 32; i++)
            if (helper(1 << i) == c) return true;
        return false;
    }
    public long helper(int N) {
        long res = 0;
        for (; N > 0; N /= 10) res += (int)Math.pow(10, N % 10);
        return res;
    }
}