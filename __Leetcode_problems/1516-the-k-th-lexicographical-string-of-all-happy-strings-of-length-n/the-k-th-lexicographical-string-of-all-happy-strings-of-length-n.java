class Solution {
    private int count =0;
    private String ans = "";
    public String getHappyString(int n, int k) {
        backTrack(n, k, new StringBuilder(), ' ');
        return ans;
    }
    private void backTrack(int n, int k, StringBuilder sb, char prev){
        if(sb.length() == n){
            count++;
            if(count == k){
                ans = sb.toString();
            }
            return;
        }

        for(char ch: new char[] {'a', 'b', 'c'}){
            if (ch != prev) { // Ensure no two adjacent characters are the same
                sb.append(ch);
                backTrack(n, k, sb, ch);
                sb.deleteCharAt(sb.length() - 1); // Backtrack to restore original state
                if (!ans.isEmpty()) return; // Stop once we find the k-th happy string
            }
        }
    }

}