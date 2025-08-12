class Solution {
    public int spanningTree(int V, int[][] edges) {
        // code here
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for(int i = 0 ; i < edges.length ; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new int[]{v, wt});
            adj.get(v).add(new int[]{u, wt});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y) -> (x[1] - y[1]));
        pq.add(new int[]{0,0});
        int[] vis = new int[V];
        int sum = 0;
        
        while(!pq.isEmpty()){
            int[] poll = pq.poll();
            int node = poll[0];
            int wt = poll[1];
            if(vis[node] == 1) continue;
            vis[node] = 1;
            sum += wt;
            for (int[] edge : adj.get(node)) {
                int adjNode = edge[0];
                int edW = edge[1];
                if (vis[adjNode] == 0) pq.add(new int[]{adjNode, edW});
            }

        }
        return sum;
    }
}
