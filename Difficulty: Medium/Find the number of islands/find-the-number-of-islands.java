//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    boolean isSafe(char M[][], int row, int col, boolean visited[][], int ROW,
                   int COL) {
      
        return (row >= 0) && (row < ROW) && (col >= 0) && (col < COL) &&
               (M[row][col] == '1' && !visited[row][col]);
    }
    void DFS(char M[][], int row, int col, boolean visited[][], int ROW,
             int COL) {
     
        int rowNbr[] = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
        int colNbr[] = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};

 
        visited[row][col] = true;

  
        for (int k = 0; k < 8; ++k)
            if (isSafe(M, row + rowNbr[k], col + colNbr[k], visited, ROW, COL))
                DFS(M, row + rowNbr[k], col + colNbr[k], visited, ROW, COL);
    }

    public int numIslands(char[][] grid) {
        // Code here
        int ROW = grid.length;
        int COL = grid[0].length;
        boolean visited[][] = new boolean[ROW][COL];


        int count = 0;
        for (int i = 0; i < ROW; ++i)
            for (int j = 0; j < COL; ++j)
                if (grid[i][j] == '1' && !visited[i][j]) 
                {                                        
                    DFS(grid, i, j, visited, ROW, COL);
                    ++count;
                }

        return count;
    }
}