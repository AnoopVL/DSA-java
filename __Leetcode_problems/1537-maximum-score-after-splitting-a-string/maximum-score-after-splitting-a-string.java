class Solution {
    public int maxScore(String s) {
        int n= s.length();
        int ans = 0;
        int right =0;
        int left= 0;
        for(int i=0; i< n; i++ ){
            if(s.charAt(i)== '1') right++;
        }
        for(int i=0; i<n-1; i++){
            if(s.charAt(i)== '0'){
                left++;
            }else{
            
                right--;
            }
            ans= Math.max(ans, left+right);
        }
        return ans;

    }
}