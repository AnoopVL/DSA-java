class Solution {
    public String clearStars(String s) {
        HashMap<Character, List<Integer>> map = new HashMap<>();
        PriorityQueue<Character> pq = new PriorityQueue<>();
        int n = s.length();
        boolean[] vector = new boolean[n];

        for(int i=0; i< n; i++){
            char c = s.charAt(i);
            if(c == '*'){
                vector[i] = true;
                char sc = pq.poll();
                List<Integer> scList = map.get(sc);
                if(scList != null && !scList.isEmpty()){
                    int scIndex = scList.get(scList.size()-1);
                    vector[scIndex] = true;
                    scList.remove(scList.size()-1);
                    map.put(sc, scList);
                }
                continue;
            }
            map.putIfAbsent(c, new ArrayList<>());
            map.get(c).add(i);
            pq.add(c);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< n; i++){
            if(vector[i] == false){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}