package TotalCosttoHireKWorkers;

import java.util.PriorityQueue;

public class TotalCosttoHireKWorkers {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        long total = 0;

        PriorityQueue<int[]> leftHeap = new PriorityQueue<>((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        PriorityQueue<int[]> rightHeap = new PriorityQueue<>((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

        int l = 0, r = n - 1;


        for (int i = 0; i < candidates && l <= r; i++) leftHeap.offer(new int[]{costs[l], l++});
        for (int i = 0; i < candidates && l <= r; i++) rightHeap.offer(new int[]{costs[r], r--});

        for (int i = 0; i < k; i++) {
            if (rightHeap.isEmpty() || (!leftHeap.isEmpty() && leftHeap.peek()[0] <= rightHeap.peek()[0])) {
                int[] worker = leftHeap.poll();
                total += worker[0];
                if (l <= r) leftHeap.offer(new int[]{costs[l], l++});
            } else {
                int[] worker = rightHeap.poll();
                total += worker[0];
                if (l <= r) rightHeap.offer(new int[]{costs[r], r--});
            }
        }

        return total;
    }


    public static void main(String[] args) {
        TotalCosttoHireKWorkers sol = new TotalCosttoHireKWorkers();

        int[] costs1 = {17,12,10,2,7,2,11,20,8};
        System.out.println(sol.totalCost(costs1, 3, 4)); // 11

        int[] costs2 = {1,2,4,1};
        System.out.println(sol.totalCost(costs2, 3, 3)); // 4
    }
}


//You are given a 0-indexed integer array costs where costs[i] is the cost of hiring the ith worker.
//
//You are also given two integers k and candidates. We want to hire exactly k workers according to the following rules:
//
//You will run k sessions and hire exactly one worker in each session.
//In each hiring session, choose the worker with the lowest cost from either the first candidates workers or the last candidates workers. Break the tie by the smallest index.
//For example, if costs = [3,2,7,7,1,2] and candidates = 2, then in the first hiring session, we will choose the 4th worker because they have the lowest cost [3,2,7,7,1,2].
//In the second hiring session, we will choose 1st worker because they have the same lowest cost as 4th worker but they have the smallest index [3,2,7,7,2]. Please note that the indexing may be changed in the process.
//If there are fewer than candidates workers remaining, choose the worker with the lowest cost among them. Break the tie by the smallest index.
//A worker can only be chosen once.
//Return the total cost to hire exactly k workers.