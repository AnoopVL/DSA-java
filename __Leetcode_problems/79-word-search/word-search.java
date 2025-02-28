class Solution {
    // boolean doesExist = false;
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for(int i=0; i< rows; i++){
            for(int j=0; j< cols; j++){
                if(backTrack(board, i, j, 0, word, visited)){
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean backTrack(char[][] board, int r, int c, int index, String word, boolean[][] visited){
        // if(doesExist) return true;
        if(index == word.length()){
            // doesExist = true;
            return true;
        }

        int rows = board.length;
        int cols = board[0].length;

        if(r < 0 || r >= rows || c < 0 || c >= cols || visited[r][c] || board[r][c] != word.charAt(index)){
            return false;
        }

        visited[r][c] = true;

        if( backTrack(board, r+1, c, index+1, word, visited)  || backTrack(board, r-1, c, index+1, word, visited) || backTrack(board, r, c+1, index+1, word, visited) || backTrack(board, r, c-1, index+1, word, visited) ) {
            return true;
        }

        visited[r][c] = false;
        return false;
    }
}