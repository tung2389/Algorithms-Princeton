package union_find;
import java.util.Scanner;
// A more clean version of weighted + path compression UnionFind 

public class UnionFind {
    private int[] parent;
    private int[] rank; // You can think of rank[i] as the depth of the longest branch rooted at i

    public UnionFind(int numNode) {
        parent = new int[numNode];
        rank = new int[numNode];
        for (int i = 0; i < numNode; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    private int findRoot(int node) {
        // Climb up to the root
        while (node != parent[node]) {
            int grandParentNode = parent[parent[node]];
            parent[node] = grandParentNode;
            node = parent[node];
        }
        return node;
    }

    public boolean connected(int node1, int node2) {
        return findRoot(node1) == findRoot(node2);
    }

    public void union(int node1, int node2) {
        if (node1 == node2) return;
        int rootNode1 = findRoot(node1);
        int rootNode2 = findRoot(node2);
        
        if (rank[rootNode1] < rank[rootNode2]) {
            parent[rootNode1] = rootNode2;
        }
        else if (rank[rootNode2] < rank[rootNode1]) {
            parent[rootNode2] = rootNode1;
        }
        else {
            parent[rootNode2] = rootNode1; // Abitrarily assign root of node 1 as the parent of the root of node 2
            rank[rootNode1]++;
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
