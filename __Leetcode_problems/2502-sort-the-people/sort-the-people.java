class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n= heights.length;
        sort(heights, names, 0, n-1);
        System.gc();
        return names;
    }

    private int partition(int[] arr, String[] names, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] >= pivot) {
                i++;
                int temp = arr[i];
                String tempS = names[i];
                arr[i] = arr[j];
                names[i] = names[j];
                arr[j] = temp;
                names[j] = tempS;
            }
        }
        int temp = arr[i + 1];
        String tempS = names[i+1];
        arr[i + 1] = arr[high];
        names[i+1] = names[high];
        arr[high] = temp;
        names[high] = tempS;

        return i + 1;
    }

    private void sort(int[] arr, String[] names, int low, int high) {
        if (low < high) {
            int pi = partition(arr, names, low, high);
            sort(arr, names , low, pi - 1); 
            sort(arr, names, pi + 1, high);
        }
    }

}