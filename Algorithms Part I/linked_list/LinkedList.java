package linked_list;
public class LinkedList {

    Node head; // Head of the linked list

    private class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    public void insert(int data, int pos) {
        Node newNode = new Node(data);
        newNode.next = null;
        if (head == null) { // The list has no node
            head = newNode;
        }

        else {
            int count = 0;
            Node targetNode = head;
            Node prevTargetNode = null;

            if (pos == 0) { // Insert at the beginning
                newNode.next = head;
                head = newNode;
                return;
            }

            while(count < pos && targetNode != null) {
                prevTargetNode = targetNode;
                targetNode = targetNode.next;
                count++;
            }

            if(targetNode == null) {
                if (count == pos) { // Insert at the end
                    prevTargetNode.next = newNode;        
                    return;
                }
                else { // The pos to insert is out of range
                    throw new InvalidPosition("Invalid position to insert. The position cannot be bigger than the list's length");
                }
            }

            // Insert at the middle
            prevTargetNode.next = newNode;
            newNode.next = targetNode;
        }
    }

    public void printList() {
        Node currentNode = head;
        while(currentNode != null) {
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.insert(1, 0);
        list.insert(2, 1);
        list.insert(3, 2);
        list.insert(4, 1);
        list.insert(5, 2);
        list.insert(6, 5);
        list.insert(0, 0);
        list.printList();
        
        list.insert(7, 8);

    }
}

class InvalidPosition extends RuntimeException{
    public InvalidPosition(String s) {
        super(s);
    }
}


