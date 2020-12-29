package sort;

public class HeapSort {
    private HeapSort() {}

    public static void sort(Comparable[] priorityQueue) {
        int numNode = priorityQueue.length;

        // heapify phase
        for (int i = numNode / 2; i >= 1; i--) {
            sink(priorityQueue, i, numNode);
        }

        // sortdown phase
        int maxIndex = numNode;
        while (maxIndex > 1) {
            swap(priorityQueue, 1, maxIndex);
            maxIndex--;
            sink(priorityQueue, 1, maxIndex);
        }
    }

    private static void sink(Comparable[] priorityQueue, int index, int numNode) {
        while (2 * index <= numNode) {
            int leftChildNodeIndex = 2 * index;
            int chosenIndex = leftChildNodeIndex;
            if (leftChildNodeIndex < numNode) {
                int rightChildNodeIndex = leftChildNodeIndex + 1;
                if (less(priorityQueue, leftChildNodeIndex, rightChildNodeIndex)) {
                    chosenIndex = rightChildNodeIndex;
                }
            }
            if(!less(priorityQueue, index, chosenIndex)) break;
            swap(priorityQueue, index, chosenIndex);
            index = chosenIndex;
        }
    }
    // Indices are "off-by-one" to support 1-based indexing.
    private static boolean less(Comparable[] priorityQueue, int i, int j) {
        return priorityQueue[i - 1].compareTo(priorityQueue[j - 1]) < 0;
    }

    //Indices are "off-by-one" to support 1-based indexing.
    private static void swap(Comparable[] priorityQueue, int i, int j) {
        Comparable temp = priorityQueue[i - 1];
        priorityQueue[i - 1] = priorityQueue[j - 1];
        priorityQueue[j - 1] = temp;
    }

    public static void main(String[] args) {
        String[] s = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        HeapSort.sort(s);
        for (int i = 0; i < s.length; i++) {
            System.out.print(s[i] + " ");
        }
    }
}
