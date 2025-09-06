class Solution {
    public int findClosest(int x, int y, int z) {
        int p1 = Math.abs(x - z);
        int p2 = Math.abs(y - z);
        return (p1 < p2)? 1 : (p2 < p1 ? 2 : 0);
    }
}