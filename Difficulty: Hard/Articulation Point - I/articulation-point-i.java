class Solution {
    private int timer = 0;

    public ArrayList<Integer> articulationPoints(int n,
                                                 ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[n];
        int[] low = new int[n];
        int[] tin = new int[n];
        int[] marked = new int[n];

        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                dfs(i, -1, vis, tin, low, marked, adj);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (marked[i] == 1) ans.add(i);
        }
        if (ans.size() == 0) ans.add(-1);
        return ans;
    }

    private void dfs(int node, int parent, int[] vis, int[] tin, int[] low,
                     int[] marked, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = 1;
        tin[node] = low[node] = timer++;
        int child = 0;

        for (Integer it : adj.get(node)) {
            if (it == parent) continue;
            if (vis[it] == 0) {
                dfs(it, node, vis, tin, low, marked, adj);
                low[node] = Math.min(low[node], low[it]);

                if (low[it] >= tin[node] && parent != -1) {
                    marked[node] = 1;
                }
                child++;
            } else {
                low[node] = Math.min(low[node], tin[it]);
            }
        }

        if (parent == -1 && child > 1) {
            marked[node] = 1;
        }
    }
}
