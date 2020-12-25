package union_find;

public class WeightedQuickUnionUF {
    private int[] parent;
    private int[] size;

    public WeightedQuickUnionUF(int numNode) {
        parent = new int[numNode];
        size = new int[numNode];
        for (int i = 0; i < numNode; i++) {
            parent[i] = i;
            size[i] = 1;
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
        if (node1 == node2) return;
        int rootNode1 = root(node1);
        int rootNode2 = root(node2);
        
        if (size[rootNode1] < size[rootNode2]) {
            parent[rootNode1] = rootNode2;
            size[rootNode2] += size[rootNode1];
        }
        else {
            parent[rootNode2] = rootNode1;
            size[rootNode1] += size[rootNode2];
        }
    }

    public static void main(String[] args) {
        
    }
}
