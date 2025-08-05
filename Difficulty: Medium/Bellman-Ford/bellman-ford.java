class Solution {
    public int[] bellmanFord(int n, int[][] edges, int src) {
        int INF = (int)1e8;
        int[] dist = new int[n];
        
        for(int i = 0; i < n; i++) dist[i] = INF;
        dist[src] = 0;

        for(int i = 0; i < n - 1; i++){
            for(int[] edge : edges){
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];
                if(dist[u] != INF && dist[u] + wt < dist[v]){
                    dist[v] = dist[u] + wt;
                }
            }
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            if(dist[u] != INF && dist[u] + wt < dist[v]){
                return new int[]{-1};
            }
        }

        return dist;
    }
}
