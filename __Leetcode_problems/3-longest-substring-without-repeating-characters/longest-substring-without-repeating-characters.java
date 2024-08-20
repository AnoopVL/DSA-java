class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() <= 1){
            return s.length();
        }
        int i=0, j=1, ans =0;
        Set<Character> set = new HashSet<>();
        set.add(s.charAt(0));
        ans = Math.max(ans, set.size());
        while(j < s.length()){
            // he fakta i pudhe ghayla ahe
            if(set.contains(s.charAt(j))){
                while(set.contains(s.charAt(j))){
                    set.remove(s.charAt(i));
                    i++;
                }
            }else{
                set.add(s.charAt(j));
                ans = Math.max(ans, set.size());
                j++;
            }

        }
        return ans;
    }
}