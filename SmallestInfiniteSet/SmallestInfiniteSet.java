import java.util.PriorityQueue;
import java.util.HashSet;

class SmallestInfiniteSet {
    private PriorityQueue<Integer> minHeap;
    private HashSet<Integer> set;
    private int current;

    public SmallestInfiniteSet() {
        minHeap = new PriorityQueue<>();
        set = new HashSet<>();
        current = 1;
    }

    public int popSmallest() {
        if (!minHeap.isEmpty()) {
            int smallest = minHeap.poll();
            set.remove(smallest);
            return smallest;
        } else {
            return current++;
        }
    }

    public void addBack(int num) {
        if (num < current && !set.contains(num)) {
            minHeap.add(num);
            set.add(num);
        }
    }

    public static void main(String[] args) {
        SmallestInfiniteSet smallestInfiniteSet = new SmallestInfiniteSet();
        smallestInfiniteSet.addBack(2);
        System.out.println(smallestInfiniteSet.popSmallest()); // 1
        System.out.println(smallestInfiniteSet.popSmallest()); // 2
        System.out.println(smallestInfiniteSet.popSmallest()); // 3
        smallestInfiniteSet.addBack(1);    // додаємо 1 назад
        System.out.println(smallestInfiniteSet.popSmallest()); // 1
        System.out.println(smallestInfiniteSet.popSmallest()); // 4
        System.out.println(smallestInfiniteSet.popSmallest()); // 5
    }
}

//You have a set which contains all positive integers [1, 2, 3, 4, 5, ...].
//
//Implement the SmallestInfiniteSet class:
//
//SmallestInfiniteSet() Initializes the SmallestInfiniteSet object to contain all positive integers.
//int popSmallest() Removes and returns the smallest integer contained in the infinite set.
//void addBack(int num) Adds a positive integer num back into the infinite set, if it is not already in the infinite set.
//
//
//Example 1:
//
//Input
//["SmallestInfiniteSet", "addBack", "popSmallest", "popSmallest", "popSmallest", "addBack", "popSmallest", "popSmallest", "popSmallest"]
//        [[], [2], [], [], [], [1], [], [], []]
//Output
//[null, null, 1, 2, 3, null, 1, 4, 5]
//
//Explanation
//SmallestInfiniteSet smallestInfiniteSet = new SmallestInfiniteSet();
//smallestInfiniteSet.addBack(2);    // 2 is already in the set, so no change is made.
//smallestInfiniteSet.popSmallest(); // return 1, since 1 is the smallest number, and remove it from the set.
//smallestInfiniteSet.popSmallest(); // return 2, and remove it from the set.
//smallestInfiniteSet.popSmallest(); // return 3, and remove it from the set.
//smallestInfiniteSet.addBack(1);    // 1 is added back to the set.
//smallestInfiniteSet.popSmallest(); // return 1, since 1 was added back to the set and
//// is the smallest number, and remove it from the set.
//smallestInfiniteSet.popSmallest(); // return 4, and remove it from the set.
//smallestInfiniteSet.popSmallest(); // return 5, and remove it from the set.
//