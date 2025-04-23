class Solution {
    public int countLargestGroup(int n) {
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(b -a));
        for(int i =1; i<= n; i++){
            int sum = digitSum(i);
            map.put(sum, map.getOrDefault(sum, 0) +1);
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            pq.add(entry.getValue());
        }
        while(!pq.isEmpty()){
            int max = pq.poll();
            ans++;
            if(!pq.isEmpty() && max != pq.peek()) break;
        }
        return ans;
    }

    private int digitSum(int num){
        int sum = 0;
        while(num > 0){
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}