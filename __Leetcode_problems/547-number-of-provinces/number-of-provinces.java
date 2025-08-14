class Solution {
    class DisjointSet{
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
            if(parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }
        void union(int u, int v){
            int ulpU = find(u);
            int ulpV = find(v);
            if(ulpU == ulpV) return;
            if(size[ulpU] < size[ulpV]){
                parent[ulpU] = ulpV;
                size[ulpV] += size[ulpU];
            }else{
                parent[ulpV] = ulpU;
                size[ulpU] += size[ulpV]; 
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        DisjointSet dsu = new DisjointSet(n);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(isConnected[i][j] == 1) dsu.union(i,j);
            }
        }
        int ansCount = 0;
        for(int i = 0; i < n; i++){
            if(dsu.parent[i] == i) ansCount++;
        }
        return ansCount;
    }
}