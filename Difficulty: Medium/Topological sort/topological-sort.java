class Solution {
    public static ArrayList<Integer> topoSort(int n, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);   
        }
        int[] visited = new int[n];
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            if(visited[i] == 0){
                dfs(i, st, visited, adj);
            }
        }
        
        while(!st.isEmpty()){
            ans.add(st.pop());
        }
        return ans;
        
    }
    
    private static void dfs(int node, Stack<Integer> st, int[] visited, ArrayList<ArrayList<Integer>> adj){
        visited[node] = 1;
        for(int j : adj.get(node)){
            if(visited[j] == 0){
                dfs(j, st, visited, adj);
            }
        }
        st.push(node);
    }
}