class Solution {
    public int minimumDeletions(String word, int k) {
        int n = word.length();
        int ans = Integer.MAX_VALUE;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i< n; i++){
            char c = word.charAt(i);
            map.put(c, map.getOrDefault(c, 0) +1);
        }
        for(Map.Entry<Character, Integer> i : map.entrySet()){
            int del = 0;
            for(Map.Entry<Character, Integer> j : map.entrySet()){
                if(i.getKey() == j.getKey()) continue;
                int f1 = i.getValue();
                int f2 = j.getValue();
                int diff = f2 - f1;
                if(f1 > f2){
                    del += f2;
                }else if(diff > k){
                    del += (f2- f1- k);
                }
            }
            ans = Math.min(ans, del);
        }
        return ans;
    }
}