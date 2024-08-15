class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans= new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        int k= p.length();

        for(int i=0; i< p.length(); i++){
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
        }

        int i=0;
        int j=0; 
        int count= map.size();

        while(j < s.length()){
            char ch= s.charAt(j);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)-1);
                if(map.get(ch) == 0){
                    count--;
                }
            }
            if((j-i+1) < k){
                j++;
            }
            else if((j-i+1) == k){
                if(count == 0){
                    ans.add(i);
                }
                char ch2 = s.charAt(i);
                if(map.containsKey(ch2)){
                    map.put(ch2, map.get(ch2)+1);
                    if(map.get(ch2) == 1){
                    count++;
                }
                }
                i++;
                j++;
            }
        }
        return ans;
    }
}