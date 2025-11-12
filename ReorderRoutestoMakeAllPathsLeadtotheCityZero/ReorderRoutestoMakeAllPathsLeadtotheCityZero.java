package ReorderRoutestoMakeAllPathsLeadtotheCityZero;

import java.util.*;

public class ReorderRoutestoMakeAllPathsLeadtotheCityZero {

    public int minReorder(int n, int[][] connections) {
        Map<Integer, List<int[]>> graph = new HashMap<>();

        for (int[] conn : connections) {
            int a = conn[0], b = conn[1];
            graph.computeIfAbsent(a, x -> new ArrayList<>()).add(new int[]{b, 1});
            graph.computeIfAbsent(b, x -> new ArrayList<>()).add(new int[]{a, 0});
        }

        boolean[] visited = new boolean[n];
        return dfs(0, graph, visited);
    }

    private int dfs(int city, Map<Integer, List<int[]>> graph, boolean[] visited) {
        visited[city] = true;
        int changes = 0;

        for (int[] neighbor : graph.getOrDefault(city, Collections.emptyList())) {
            int nextCity = neighbor[0];
            int needsChange = neighbor[1];
            if (!visited[nextCity]) {
                changes += needsChange;
                changes += dfs(nextCity, graph, visited);
            }
        }
        return changes;
    }

    public static void main(String[] args) {
        ReorderRoutestoMakeAllPathsLeadtotheCityZero solution = new ReorderRoutestoMakeAllPathsLeadtotheCityZero();

        int[][] connections1 = {{0,1},{1,3},{2,3},{4,0},{4,5}};
        System.out.println(solution.minReorder(6, connections1)); // Output: 3

        int[][] connections2 = {{1,0},{1,2},{3,2},{3,4}};
        System.out.println(solution.minReorder(5, connections2)); // Output: 2

        int[][] connections3 = {{1,0},{2,0}};
        System.out.println(solution.minReorder(3, connections3)); // Output: 0
    }
}


//There are n cities numbered from 0 to n - 1 and n - 1 roads such that there is only one way to travel between two different cities (this network form a tree). Last year, The ministry of transport decided to orient the roads in one direction because they are too narrow.
//
//Roads are represented by connections where connections[i] = [ai, bi] represents a road from city ai to city bi.
//
//        This year, there will be a big event in the capital (city 0), and many people want to travel to this city.
//
//Your task consists of reorienting some roads such that each city can visit the city 0. Return the minimum number of edges changed.
//
//        It's guaranteed that each city can reach city 0 after reorder.
//
//
//
//Example 1:
//
//
//Input: n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
//Output: 3
//Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).
//Example 2:
//
//
//Input: n = 5, connections = [[1,0],[1,2],[3,2],[3,4]]
//Output: 2
//Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).
//Example 3:
//
//Input: n = 3, connections = [[1,0],[2,0]]
//Output: 0
//
//
//Constraints:
//
//        2 <= n <= 5 * 104
//connections.length == n - 1
//connections[i].length == 2
//        0 <= ai, bi <= n - 1
//ai != bi