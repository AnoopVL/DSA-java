class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            adj.get(u).add(new int[]{v, wt});
        }
        
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y) -> x[1] - y[1]);
        pq.offer(new int[] {src, 0});
        while(!pq.isEmpty()){
            int node = pq.peek()[0];
            int dist = pq.peek()[1];
            pq.poll();
            for(int[] edge : adj.get(node)){
                if(edge[1] + dist < distance[edge[0]]){
                    distance[edge[0]] = edge[1] + dist;
                    pq.offer(new int[] {edge[0], distance[edge[0]]});
                }   
            }
        }
        return distance;
    }
}