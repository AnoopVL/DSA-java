class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        // adjacency list
        for(int i = 0; i < times.length; i++){
            int u = times[i][0];
            int v = times[i][1];
            int wt = times[i][2];
            adj.get(u).add(new int[] {v, wt});
        }
        // create and fill distance array\
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        // create priority queue(min heap)
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        pq.offer(new int[] {k, 0});
        while(!pq.isEmpty()){
            int node = pq.peek()[0];
            int weight = pq.poll()[1];
            for(int[] edge : adj.get(node)){
                if(edge[1] + weight < dist[edge[0]]){
                    dist[edge[0]] = edge[1] + weight;
                    pq.offer(new int[] {edge[0], dist[edge[0]]});
                }
            }
        }
        int ans = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++){
            if(dist[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, dist[i]);
        }
        return ans;
    }
}