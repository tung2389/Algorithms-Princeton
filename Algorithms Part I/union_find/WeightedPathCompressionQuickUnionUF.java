package union_find;
import java.util.Scanner;

public class WeightedPathCompressionQuickUnionUF {
    private int[] parent;
    private int[] size;

    public WeightedPathCompressionQuickUnionUF(int numNode) {
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
            int grandParentNode = parent[parent[node]];
            parent[node] = grandParentNode;
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
        Scanner input = new Scanner(System.in);
        int numNode = input.nextInt();
        QuickFindUF uf = new QuickFindUF(numNode);
        while(input.hasNextInt()) {
            int node1 = input.nextInt();
            int node2 = input.nextInt();
            if (uf.connected(node1, node2)) continue;
            uf.union(node1, node2);
        }
        input.close();
        System.out.println(uf.connected(3, 9)); // True
        System.out.println(uf.connected(7, 0)); // True
        System.out.println(uf.connected(7, 4)); // False
    }
}
