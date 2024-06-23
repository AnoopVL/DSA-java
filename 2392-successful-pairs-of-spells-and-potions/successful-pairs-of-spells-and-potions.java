class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] pairs = new int[spells.length];
        // int count = 0;
        // int start = 0;
        // int end = potions.length -1;
        // int mid = start + (end - start)/2;
        for(int i = 0; i<spells.length;i++){
            int start = 0;
            int end = potions.length -1;
            while(start<=end){
                int mid = start + (end - start)/2;
                if((long) spells[i]*potions[mid] >= success){
                    end = mid -1;
                }
                else{
                    start = mid +1;
                }
            }
            pairs[i] = potions.length - start;
        }
        return pairs;
    }
}