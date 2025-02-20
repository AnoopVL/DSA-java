class Solution {
    String ans = "";
    HashSet<String> set = new HashSet<>();
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        // HashSet<String> set = new HashSet<>();
        for(String str : nums){
            set.add(str);
        }
        backTrack(n, new StringBuilder());
        return ans;
    }
    private void backTrack(int n, StringBuilder sb){
        if(sb.length() == n){
            if(!set.contains(sb.toString())){
                ans = sb.toString();
                // return;
            }
            return;
        }

        for(char ch: new char[] {'0', '1'}){
            sb.append(ch);
            backTrack(n, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}