class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int[][] dist = new int[n][m];
        for(int i = 0; i < n; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y) -> x[2] - y[2]);
        pq.offer(new int[] {0,0,0});

        int[] dirR = {0, 0, -1, 1};
        int[] dirC = {-1, 1, 0, 0};

        while(!pq.isEmpty()){
            int[] node = pq.poll();
            int row = node[0];
            int col = node[1];
            int dif = node[2];
            if(row == n-1 && col == m-1) return dif;

            for(int i = 0; i < 4; i++){
                int newRow = row + dirR[i];
                int newCol = col + dirC[i];
                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m){
                    int newDif = Math.abs(heights[newRow][newCol] - heights[row][col]);
                    int newEffort = Math.max(dif, newDif);
                    if(newEffort < dist[newRow][newCol]){
                        dist[newRow][newCol] = newEffort;
                        pq.offer(new int[] {newRow, newCol, newEffort});
                    }
                }
            }
        }
        return 0;
    }
}