class Solution {
    public int splitArray(int[] nums, int k) {
        int maxElement = Integer.MIN_VALUE;
        int sum = 0;
        for(int i : nums) {
            maxElement = Math.max(i, maxElement);
            sum += i;
        }
        //as lowest max subarray sum will be maxElement when k=nums.length
        int low = maxElement;
        int high = sum;

        while(low<=high) {
            int mid = low+(high-low)/2;
            //it is possible so try for less value
            if(isPossible(nums, mid, k)) high = mid-1;
            //not possible try for some higher value
            else low = mid+1;
        }
        return low;
    }
    public boolean isPossible(int[] nums, int mid, int k) {
        int sum=0;
        int count=1; //the last one
        for(int i=0; i<nums.length; i++) {
            sum+= nums[i];
            if(sum>mid) {
                sum=0;
                count++;
                sum=nums[i];
            }
            //as if no of subarrays are exceeding k the sum is too small hence increase the low
            if(count>k) {
                return false;
            }
        }
        return true;
    }
}