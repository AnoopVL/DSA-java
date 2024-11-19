class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] ans = new int[n];
        if(k==0){
            return ans;
        }
        if(k > 0){
            for(int i=0; i< n; i++){
                int sum=0;
                for(int j=1; j <= k; j++){
                    int circularIndex = (i+j) % n; 
                    sum+=code[circularIndex];
                }
                ans[i]=sum;
            }
        }
        if(k < 0){
            for(int i=0; i< n; i++){
                int sum = 0;
                for(int j= 1; j <= Math.abs(k); j++){
                    int circularIndex = (i-j+n) %n;
                    sum+=code[circularIndex];
                }
                ans[i] = sum;
            }
        }
        return ans;
    }
}