class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum =0;
        int n= nums.length;
        for(int i=0; i< n; i++){
            totalSum += nums[i]; 
        }
        if(totalSum%2 != 0){
            return false;
        }else{
            int targetSum = totalSum/2;
            boolean[][] t = new boolean[n+1][targetSum+1];

            for(int i=0; i<n+1;i++){
                t[i][0] = true;
            }

            for(int i=1; i<n+1; i++){
                for(int j=1; j<targetSum+1; j++){
                    if(nums[i-1] <= j){
                        t[i][j] = t[i-1][j] || t[i-1][j - nums[i-1]];
                    }else{
                        t[i][j] = t[i-1][j];
                    }
                }
            }
            return t[n][targetSum];
        }
    }
}