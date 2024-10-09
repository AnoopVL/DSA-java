class Solution {
    public int minAddToMakeValid(String s) {
        if(s == ""){
            return 0;
        }
        Stack<Character> stack = new Stack<>();
        for(int i =0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(s.charAt(i));
            }else{
                if(!stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                }else{
                    stack.push(s.charAt(i));
                }
            }
        }
        return stack.size();
    }
}