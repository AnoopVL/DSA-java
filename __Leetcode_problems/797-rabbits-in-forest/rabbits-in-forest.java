class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for(int num : answers){
            if(num == 0){
                ans++;
                continue;
            }
            map.put(num, map.getOrDefault(num, 0) +1);
            if(map.get(num) == num+1){
                ans+= map.get(num);
                map.remove(num);
            }
        }
        if(!map.isEmpty()){
            for(Map.Entry<Integer, Integer> entry : map.entrySet()){
                ans += entry.getKey() +1;
            }
        }
        return ans;
    }
}