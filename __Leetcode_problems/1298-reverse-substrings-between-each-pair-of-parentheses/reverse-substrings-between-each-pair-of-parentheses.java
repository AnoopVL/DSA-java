class Solution {
    int i = 0;
    public String reverseParentheses(String s) {
        char[] arr = s.toCharArray();
        return helper(arr);
    }
    private String helper(char[] arr){
        StringBuilder sb = new StringBuilder();
        while (i < arr.length){
            if(arr[i] == '('){
                i++;
                String st = helper(arr);
                sb.append(st);
            }
            else if(arr[i] == ')'){
                i++;
                return sb.reverse().toString();
            }
            else{
                sb.append(arr[i]);
                i++;
            }
        }
        return sb.toString();
    }
}