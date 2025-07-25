class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] flight : flights) {
            adj.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

        // PriorityQueue: [node, cost so far, stops so far]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{src, 0, 0});

        // costPerNodeStop[node][stops] = min cost
        int[][] costPerNodeStop = new int[n][k + 2];
        for (int[] row : costPerNodeStop) Arrays.fill(row, Integer.MAX_VALUE);
        costPerNodeStop[src][0] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0], cost = curr[1], stops = curr[2];

            if (node == dst) return cost;
            if (stops > k) continue;

            for (int[] flight : adj.get(node)) {
                int nextNode = flight[0], price = flight[1];
                int totalCost = cost + price;

                // Only continue if this path is better than previous for this stop count
                if (totalCost < costPerNodeStop[nextNode][stops + 1]) {
                    costPerNodeStop[nextNode][stops + 1] = totalCost;
                    pq.offer(new int[]{nextNode, totalCost, stops + 1});
                }
            }
        }

        return -1;
    }
}
