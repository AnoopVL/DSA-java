class Solution {
    public int maximumGain(String s, int x, int y) {
        if(x > y){
            return helper(s, "ab", x, y);
        }else{
            return helper(s, "ba", y, x);
        }
    }
    // pattern = "ba"
    private int helper(String s, String pattern, int high, int low){
        int ans = 0;
        StringBuilder ip1 = new StringBuilder();
        for(char ch : s.toCharArray()){
            ip1.append(ch);
            int l = ip1.length();
            if(l >=2 && pattern.charAt(1) == ip1.charAt(l-1) && pattern.charAt(0) == ip1.charAt(l-2)){
                ip1.setLength(l - 2);
                ans += high;
            } 
        }

        StringBuilder ip2 = new StringBuilder();
        for(char ch : ip1.toString().toCharArray()){
            ip2.append(ch);
            int l = ip2.length();
            if(l >= 2 && pattern.charAt(0) == ip2.charAt(l-1) && pattern.charAt(1) == ip2.charAt(l-2)){
                ip2.setLength(l-2);
                ans += low;
            }
        }
        return ans;
    }
}