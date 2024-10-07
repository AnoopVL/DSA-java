class Solution {
    public int minLength(String s) {
        // String sNew = new String();
        boolean containsAB = s.contains("AB");
        boolean containsCD = s.contains("CD");
        int ans = s.length();

        if(containsAB || (containsAB && containsCD)){
            String sNew = s.replace("AB", "");
            ans = minLength(sNew);
        }else if(!containsAB && containsCD){
            String sNew = s.replace("CD", "");
            ans = minLength(sNew);
        }
        return ans;
    }
}