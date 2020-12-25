package stacks_and_queues;

public class FixedCapacityStack {
    private String[] stack;
    private int numItem = 0;

    public FixedCapacityStack(int capactiy) {
        stack = new String[capactiy];
    }

    public boolean isEmpty() {
        return numItem == 0;
    }

    public void push(String item) {
        stack[numItem] = item;
        numItem++;
    }

    public String pop() {
        numItem--;
        String item = stack[numItem];
        stack[numItem] = null; // Free the memory - avoid loitering
        return item;
    }
}
