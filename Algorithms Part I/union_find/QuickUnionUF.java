package union_find;

public class QuickUnionUF {
    private int[] parent;

    public QuickUnionUF(int numNode) {
        parent = new int[numNode];
        for (int i = 0; i < numNode; i++) {
            parent[i] = i;
        }
    }

    private int root(int node) {
        // Climb up to the root
        while (node != parent[node]) {
            node = parent[node];
        }
        return node;
    }

    public boolean connected(int node1, int node2) {
        return root(node1) == root(node2);
    }

    public void union(int node1, int node2) {
        int rootNode1 = root(node1);
        int rootNode2 = root(node2);
        parent[rootNode1] = rootNode2;
    }

    public static void main(String[] args) {
        
    }
}
