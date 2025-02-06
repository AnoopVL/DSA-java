class Solution {
    public int tupleSameProduct(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans =0;
        for(int i=0; i< n; i++){
            for(int j=i+1; j< n; j++){
                int product = nums[i] * nums[j];
                map.put(product, map.getOrDefault(product, 0) +1);
            }
        }
        for(Map.Entry<Integer, Integer> mapEntry : map.entrySet()){
            int count = mapEntry.getValue();
            if(count >= 2){
                int combination = (count*(count-1))/2;
                ans = ans + combination*8;
            }
        }
        return ans;
    }
}