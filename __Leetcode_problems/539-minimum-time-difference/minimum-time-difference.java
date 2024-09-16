class Solution {
    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints);
        int minDiff = Integer.MAX_VALUE;
        for(int i=1; i< timePoints.size(); i++){
            int currDiff = getTimeDiff(timePoints.get(i), timePoints.get(i-1));
            minDiff = Math.min(minDiff, currDiff);
        }
// Check if it crosses midnight
        int lastDiff = getTimeDiff(timePoints.get(0), timePoints.get(timePoints.size() -1), true);
        minDiff =  Math.min(minDiff, lastDiff);
        return minDiff;
    }

// Calculate the time difference in minutes
    private int getTimeDiff(String time1, String time2) {
        return getTimeDiff(time1, time2, false);
    }

// Calculate the time difference, with an option to handle crossing midnight
    private int getTimeDiff(String time1, String time2, boolean crossMidnight) {
        int minutes1 = convertToMinutes(time1);
        int minutes2 = convertToMinutes(time2);

        if (crossMidnight) {
            return Math.min(Math.abs(minutes1 - minutes2), 1440 - Math.abs(minutes1 - minutes2));
        } else {
            return Math.abs(minutes1 - minutes2);
        }
    }

// Convert a time string in "HH:MM" format to the total number of minutes since 00:00
    private int convertToMinutes(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return hours * 60 + minutes;
    }
}