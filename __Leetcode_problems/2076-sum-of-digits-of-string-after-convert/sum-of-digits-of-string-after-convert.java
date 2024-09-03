class Solution {
    public int ans = 0;
    public int getLucky(String s, int k) {
        StringBuilder intString = new StringBuilder();
        for(int i=0; i< s.length(); i++){
               intString.append((s.charAt(i) - 'a' + 1));
        }
        String numString = intString.toString();
        return helper(numString, k);
    }

    private int helper(String numString, int k){
        if(k == 0){
            return ans;
        }
        int numStringSum = 0;
        for (int i = 0; i < numString.length(); i++) {
            numStringSum += Character.getNumericValue(numString.charAt(i));
        }
        ans = numStringSum;
        return helper(String.valueOf(numStringSum), --k);

    }
}