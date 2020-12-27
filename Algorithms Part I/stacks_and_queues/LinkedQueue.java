package stacks_and_queues;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class LinkedQueue<Data> {
    private Node head, tail;
    private int size;

    public LinkedQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    private class Node {
        Data data;
        Node next;

        public Node(Data data) {
            this.data = data;
            this.next = null;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }
 
    public void enqueue(Data data) {
        Node oldTail = tail;
        Node newNode = new Node(data);
        newNode.next = null;
        tail = newNode;
        if (isEmpty()) {
            head = newNode;
        }
        else {
            oldTail.next = newNode;
        }
        size++;
    }

    public Data dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Data data = head.data;
        head = head.next;
        if (isEmpty()) {
            tail = null;
        } 
        size--;
        return data;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedQueue<String> queue = new LinkedQueue<String>();
        while(true) {
            String data = input.nextLine();
            if (data.isEmpty()) {
                break;
            } 

            if (!data.equals("-")) {
                queue.enqueue(data);
            }
            else {
                if (!queue.isEmpty()) {
                    System.out.println(queue.dequeue());
                }
                else {
                    System.out.println("Queue is empty");
                }
            }
        }
        input.close();
        System.out.println("Items left on queue: " + queue.size());
    }
}
