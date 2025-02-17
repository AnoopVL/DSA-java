class Solution {
    int len;
    public int numTilePossibilities(String tiles) {
        len = tiles.length();
        boolean[] used = new boolean[len];
        HashSet<String> set = new HashSet<>();
        backTrack(tiles, used, set, "");
        return set.size() - 1;
    }
    public void backTrack(String tiles, boolean[] used, HashSet<String> set, String current){
        if(set.contains(current)) return;
        set.add(current);
        for(int i=0; i < len; i++){
            if(used[i]) continue;
            used[i] = true;
            backTrack(tiles, used, set, current + tiles.charAt(i));
            used[i] = false;
        }
    }
}