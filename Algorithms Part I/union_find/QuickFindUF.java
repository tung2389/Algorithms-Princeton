package union_find;
import java.util.Scanner;
import java.util.Arrays;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

// Every node in a component (thus connected) is on the same group

public class QuickFindUF {
    private int[] group;

    public QuickFindUF(int numNode) {
        group = new int[numNode];
        for (int i = 0; i < numNode; i++) {
            group[i] = i;
        }
    }

    public boolean connected(int node1, int node2) {
        return group[node1] == group[node2];
    }

    public void union(int node1, int node2) {
        int node1Group = group[node1];
        int node2Group = group[node2];
        for (int i = 0; i < group.length; i++) {
            if (group[i] == node1Group) {
                group[i] = node2Group;
            }
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
        System.out.println(Arrays.toString(uf.group));
    }
}