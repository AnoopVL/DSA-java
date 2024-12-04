class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int i=0, j=0;
        while(i < str1.length() && j < str2.length()){
            if(str1.charAt(i) == str2.charAt(j)){
                i++;
                j++;
            }
            else{
                char ch = (char) ('a' + (str1.charAt(i) - 'a' +1) %26);
                if(ch == str2.charAt(j)){
                    i++;
                    j++;
                }else{
                    i++;
                }
            }
        }
        return j== str2.length();
    }
}