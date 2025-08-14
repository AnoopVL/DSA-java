class Solution {
    public String largestGoodInteger(String num) {
        String max = "";
        int n = num.length();
        for (int i = 2; i < n; i++) {
            if (num.charAt(i) == num.charAt(i - 1) && num.charAt(i) == num.charAt(i - 2)) {
                String curr = num.substring(i - 2, i + 1);
                if (curr.compareTo(max) > 0) {
                    max = curr;
                }
            }
        }
        return max;
    }
}
