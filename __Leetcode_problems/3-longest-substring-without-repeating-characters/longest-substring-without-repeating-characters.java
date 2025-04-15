class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() <= 1) return s.length();
        int ans = 0;
        int i=0, j=1;
        Set<Character> set = new HashSet<>();
        set.add(s.charAt(0));
        while (j < s.length()){
            char c = s.charAt(j);
            if(set.contains(c)){
                while(set.contains(c)){
                    set.remove(s.charAt(i));
                    i++;
                }
            }else{
                set.add(c);
                ans = Math.max(ans, set.size());
                j++;
            }
        }
        return ans;
    }
}