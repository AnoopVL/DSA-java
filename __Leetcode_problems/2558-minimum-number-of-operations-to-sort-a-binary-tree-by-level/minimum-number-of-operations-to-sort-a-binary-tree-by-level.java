class Solution {
    public int minimumOperations(TreeNode root) {
        if (root == null) return 0;
        
        int totalSwaps = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            ArrayList<Integer> currentLevel = new ArrayList<>();
            
            // Collect all node values at the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                currentLevel.add(current.val);
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
            
            // Calculate minimum swaps to sort the current level
            totalSwaps += getMinimumSwaps(currentLevel);
        }
        
        return totalSwaps;
    }
    
    private int getMinimumSwaps(ArrayList<Integer> nums) {
        int n = nums.size();
        int[] sortedNums = nums.stream().mapToInt(i -> i).toArray();
        Arrays.sort(sortedNums);
        
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(sortedNums[i], i);
        }
        
        boolean[] visited = new boolean[n];
        int swaps = 0;
        
        for (int i = 0; i < n; i++) {
            if (visited[i] || indexMap.get(nums.get(i)) == i) continue;
            
            int cycleSize = 0;
            int current = i;
            
            while (!visited[current]) {
                visited[current] = true;
                current = indexMap.get(nums.get(current));
                cycleSize++;
            }
            
            if (cycleSize > 1) {
                swaps += (cycleSize - 1);
            }
        }
        
        return swaps;
    }
}
