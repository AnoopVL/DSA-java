class Solution {
    static class DisjointSet{
        int[] parent;
        int[] size;
        DisjointSet(int n){
            parent = new int[n];
            size = new int[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
                size[i] = 1;
            }
        }
        int find(int x){
           if (parent[x] != x) parent[x] = find(parent[x]);
           return parent[x];
        }
        boolean union(int u, int v){
            int ulpU = find(u);
            int ulpV = find(v);
            if(ulpU == ulpV) return false;
            if(size[ulpU] < size[ulpV]){
                parent[ulpU] = ulpV;
                size[ulpV] += size[ulpU];
            }else{
                parent[ulpV] = ulpU;
                size[ulpU] += size[ulpV];
            }
            return true;
        }
    }
    public int spanningTree(int V, int[][] edges) {
        // code here
        Arrays.sort(edges,(x,y) -> x[2] - y[2]);
        DisjointSet dsu = new DisjointSet(V);
        int ansWeight = 0;
        int edgesUsed = 0;
        for(int[] edge: edges){
            if(dsu.union(edge[0], edge[1])){
                ansWeight += edge[2];
                edgesUsed++;
                if(edgesUsed == V-1) break;
            }
        }
        return ansWeight;

    }
}
