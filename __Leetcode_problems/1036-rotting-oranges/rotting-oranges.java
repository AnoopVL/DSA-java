class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        Queue<int[]> queue = new LinkedList<>();
        int rows = grid.length;
        int cols = grid[0].length;
        int freshCount = 0;
        for(int i=0; i < rows; i++){
            for(int j=0; j < cols; j++){
                if(grid[i][j] == 2){
                    queue.offer(new int[] {i,j});
                }else if(grid[i][j] == 1){
                    freshCount++;
                }
            }
        }
        if(freshCount == 0) return 0;
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        int count = 0;
        while(!queue.isEmpty()){
            count++;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] loc = queue.poll();
                for(int dir[] : directions){
                    int x = loc[0] + dir[0];
                    int y = loc[1] + dir[1];
                    if(x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] == 0 || grid[x][y] == 2) continue;
                    grid[x][y] = 2;
                    queue.offer(new int[] {x,y});
                    freshCount--;
                }
            }

        }
        return freshCount == 0? count - 1 : -1;
    }
}