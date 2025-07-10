class Solution {
    public boolean isCyclic(int n, int[][] edges) {
        // Step 1: Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }

        int[] visited = new int[n];
        int[] pathVisited = new int[n];
        for(int i = 0; i < n; i++) {
            if(visited[i] == 0) {
                if(dfs(i, adj, visited, pathVisited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int node, List<List<Integer>> adj, int[] visited, int[] pathVisited) {
        visited[node] = 1;
        pathVisited[node] = 1;

        for(int neighbor : adj.get(node)) {
            if(visited[neighbor] == 0) {
                if(dfs(neighbor, adj, visited, pathVisited)) return true;
            } else if(pathVisited[neighbor] == 1) {
                return true;
            }
        }

        pathVisited[node] = 0;
        return false;
    }
}
