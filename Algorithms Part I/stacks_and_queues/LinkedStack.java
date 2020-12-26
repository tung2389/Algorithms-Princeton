package stacks_and_queues;
import java.util.Scanner;

public class LinkedStack<Data> {
    private Node head = null;
    private int size = 0;

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
    
    public void push(Data data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public Data pop() {
        Data data = head.data;
        head = head.next;
        size--;
        return data;
    }

    public static void main(String[] args) {
        LinkedStack<String> stack = new LinkedStack<String>();
        Scanner input = new Scanner(System.in);
        while(true) {
            String data = input.nextLine();
            if (data.isEmpty()) {
                break;
            } 

            if (!data.equals("-")) {
                stack.push(data);
            }
            else {
                if (!stack.isEmpty()) {
                    System.out.println(stack.pop());
                }
                else {
                    System.out.println("Stack is empty");
                }
            }
        }
        input.close();
        System.out.println(stack.size());
    }
}
