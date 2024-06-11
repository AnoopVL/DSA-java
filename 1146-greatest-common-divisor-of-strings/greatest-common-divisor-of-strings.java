class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if(!(str1 + str2).equals(str2 + str1)){
            return "";
        }
        int gcd = gcd(str1.length(), str2.length());
        return str1.substring(0,gcd);
    }
    private int gcd(int str1Len, int str2Len){
        if(str2Len == 0){
            return str1Len;
        }
        else{
            return gcd(str2Len, str1Len % str2Len);
        }
    }
}