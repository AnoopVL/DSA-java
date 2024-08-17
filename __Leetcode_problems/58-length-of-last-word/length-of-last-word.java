class Solution {
    public int lengthOfLastWord(String s) {
        s= s.replaceAll("[^a-zA-Z ]", "");
        String st = s.trim();
        int length= 0;
        for(int i=st.length() -1 ; i>=0; i--){
            if(st.charAt(i) == ' '){
                return length;
            }
            length++;
        }
        return st.length();
    }
}