class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        List<Integer> ballLoc = new ArrayList<>();
        for(int i=0; i< n; i++){
            if(boxes.charAt(i) == '1') ballLoc.add(i);
        }
        int[] ans = new int[n];
        int ansIndex=0;
        for(int i=0; i< n; i++){
            int minMov = 0;
            for(int j=0; j< ballLoc.size(); j++){
                minMov += Math.abs(i - ballLoc.get(j));
            }
            ans[ansIndex++] = minMov;
            // ansIndex++;  
        }
        return ans;
    }
}