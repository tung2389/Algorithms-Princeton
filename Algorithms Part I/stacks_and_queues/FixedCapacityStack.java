package stacks_and_queues;
import java.util.Scanner;

public class FixedCapacityStack {
    private String[] stack;
    private int numItem = 0;

    public FixedCapacityStack(int capactiy) {
        stack = new String[capactiy];
    }

    public boolean isEmpty() {
        return numItem == 0;
    }

    public int size() {
        return numItem;
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

    public void printAllItems() {
        for (String item : stack) {
            if (item != null) {
                System.out.println(item);
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int capactiy = input.nextInt();
        FixedCapacityStack stack = new FixedCapacityStack(capactiy);

        input.nextLine();
        while(true) {
            String item = input.nextLine();
            if (item.isEmpty()) {
                break;
            } 

            if (!item.equals("-")) {
                if (stack.size() < capactiy) {
                    stack.push(item);
                }
                else {
                    System.out.println("Stack is full");
                }
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
        System.out.println("Items left on stack: ");
        stack.printAllItems();
    }
}
