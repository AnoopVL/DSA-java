class Solution {
    public String simplifyPath(String path) {
        String[] pathArr= path.split("/");
        Stack<String> stack = new Stack<>();
        for(String patharr: pathArr){
            if(patharr.equals(".") || patharr.isEmpty()){
                continue;
            }else if(patharr.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else{
                stack.push(patharr);
            }
        }
        return "/"+String.join("/", stack);
    }
}