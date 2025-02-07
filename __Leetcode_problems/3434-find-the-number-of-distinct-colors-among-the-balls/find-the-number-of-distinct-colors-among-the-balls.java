class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        // Map to track the current color of each ball
        HashMap<Integer, Integer> ballColorMap = new HashMap<>();
        // Map to track the count of each color
        HashMap<Integer, Integer> colorCountMap = new HashMap<>();
        // Result array to store the number of distinct colors after each query
        int[] result = new int[queries.length];
        
        for (int i = 0; i < queries.length; i++) {
            int ball = queries[i][0];
            int color = queries[i][1];
            
            if (ballColorMap.containsKey(ball)) { // Ball is already colored
                int existingColor = ballColorMap.get(ball); // Get existing color
                // Update the count of the existing color
                colorCountMap.put(existingColor, colorCountMap.get(existingColor) - 1);
                if (colorCountMap.get(existingColor) == 0) {
                    colorCountMap.remove(existingColor);
                }
                // Update the ball's color
                ballColorMap.put(ball, color);
                // Update the count of the new color
                colorCountMap.put(color, colorCountMap.getOrDefault(color, 0) + 1);
            } else { // Ball is not colored
                // Set the ball's color
                ballColorMap.put(ball, color);
                // Update the count of the new color
                colorCountMap.put(color, colorCountMap.getOrDefault(color, 0) + 1);
            }
            // Store the number of distinct colors
            result[i] = colorCountMap.size();
        }
        
        return result;
    }
}