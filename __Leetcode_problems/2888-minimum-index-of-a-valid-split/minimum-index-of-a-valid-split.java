class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n = nums.size();
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int xf = 0;
        int x = 0;
        for(int i = 0; i < n; i++){
            int num = nums.get(i);
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            if(freqMap.get(num) > xf){
                xf = freqMap.get(num);
                x = num;
            }
        }
        int f1 = 0;
        int t1 = 0;
        int f2 = xf;
        int t2 = n;
        for(int i= 0; i< n-1; i++){
            if(nums.get(i) == x){
                f1++;
                f2--;
            }
            t1++;
            t2--;
            if(isSplitValid(f1, t1, f2, t2)){
                return i;
            }
        }
        return -1;
    }
    private boolean isSplitValid(int f1, int t1, int f2, int t2){
        if(t1/2 < f1 && t2/2 < f2) return true;
        return false;
    }
}