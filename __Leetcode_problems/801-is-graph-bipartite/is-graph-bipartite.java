class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] visited = new int[n];
        for(int i = 0; i< n; i++){
            if(visited[i] == 0){
                if(!isBipartite(visited, graph, n, i)) return false;
            }
        }
        return true;
    }

    private boolean isBipartite(int[] visited, int[][] graph, int n, int i){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        visited[i] = 1;
        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int j : graph[node]){
                if(visited[j] == 0){
                    visited[j] = (visited[node] == 1)? 2: 1;
                    queue.add(j);
                }else if(visited[j] == visited[node]){
                    return false;
                }
            }
        }
        return true;
    }
}