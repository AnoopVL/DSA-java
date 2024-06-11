class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if(!(str1 + str2).equals(str2 + str1)){
            return "";
        }
        int gcd = gcd(str1.length(), str2.length());
        return str1.substring(0,gcd);
    }
    private int gcd(int str1Length, int str2Length){
        return str2Length == 0 ? str1Length : gcd(str2Length, str1Length % str2Length);
    }
}