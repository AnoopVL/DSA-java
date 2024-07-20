class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalTank = 0;
        int currentTank = 0;
        int startingStation = 0;
        for (int i = 0; i < gas.length; i++) {
            totalTank += gas[i] - cost[i];
            currentTank += gas[i] - cost[i];
            // If current tank is negative, we cannot start from the current starting station
            if (currentTank < 0) {
                startingStation = i + 1; // Set next station as the starting one
                currentTank = 0; // Reset current tank
            }
        }
        // If total gas is greater than or equal to total cost, return the starting station index
        System.gc();
        return totalTank >= 0 ? startingStation : -1;
    }
}