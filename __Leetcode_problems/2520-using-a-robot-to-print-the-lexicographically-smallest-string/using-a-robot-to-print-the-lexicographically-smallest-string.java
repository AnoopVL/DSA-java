class Solution {
    public String robotWithString(String s) {
        int n = s.length();

        /* 1. Count frequency of every letter in s */
        int[] freq = new int[26];
        for (char c : s.toCharArray()) freq[c - 'a']++;

        /* 2. Helpers */
        StringBuilder t = new StringBuilder();  
        StringBuilder p = new StringBuilder();   
        int smallest = 0;                       

        /* 3. Sweep through s left → right */
        for (char c : s.toCharArray()) {
            /* push current char onto stack (operation 1) */
            t.append(c);
            freq[c - 'a']--;
            /* update “smallest pending letter” pointer */
            while (smallest < 26 && freq[smallest] == 0) smallest++;
            /* pop while top of stack is already ≤ smallest pending (operation 2) */
            while (t.length() > 0 &&
                   t.charAt(t.length() - 1) <= (char) ('a' + smallest))
            {
                p.append(t.charAt(t.length() - 1));
                t.deleteCharAt(t.length() - 1);
            }
        }
        /* 4. Empty whatever is left on the stack */
        while (t.length() > 0) {
            p.append(t.charAt(t.length() - 1));
            t.deleteCharAt(t.length() - 1);
        }
        return p.toString();
    }
}
