class Solution {
    private int timer = 1;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++) adj.add(new ArrayList<>());
        for(List<Integer> it : connections){
            int u = it.get(0);
            int v = it.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] vis = new int[n];
        int[] tin = new int[n];
        int[] low = new int[n];
        List<List<Integer>> bridges = new ArrayList<>();
        dfs(0, -1, adj, bridges, vis, tin, low);
        return bridges;
    }

    private void dfs(int node, int parent, List<List<Integer>> adj, List<List<Integer>> bridges, int[] vis, int[] tin, int[] low){
        vis[node] = 1;
        low[node] = tin[node] = timer;
        timer++;
        for(Integer it : adj.get(node)){
            if(it == parent) continue;
            if(vis[it] == 0){
                dfs(it, node, adj, bridges, vis, tin, low);
                low[node] = Math.min(low[node], low[it]);
                if(low[it] > tin[node]) bridges.add(Arrays.asList(it, node));
            }else{
                low[node] = Math.min(low[node], low[it]);
            }
        }
    }
}