class Solution {
    public boolean judgeCircle(String moves) {
        int x =0, y=0;
        for(int i = 0; i < moves.length(); i++){
            if(moves.charAt(i) == 'U') x= x-1;
            if(moves.charAt(i) == 'D') x= x+1;
            if(moves.charAt(i) == 'L') y= y-1;
            if(moves.charAt(i) == 'R') y= y+1;
        }
        return (x == 0 && y == 0);
    }
}