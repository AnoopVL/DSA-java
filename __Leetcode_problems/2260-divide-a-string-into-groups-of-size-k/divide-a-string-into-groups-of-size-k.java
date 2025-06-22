class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        List<String> ansList = new ArrayList<>();
        int i =0;
        while(i < n){
            StringBuilder group = new StringBuilder();
            while(group.length() < k){
                if(i < n){
                    group.append(s.charAt(i));
                    i++;
                }else{
                    group.append(fill);
                }   
            }
            ansList.add(group.toString());
        }
        return ansList.toArray(new String[0]);
    }
}