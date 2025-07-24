class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i= 0; i <= n; i++) adj.add(new ArrayList<>());
        for(int[] edge: times){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            adj.get(u).add(new int[]{v, wt});
        }

        int[] distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y) -> x[1] - y[1]);
        pq.offer(new int[] {k, 0});
        while(!pq.isEmpty()){
            int node = pq.peek()[0];
            int dist = pq.poll()[1];
            for(int[] edge : adj.get(node)){
                if(edge[1] + dist < distance[edge[0]]){
                    distance[edge[0]] = edge[1] + dist;
                    pq.offer(new int[]{edge[0], distance[edge[0]]});
                }
            }
        }

        int ans = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++){
            if(distance[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, distance[i]);
        }
        return ans;
    }
}