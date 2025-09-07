class Solution {
    public boolean canFinish(int n, int[][] preReq) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        int m = preReq.length;
        for(int i = 0; i < m; i++){
            adj.get(preReq[i][1]).add(preReq[i][0]);
        }
        int[] indegree = new int[n];
        for(int i = 0; i < n; i++){
            for(int j : adj.get(i)){
                indegree[j]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        List<Integer> courseCompleted = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(indegree[i] == 0) q.add(i);
        }
        while(!q.isEmpty()){
            int node = q.poll();
            courseCompleted.add(node);
            for(int j : adj.get(node)){
                indegree[j]--;
                if(indegree[j] == 0) q.add(j);
            }
        }

        return courseCompleted.size() == n;
    }
}