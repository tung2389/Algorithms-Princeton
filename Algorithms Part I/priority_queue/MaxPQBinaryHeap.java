package priority_queue;

public class MaxPQBinaryHeap<Key extends Comparable<Key>> {
    private Key[] priorityQueues;
    private int numNode;

    public MaxPQBinaryHeap(int capactiy) {
        priorityQueues = (Key[]) new Comparable[capactiy + 1]; // +1 because we will not use index 0
    }

    public boolean isEmpty() {
        return numNode == 0;
    }

    public void insert(Key key) {
        numNode++;
        priorityQueues[numNode] = key;
        rise(numNode);
    }

    public Key deleteMax() {
        Key max = priorityQueues[1]; // The root
        swap(1, numNode);
        // Delete the max node
        priorityQueues[numNode] = null;
        numNode--;
        // Sink the top node to the right position
        sink(1);
        return max;
    }

    private void rise(int index) {
        while (index > 1 && less(index / 2, index)) {
            swap(index, index / 2);
            index = index / 2;
        }
    }

    private void sink(int index) {
        while (2 * index <= numNode) {
            int leftChildNodeIndex = 2 * index;
            int chosenIndex = leftChildNodeIndex;
            if (leftChildNodeIndex < numNode) {
                int rightChildNodeIndex = leftChildNodeIndex + 1;
                if (less(leftChildNodeIndex, rightChildNodeIndex)) {
                    chosenIndex = rightChildNodeIndex;
                }
            }
            if(!less(index, chosenIndex)) break;
            swap(index, chosenIndex);
            index = chosenIndex;
        }
    }

    private boolean less(int i, int j) {
        return priorityQueues[i].compareTo(priorityQueues[j]) < 0;
    }

    private void swap(int i, int j) {
        Key temp = priorityQueues[i];
        priorityQueues[i] = priorityQueues[j];
        priorityQueues[j] = temp;
    }
}
