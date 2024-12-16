class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int []> pq = new PriorityQueue<>((a, b) -> {
            if(a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        for(int i =0; i < nums.length; i++){
            pq.offer(new int[] {nums[i], i});
        }

        while( k > 0){
            int[] multiply = pq.poll();
            multiply[0] = multiply[0] * multiplier;
            nums[multiply[1]] = multiply[0];
            pq.offer(new int[] {multiply[0], multiply[1]});
            k--;
        }
        return nums;
    }
}