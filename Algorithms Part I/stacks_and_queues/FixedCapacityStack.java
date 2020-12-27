package stacks_and_queues;
import java.util.Scanner;

public class FixedCapacityStack<Item> {
    private Item[] stack;
    private int numItem = 0;

    public FixedCapacityStack(int capactiy) {
        stack = (Item[]) new Object[capactiy];
    }

    public boolean isEmpty() {
        return numItem == 0;
    }

    public int size() {
        return numItem;
    }

    public void push(Item item) {
        stack[numItem] = item;
        numItem++;
    }

    public Item pop() {
        numItem--;
        Item item = stack[numItem];
        stack[numItem] = null; // Free the memory - avoid loitering
        return item;
    }

    public void printAllItems() {
        for (Item item : stack) {
            if (item != null) {
                System.out.println(item);
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int capactiy = input.nextInt();
        FixedCapacityStack<String> stack = new FixedCapacityStack<String>(capactiy);

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
