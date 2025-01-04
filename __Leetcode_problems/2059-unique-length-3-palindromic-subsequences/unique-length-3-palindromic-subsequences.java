class Solution {
    public int countPalindromicSubsequence(String s) {
        HashSet<Character> set = new HashSet<>();
        int n = s.length();
        for(int i=0;i<n;i++){
            set.add(s.charAt(i));
        }
        int ans=0;
        for(char ch : set){
            int f=-1;
            int l = -1;
            for(int i=0;i<n;i++){
                if(ch == s.charAt(i)){
                    if(f == -1){
                        f = i;
                    }
                    l = i;
                }
            }
            if(f == l) continue;
            HashSet<Character> set1 = new HashSet<>();
            for(int i=f+1;i<l;i++){
                set1.add(s.charAt(i));
            }
            ans += set1.size();
        }
        return ans;
    }
}