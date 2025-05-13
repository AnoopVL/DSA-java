class Solution {
    public int modulo = 1000000007;

    public int lengthAfterTransformations(String s, int t) {
        long[] freq = new long[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        for (int step = 0; step < t; step++) {
            long[] nextFreq = new long[26];
            for (int i = 0; i < 26; i++) {
                if (i == 25) {
                    nextFreq[0] = (nextFreq[0] + freq[i]) % modulo;
                    nextFreq[1] = (nextFreq[1] + freq[i]) % modulo;
                } else {
                    nextFreq[i + 1] = (nextFreq[i + 1] + freq[i]) % modulo;
                }
            }
            freq = nextFreq; 
        }
        long total = 0;
        for (int i = 0; i < 26; i++) {
            total = (total + freq[i]) % modulo;
        }

        return (int) total;
    }
}
