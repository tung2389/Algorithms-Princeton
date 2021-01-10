package binary_search_tree;
import java.lang.Thread.State;
import java.util.EnumSet;

import stacks_and_queues.Queue;

public class BST<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        private Key key;
        private Value value;
        private Node left, right;
        private int size;
        
        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
            this.size = 1;
        }
    }

    public Value get(Key key) {
        return getValue(root, key);
    }

    private Value getValue(Node startNode, Key key) {
        while (startNode != null) {
            int comparison = key.compareTo(startNode.key);
            if (comparison < 0) startNode = startNode.left;
            else if (comparison > 0) startNode = startNode.right;
            else return startNode.value;
        }
        return null;
    }

    public void put(Key key, Value value) {
        root = putNode(root, key, value);
    }

    private Node putNode(Node startNode, Key key, Value value) {
        if (startNode == null) return new Node(key, value);
        int comparison = key.compareTo(startNode.key);

        if (comparison < 0) {
            startNode.left = putNode(startNode.left, key, value);
        }
        else if (comparison > 0) {
            startNode.right = putNode(startNode.right, key, value);
        }
        else {
            startNode.value = value;
        }
        startNode.size = 1 + getSize(startNode.left) + getSize(startNode.right);
        return startNode;
    } 

    public Key floor(Key key) {
        Node floorNode = calcFloor(root, key);
        if (floorNode == null) return null;
        return floorNode.key;
    }

    private Node calcFloor(Node startNode, Key key) {
        if (startNode == null) return null;
        int comparison = key.compareTo(startNode.key);
        if (comparison < 0) {
            // We will search in the left
            return calcFloor(startNode.left, key);
        }
        else if (comparison > 0) {
            // Search on the right. If there is no valid key on the right, it must be the startNode (the root of current subtree)
            Node floor = calcFloor(startNode.right, key);
            if (floor != null) return floor;
            // No valid key
            else return startNode;
        }
        else return startNode;
    }  

    public int size() {
        return getSize(root);
    }

    private int getSize(Node startNode) {
        if (startNode == null) return 0;
        return startNode.size;
    }

    public int rank(Key key) {
        return calcRank(root, key);
    }

    private int calcRank(Node startNode, Key key) {
        if (startNode == null) return 0;
        int comparison = key.compareTo(startNode.key);
        if (comparison < 0) return calcRank(startNode.left, key);
        else if (comparison > 0) return 1 + getSize(startNode.left) + calcRank(startNode.right, key);
        else return getSize(startNode.left);
    }

    // public Iterable<Key> keys() {
    //     Queue<Key> queue = new Queue<Key>();
    //     putInOrder(root, queue);
    //     return queue;
    // }
    
    private void putInOrder(Node startNode, Queue<Key> queue) {
        if (startNode == null) return;
        putInOrder(startNode.left, queue);
        queue.enqueue(startNode.key);
        putInOrder(startNode.right, queue);
    }
    
    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node startNode) {
        if (startNode.left == null) {
            return startNode.right;
        }
        startNode.left = deleteMin(startNode.left);
        startNode.size = 1 + getSize(startNode.left) + getSize(startNode.right);
        return startNode;
    }

    private Node findMin(Node startNode) {
        if (startNode.left == null) return startNode;
        return findMin(startNode.left);    
    }

    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node startNode, Key key) {
        if (startNode == null) return null;
        int comparison = key.compareTo(startNode.key);
        if (comparison < 0) startNode.left = delete(startNode.left, key)
        else if (comparison > 0) startNode.right = delete(startNode.right, key)
        else {
            if (startNode.right == null) return startNode.left;
            if (startNode.left == null) return startNode.right;

            // Let's call the node that we need to delete x. Basically, SUBSTITUTE x with the MIN node at the right of x. This will ensure the structure of the tree.
            Node will_be_deleted = startNode;
            Node min_right_of_will_be_deleted = findMin(will_be_deleted.right);
            min_right_of_will_be_deleted.right = deleteMin(will_be_deleted.right);
            min_right_of_will_be_deleted.left = will_be_deleted.left;
            
            startNode = min_right_of_will_be_deleted;
        }

        startNode.size = 1 + getSize(startNode.left) + getSize(startNode.right);
        return startNode;
    }
}
