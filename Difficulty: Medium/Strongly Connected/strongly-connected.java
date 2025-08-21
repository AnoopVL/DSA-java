class Solution {
    // Function to find number of strongly connected components in the graph.
    public int kosaraju(ArrayList<ArrayList<Integer>> adj) {
        int v = adj.size();
        Stack<Integer> st = new Stack<>();
        int[] vis = new int[v];

        // 1st DFS pass to fill stack
        for(int i = 0; i < v; i++){
            if(vis[i] == 0) dfs(i, vis, adj, st);
        }
        
        // Build transpose graph
        ArrayList<ArrayList<Integer>> adjT = new ArrayList<>();
        for(int i = 0; i < v; i++){
            adjT.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < v; i++){
            for(Integer it : adj.get(i)){
                adjT.get(it).add(i);
            }
        }

        // Reset visited array
        Arrays.fill(vis, 0);

        // 2nd DFS pass
        int scc = 0;
        while(!st.isEmpty()){
            int node = st.pop();
            if(vis[node] == 0){
                scc++;
                dfs3(node, vis, adjT);
            }
        }
        return scc;
    }
    
    private void dfs(int node, int[] vis, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st){
        vis[node] = 1;
        for(Integer it : adj.get(node)){
            if(vis[it] == 0) dfs(it, vis, adj, st);
        }
        st.push(node);
    }
    
    private void dfs3(int node, int[] vis, ArrayList<ArrayList<Integer>> adjT){
        vis[node] = 1;
        for(Integer it : adjT.get(node)){
            if(vis[it] == 0) dfs3(it, vis, adjT);
        }
    }
}
