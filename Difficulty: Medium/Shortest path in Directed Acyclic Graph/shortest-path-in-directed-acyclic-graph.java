class Solution {
    public int[] shortestPath(int V, int E, int[][] edges) {
        // Create adjacency list as List of int arrays [neighbor, weight]
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            adj.get(u).add(new int[]{v, wt});
        }

        // Step 1: Topological sort
        int[] visited = new int[V];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                topoSort(i, adj, visited, stack);
            }
        }

        // Step 2: Distance array
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (dist[node] != Integer.MAX_VALUE) {
                for (int[] edge : adj.get(node)) {
                    int v = edge[0];
                    int wt = edge[1];
                    if (dist[node] + wt < dist[v]) {
                        dist[v] = dist[node] + wt;
                    }
                }
            }
        }

        // Replace unreachable nodes with -1
        for (int i = 0; i < V; i++) {
            if (dist[i] == Integer.MAX_VALUE) dist[i] = -1;
        }

        return dist;
    }

    private void topoSort(int node, List<List<int[]>> adj, int[] visited, Stack<Integer> stack) {
        visited[node] = 1;
        for (int[] edge : adj.get(node)) {
            int v = edge[0];
            if (visited[v] == 0) {
                topoSort(v, adj, visited, stack);
            }
        }
        stack.push(node);
    }
}
