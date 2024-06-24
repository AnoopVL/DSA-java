class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int start = 1;
        int end = 1000000000;
        // int end = piles[piles.length-1];
        while (start<=end){
            int k = start + (end - start)/2;
            if(canFinishBananas(piles, k, h)){
                end = k -1;
            }
            else{
                start = k + 1;
            }
        }
        return start;
    }
    public boolean canFinishBananas(int[] piles, int k, int h){
         long hours = 0;  // Change to long to prevent overflow
        for (int pile : piles) {
            hours += (pile + k - 1) / k;  // Ceiling division
            if (hours > h) return false;  // Early exit if hours exceed h
        }
        return true;
    }
}