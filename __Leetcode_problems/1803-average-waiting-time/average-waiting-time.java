class Solution {
    public double averageWaitingTime(int[][] customers) {
        double wait = 0;
        int runTime = -1;
        for(int[] a : customers) {
            runTime = (runTime<a[0])?a[0]:runTime;
            runTime += a[1];
            wait += runTime-a[0];
        }
        System.gc();
        return wait/customers.length;
    }
}

//     ArrayList<Integer> list = new ArrayList<>();
    //     int runningTime = customers[0][0];
    //     int waitingTime = 0;
    //     for(int i = 0; i< customers.length; i++){
    //         if(runningTime >= customers[i][0]){
    //             runningTime+=customers[i][1]; 
    //             waitingTime = (runningTime) - customers[i][0];
    //             list.add(waitingTime);
    //             // runningTime+=customers[i][0]+customers[i][1];
    //         }
    //         else{
    //             runningTime = customers[i][0] + customers[i][1];
    //             waitingTime = runningTime - customers[i][0];
    //             list.add(waitingTime);
    //         }
    //     }
    //     return calculateAverage(list);
    // }
    // public double calculateAverage(ArrayList<Integer> list) {
    //     double sum = 0;
    //     for (int number : list) {
    //         sum += number;
    //     }
        
    //     return sum / list.size();
    // }