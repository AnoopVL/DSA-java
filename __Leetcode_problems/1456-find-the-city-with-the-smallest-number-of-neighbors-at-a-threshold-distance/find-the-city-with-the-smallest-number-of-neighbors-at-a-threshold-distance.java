class Solution {
    public int findTheCity(int n, int[][] edges, int threshold) {
        int[][] dist = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j){
                    dist[i][j] = 0;
                    continue;
                } 
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            dist[u][v] = wt;
            dist[v][u] = wt;
        }
        // Floyd Warshall algo- matrix filling
        for(int via = 0; via < n; via++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(dist[i][via] != Integer.MAX_VALUE && dist[via][j] != Integer.MAX_VALUE){
                        dist[i][j] = Math.min(dist[i][j], dist[i][via] + dist[via][j]);
                    }
                }
            }
        }

        int minCount = n;
        int cityNo = -1;
        for(int city = 0; city < n ; city++){
            int count = 0;
            for(int adjCity = 0; adjCity < n; adjCity++){
                if(city == adjCity) continue;
                if(dist[city][adjCity] <= threshold) count++;
            }
            if(count <= minCount){
                minCount = count;
                cityNo = city;
            }
        }

        return cityNo;
    }
}