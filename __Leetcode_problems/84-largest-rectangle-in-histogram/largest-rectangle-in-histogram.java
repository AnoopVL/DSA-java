class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea =0;

        stack.push(0);

        for(int i =0; i<heights.length; i++){
            while(!stack.isEmpty() && heights[i]<heights[stack.peek()]){
                maxArea = getMax(heights, stack, maxArea, i);
            }
            stack.push(i);
        }
        int i = heights.length;
        while(!stack.isEmpty()){
            maxArea = getMax(heights, stack, maxArea, i);
        }            
        return maxArea;
    }
    public int getMax(int[] arr, Stack<Integer> stack, int max, int i ){
        int area = 0;
        int popped = stack.pop();
        if(stack.isEmpty()){
            area = arr[popped] * i;
        }
        else{
            area = arr[popped] * (i - 1 -stack.peek());
        }
        return Math.max(max, area);
    }
}