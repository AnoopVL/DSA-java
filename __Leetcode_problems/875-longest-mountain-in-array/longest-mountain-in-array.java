class Solution {
    public int longestMountain(int[] arr) {
        int ans = 0;
        int n = arr.length;
        for(int i=1; i< n-1; i++){
            if(arr[i-1] < arr[i] && arr[i] > arr[i+1]){
                int l=i;
                int r=i;
                while(l > 0 && arr[l] > arr[l-1]){
                    l--;
                }
                while(r < n-1 && arr[r] > arr[r+1]){
                    r++;
                }
                ans = Math.max(ans, r-l+1);
            }
        }
        return ans;
    }
}