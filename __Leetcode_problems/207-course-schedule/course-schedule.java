class Solution {
    public boolean canFinish(int n, int[][] preRequisites) {
        // Prepare the adjacency matrix
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        int m = preRequisites.length;
        for(int i = 0 ; i < m; i++){
            adj.get(preRequisites[i][1]).add(preRequisites[i][0]);
        }
        // Start with the topological sort(kahn's algo)
        int[] indegree = new int[n];
        for(int i = 0; i < n; i++){
            for(int j : adj.get(i)){
                indegree[j]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(indegree[i] == 0) q.add(i);
        }
        List<Integer> topo = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            topo.add(node);
            for(int j : adj.get(node)){
                indegree[j]--;
                if(indegree[j] == 0) q.add(j);
            }
        }
        return topo.size() == n;
    }
}