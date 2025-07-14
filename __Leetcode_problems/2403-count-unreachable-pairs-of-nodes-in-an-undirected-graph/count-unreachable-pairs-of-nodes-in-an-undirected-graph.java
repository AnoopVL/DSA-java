class Solution {
    public long countPairs(int n, int[][] edges) {
        int[] visited = new int[n];
        long ans = 0;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        ArrayList<Long> connectedGraphs = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(visited[i] == 0){
                Long length = dfs(i, visited, adj);
                connectedGraphs.add(length);
            }
        }
        // take a look at this again
        long total = (long) n;
        long totalPairs = total * (total - 1) / 2;
        long sameComponentPairs = 0;
        for(Long size : connectedGraphs){
            sameComponentPairs += size * (size - 1) / 2;
        }
        return totalPairs - sameComponentPairs;
    }

    private long dfs (int node, int[] visited, ArrayList<ArrayList<Integer>> adj){
        visited[node] = 1;
        long length = 1;
        for(int connectedNode : adj.get(node)){
            if(visited[connectedNode] == 0){
                length += dfs(connectedNode, visited, adj);
            }
        }
        return length;
    }
}