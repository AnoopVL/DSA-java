class Solution {
    public boolean isBipartite(int[][] graph) {
        // dfs approach
        int n = graph.length;
        int[] visited = new int[n];
        for(int i = 0; i < n; i++) visited[i] = -1;
        for(int i = 0; i < n; i++){
            if(visited[i] == -1){
                if(dfs(i, 1, visited, graph) == false) return false;
            }
        }
        return true;
    }

    private boolean dfs(int node, int color, int[] visited, int[][] graph){
        visited[node] = color;
        for(int j : graph[node]){
            if(visited[j] == -1){
                if(dfs(j, 1 - color, visited, graph) == false) return false;
            }else if(visited[j] == color){
                return false;
            }
        }
        return true;
    }
}