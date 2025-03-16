class Solution {
    public long repairCars(int[] ranks, int cars) {
        long start = Long.MAX_VALUE;
        long end = Long.MIN_VALUE;
        long ans = 0;
        for(int i=0; i< ranks.length; i++){
            start = Math.min(start, ranks[i]);
            end = Math.max(end, ranks[i]);
        }
        end = end * cars * cars;
        while(start <= end){
            long mid = start + (end - start)/2;
            if(canRepairCars(mid, ranks, cars)){
                ans = mid;
                end = mid -1;
            }else{
                start = mid +1;
            }
        }
        return ans;
    }

    public boolean canRepairCars(long time, int[] ranks, int carsToBeRepaired){
        long carsRepaired = 0;
        for(int rank: ranks){
            carsRepaired += (long)(Math.sqrt((1.0 * time) / rank));
            if(carsRepaired >= carsToBeRepaired) return true;
        }
        return false;
    }
}