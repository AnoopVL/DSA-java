class Solution {
    public String compressedString(String word) {
        StringBuilder comp = new StringBuilder();
        int start =0;
        int i= 1;
        int n = word.length();
        while(i <= n){
            while((i<n) && (word.charAt(i)==word.charAt(start)) && ((i-start)<9)){
                i++;
            }
            comp.append(i - start);
            comp.append(word.charAt(start));
            start=i;
            i = start + 1;
        }
        return comp.toString();

    }
}