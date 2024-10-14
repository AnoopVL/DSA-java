class Solution {
    public long maxKelements(int[] nums, int k) {
        // PriorityQueue<Integer> pq = new PriorityQueue<>();
        long ans =0;
        // This is minHeap
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(int i=0; i < nums.length; i++){
            pq.add(nums[i]);
        }
        while(k > 0){
            int temp = pq.poll();
            ans+= temp;
            temp = (int) Math.ceil((double)temp/3);
            pq.add(temp);
            k--;
        }
        return ans;
    }
}