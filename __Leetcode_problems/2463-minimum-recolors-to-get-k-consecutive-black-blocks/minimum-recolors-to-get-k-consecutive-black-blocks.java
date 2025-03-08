class Solution {
    public int minimumRecolors(String blocks, int k) {
        int i=0,j=0,w=0,b=0;
        int ans = Integer.MAX_VALUE;
        int windowSize =0;
        while(j < blocks.length()){
            if(blocks.charAt(j) == 'W'){
                w++;
            }else{
                b++;
            }
            windowSize++;
            if(windowSize == k){
                ans = Math.min(ans, w);
                if(blocks.charAt(i) == 'W'){
                    w--;
                }else{
                    b--;
                }
                i++; 
                windowSize--;
            }
            j++;
        }
        return ans;
    }
}