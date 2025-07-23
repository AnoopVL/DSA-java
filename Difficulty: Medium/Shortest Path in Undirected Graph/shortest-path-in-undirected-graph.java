
class Solution {
    // Function to find the shortest path from a source node to all other nodes
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        // code here
        int n = adj.size();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        while(!q.isEmpty()){
            int node = q.poll();
            for(int j : adj.get(node)){
                if(dist[node] + 1 < dist[j]){
                    dist[j] = dist[node] + 1;
                    q.offer(j);
                }
                
            }
        }
        for(int i = 0; i < n; i++){
            if(dist[i] == Integer.MAX_VALUE) dist[i] = -1;
        }
        
        return dist;
    }
}
