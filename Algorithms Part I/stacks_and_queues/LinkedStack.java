package stacks_and_queues;

public class LinkedStack {
    private Node head = null;

    private class Node {
        String data;
        Node next;

        public Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }
    
    public void push(String data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public String pop() {
        String data = head.data;
        head = head.next;
        return data;
    }
}
