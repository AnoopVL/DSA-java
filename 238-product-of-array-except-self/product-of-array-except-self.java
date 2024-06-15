class Solution {
    public int[] productExceptSelf(int[] nums) {
        int ans[] = new int[nums.length];
        Arrays.fill(ans, 1);
        int current = 1;
        for(int i = 0; i< nums.length;i++){
            ans[i] = ans[i]*current;
            current = current*nums[i];
        }
        current = 1;
        for(int i = nums.length-1; i>=0; i--){
            ans[i] = ans[i]*current;
            current = current*nums[i];
        }
        return ans;
    }
}
// BRUTE-FORCE
        // List<Integer> list = new ArrayList<>();
        // int product = 1;
        // boolean isZero = false;
        // for(int i = 0; i< nums.length; i++){
        //     if(nums[i]!=0){
        //         product = product*nums[i];
        //     }
        //     else{
        //         isZero = true;
        //     }
        // }
        // for(int i = 0; i<nums.length;i++){
        //     if(isZero){
        //         list.add(0);
        //     }
        //     if(nums[i]!=0){
        //         list.add(product/nums[i]);
        //     }
        // }
        // int[] result = list.stream().mapToInt(Integer::intValue).toArray();
        // return result;