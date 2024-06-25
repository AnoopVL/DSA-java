class Solution {
    public String mergeAlternately(String word1, String word2) {
        int n = Math.min(word1.length(), word2.length());
        StringBuilder finalString = new StringBuilder();
        for(int i = 0; i < n; i++){
            // This is wrong
        //    finalString.append(word1.charAt(i)+word2.charAt(i));
            finalString.append(word1.charAt(i));
            finalString.append(word2.charAt(i));
        }
        if (word1.length() > n) {
            finalString.append(word1.substring(n));
        } else if (word2.length() > n) {
            finalString.append(word2.substring(n));
        }
        return finalString.toString();
    }
}