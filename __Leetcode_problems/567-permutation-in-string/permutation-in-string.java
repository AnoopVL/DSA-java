class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int k = c1.length;
        HashMap<Character, Integer> s1map = new HashMap<>();
        HashMap<Character, Integer> s2map = new HashMap<>();
        for(char ch: c1){
            s1map.put(ch, s1map.getOrDefault(ch, 0) + 1);
        }
        int i=0, j=0;
        while(j < c2.length){
            s2map.put(c2[j], s2map.getOrDefault(c2[j], 0) + 1);
            if((j-i +1) < k){
                j++;
            }
            else{
                if(s1map.equals(s2map)){
                    return true;
                }
                if(s2map.get(c2[i]) == 1){
                    s2map.remove(c2[i]);
                }else{
                    s2map.put(c2[i], s2map.getOrDefault(c2[i], 0) -1);
                }
                i++;
                j++;
            }
        }
        return false;
    
    }
}