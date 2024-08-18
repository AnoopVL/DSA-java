class Solution {
    public boolean isPalindrome(int x) {
        String str = Integer.toString(x);
        String revString = new StringBuilder(str).reverse().toString();
        return str.equals(revString);
    }
}