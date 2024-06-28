class Solution {
    public String removeStars(String s) {
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i)!='*'){
                ans.append(s.charAt(i));
            }
            else{
                ans.deleteCharAt(ans.length() -1);
            }
        }
        return ans.toString();
    }
}