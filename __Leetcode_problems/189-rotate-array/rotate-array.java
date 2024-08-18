class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        rotateArr(nums, 0 , nums.length -1 -k );
        rotateArr(nums, nums.length -k , nums.length -1 );
        rotateArr(nums, 0 , nums.length -1);
    }

    private void rotateArr(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }

}