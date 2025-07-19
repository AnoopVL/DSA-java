class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder, Comparator.comparing(s->s.length()));
        Set<String> seen = new HashSet<>();
        for(String s : folder){
            boolean alreadySeen = false;
            for(int i = 2; i < s.length(); i++){
                if(s.charAt(i) == '/' && seen.contains(s.substring(0,i))){
                    alreadySeen = true;
                    break;
                }
            }
            if(alreadySeen) continue;
            seen.add(s);
        }
        return new ArrayList<>(seen);
    }
}