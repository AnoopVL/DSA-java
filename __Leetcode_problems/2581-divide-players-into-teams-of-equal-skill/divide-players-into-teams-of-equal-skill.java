class Solution {
    public long dividePlayers(int[] skill) {
        int teams = skill.length/2;
        int totalSum =0;
        long ans = 0;
        int i=0, j=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n= 0; n < skill.length; n++){
            map.put(skill[n], map.getOrDefault(skill[n], 0) + 1);
            totalSum += skill[n];
        }
        if(totalSum % teams != 0){
            return -1;
        }
        int targetPoints = totalSum / teams;
        for(int element : skill){
            if(map.get(element)==0){
                continue;
            }
            map.put(element, map.get(element)-1);
            int partner = targetPoints - element;
            if(!map.containsKey(partner) || map.get(partner)==0){
                return -1;
            }
            map.put(partner, map.get(partner)-1);
            ans  += ((long)element * (long)partner);
        }
        return ans;
    }
}
