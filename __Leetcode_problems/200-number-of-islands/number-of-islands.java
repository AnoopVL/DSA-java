class Solution {
    class DisjointSet{
        int[] parent, size;
        DisjointSet(int n){
            parent = new int[n];
            size = new int[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
                size[i] = 1;
            }
        }
        int find(int x){
            if(parent[x] != x){
                parent[x] = find(parent[x]);
            }
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
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        DisjointSet ds = new DisjointSet(n * m);
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '1'){
                    int node = i * m + j;  
                    for(int[] d : directions){
                        int ni = i + d[0];
                        int nj = j + d[1];
                        if(ni >= 0 && ni < n && nj >= 0 && nj < m && grid[ni][nj] == '1'){
                            int adjNode = ni * m + nj;
                            ds.union(node, adjNode);
                        }
                    }
                }
            }
        }     

        HashSet<Integer> uniqueIslands = new HashSet<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '1'){
                    uniqueIslands.add(ds.find(i * m + j));
                }
            }
        }   
        return uniqueIslands.size();
    }
}