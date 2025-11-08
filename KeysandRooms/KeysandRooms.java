package KeysandRooms;
import java.util.*;

public class KeysandRooms {
    public boolean keysandRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        dfs(0 , rooms, visited);

        for (boolean roomVisited : visited) {
            if (!roomVisited) return false;
        }
        return true;
    }
    private void dfs(int room , List<List<Integer>> rooms , boolean[] visited) {
        if (visited[room]) return;
        visited[room] = true;
        for (int key : rooms.get(room)) {
            dfs(key , rooms, visited);
        }
    }
    public static void main(String[] args) {
        KeysandRooms solution = new KeysandRooms();

        // Приклад 1
        List<List<Integer>> rooms1 = new ArrayList<>();
        rooms1.add(Arrays.asList(1));
        rooms1.add(Arrays.asList(2));
        rooms1.add(Arrays.asList(3));
        rooms1.add(Collections.emptyList());

        System.out.println("Example 1: " + solution.keysandRooms(rooms1)); // true

        // Приклад 2
        List<List<Integer>> rooms2 = new ArrayList<>();
        rooms2.add(Arrays.asList(1,3));
        rooms2.add(Arrays.asList(3,0,1));
        rooms2.add(Arrays.asList(2));
        rooms2.add(Arrays.asList(0));

        System.out.println("Example 2: " + solution.keysandRooms(rooms2)); // false
    }
}


//There are n rooms labeled from 0 to n - 1 and all the rooms are locked except for room 0. Your goal is to visit all the rooms. However, you cannot enter a locked room without having its key.
//
//When you visit a room, you may find a set of distinct keys in it. Each key has a number on it, denoting which room it unlocks, and you can take all of them with you to unlock the other rooms.
//
//Given an array rooms where rooms[i] is the set of keys that you can obtain if you visited room i, return true if you can visit all the rooms, or false otherwise.
//
//
//
//        Example 1:
//
//Input: rooms = [[1],[2],[3],[]]
//Output: true
//Explanation:
//We visit room 0 and pick up key 1.
//We then visit room 1 and pick up key 2.
//We then visit room 2 and pick up key 3.
//We then visit room 3.
//Since we were able to visit every room, we return true.
//Example 2:
//
//Input: rooms = [[1,3],[3,0,1],[2],[0]]
//Output: false
//Explanation: We can not enter room number 2 since the only key that unlocks it is in that room.
//
//
//        Constraints:
//
//n == rooms.length
//2 <= n <= 1000
//        0 <= rooms[i].length <= 1000
//        1 <= sum(rooms[i].length) <= 3000
//        0 <= rooms[i][j] < n
//All the values of rooms[i] are unique.