class Solution {
    public int numberOfSubstrings(String s) {
        int i = 0, j = 0;
        int ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('a', 0);
        map.put('b', 0);
        map.put('c', 0);
        while (j < s.length()) {
            char c = s.charAt(j);
            map.put(c, map.get(c) + 1);
            while (map.get('a') > 0 && map.get('b') > 0 && map.get('c') > 0) {
                ans += s.length() - j;
                char ci = s.charAt(i);
                map.put(ci, map.get(ci) - 1);
                i++;
            }
            j++;
        }
        return ans;
    }
}
