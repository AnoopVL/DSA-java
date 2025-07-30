// User function Template for Java

class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {
        // Your code here
        if(start == end) return 0;
        int mod = 100000;
        int[] opp = new int[100001];
        Arrays.fill(opp, Integer.MAX_VALUE);
        opp[start] = 0;
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        int multiplication = 0;
        while(!q.isEmpty()){
            int size = q.size();
            multiplication++;
            while(size > 0){
                int node = q.poll();
                if(node == end) return opp[node];
                size--;
                for(int num : arr){
                    int j = (node*num) % mod;
                    if(opp[j] > multiplication){
                        opp[j] = multiplication;
                        q.offer(j);
                    }
                }
            }
        }
        return -1;
    }
}
