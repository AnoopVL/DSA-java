class Solution {
    public int[] findOrder(int n, int[][] preR) {
        // Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        int m = preR.length;
        // // create an array indegree
        int[] indegree = new int[n];
        for(int i = 0; i < m; i++){
            adj.get(preR[i][1]).add(preR[i][0]);
            indegree[preR[i][0]]++;
        }
        // create a queue and add all the elements with indegree 0
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(indegree[i] == 0) q.add(i);
        }
        List<Integer> ansList = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            ansList.add(node);
            for(int j : adj.get(node)){
                indegree[j]--;
                if(indegree[j] == 0) q.add(j);
            }
        }
        if(ansList.size() != n){
            return new int[0];
        }else{
            return ansList.stream().mapToInt(i -> i).toArray();
        }
    }
}