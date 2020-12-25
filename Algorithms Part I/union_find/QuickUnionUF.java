package union_find;
import java.util.Scanner;

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
