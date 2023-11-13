class Solution {
    public static List<Integer> findDuplicates(int[] nums) {
        int i=0;
        while (i<nums.length) {
            int correctPos=nums[i]-1;
            if (nums[correctPos]!=nums[i]) {
                swap(nums, i, correctPos);
            }
            else{
                i++;
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int index = 0; index < nums.length; index++) {
            if (nums[index]!=index+1) {
                ans.add(nums[index]);
            }
        }
        return ans;
    }
    public static void swap(int[]nums, int i, int correctPos){
        int temp=nums[i];
        nums[i]=nums[correctPos];
        nums[correctPos]=temp;
    }
}