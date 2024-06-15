class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= right;
            right *= nums[i];
        }
        return answer;
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