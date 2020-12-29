package priority_queue;

import java.util.Scanner;

public class MaxPQBinaryHeap<Key extends Comparable<Key>> {
    private Key[] priorityQueue;
    private int numNode;

    public MaxPQBinaryHeap(int capactiy) {
        priorityQueue = (Key[]) new Comparable[capactiy + 1]; // +1 because we will not use index 0
    }

    public boolean isEmpty() {
        return numNode == 0;
    }

    public void insert(Key key) {
        numNode++;
        priorityQueue[numNode] = key;
        rise(numNode);
    }

    public Key deleteMax() {
        Key max = priorityQueue[1]; // The root
        swap(1, numNode);
        // Delete the max node
        priorityQueue[numNode] = null;
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
        return priorityQueue[i].compareTo(priorityQueue[j]) < 0;
    }

    private void swap(int i, int j) {
        Key temp = priorityQueue[i];
        priorityQueue[i] = priorityQueue[j];
        priorityQueue[j] = temp;
    }

    public void printAllItems() {
        for (Key key : priorityQueue) {
            if (key != null) {
                System.out.println(key);
            }
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int capactiy = input.nextInt();
        MaxPQBinaryHeap<String> priorityQueue = new MaxPQBinaryHeap<String>(capactiy);

        input.nextLine();
        while(true) {
            String item = input.nextLine();
            if (item.isEmpty()) {
                break;
            } 

            if (!item.equals("-")) {
                priorityQueue.insert(item);
            }
            else {
                if (!priorityQueue.isEmpty()) {
                    System.out.println(priorityQueue.deleteMax());
                }
                else {
                    System.out.println("Queue is empty");
                }
            }
        }
        input.close();
        System.out.println("Items left on Queue: ");
        priorityQueue.printAllItems();
    }
}
