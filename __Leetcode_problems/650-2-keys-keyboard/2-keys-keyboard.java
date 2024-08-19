class Solution {
    public int minSteps(int n) {
        int ans = 0;
        for(int factor =2; factor*factor <= n; factor++){
            while( n % factor == 0){
                ans+=factor;
                n/= factor;
            }
        }
        if(n > 1){
            ans+=n;
        }
        return ans;
    }
}