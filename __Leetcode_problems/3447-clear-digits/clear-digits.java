class Solution {
    public String clearDigits(String s) {
        StringBuilder ans = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for(int i=0; i< s.length();i++){
            if(stack.isEmpty() && isNumber(s.charAt(i))){
                continue;
            }else if(!isNumber(s.charAt(i))){
                stack.push(s.charAt(i));
            }else if(!stack.isEmpty() && isNumber(s.charAt(i))){
                stack.pop();
            }
        }
        if(stack.isEmpty()){
            return "";
        }else{
            while(!stack.isEmpty()){
                ans.append(stack.pop());
            }
        }
        return ans.reverse().toString();
        
    }
    private boolean isNumber(char ch){
        if(ch == '1'|| ch == '2'|| ch == '3'|| ch == '4'|| ch == '5'|| ch == '6'|| ch == '7'|| ch == '8'|| ch == '9'|| ch == '0'){
            return true;
        }
        return false;
    }
}