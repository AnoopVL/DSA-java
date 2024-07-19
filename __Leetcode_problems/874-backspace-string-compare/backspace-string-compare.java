class Solution {
    public boolean backspaceCompare(String s, String t) {
        return getFinalString(s).equals(getFinalString(t));
    }
    private String getFinalString(String s){
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            // char ch = s.charAt(i);

            if (s.charAt(i) == '#') {
                if (str.length() > 0) {
                    str.setLength(str.length() - 1);
                }
            } else {
                str.append(s.charAt(i));
            }
        }
        return str.toString();
    }

}