package stacks_and_queues;

import java.util.Scanner;

public class Evaluate {
    public static void main(String[] args) {
        LinkedStack<String> operators = new LinkedStack<String>();
        LinkedStack<Double> operands = new LinkedStack<Double>();

        // Sample input: ( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )
        Scanner input = new Scanner(System.in);
        String operation = input.nextLine();
        input.close();

        for (String s : operation.split(" ")) {
            if (s.equals("(")) { /* Do nothing */ }
            else if (s.equals("+") || s.equals("*")) {
                operators.push(s);
            }
            else if (s.equals(")")) {
                String operator = operators.pop();
                if (operator.equals("+")) {
                    operands.push(operands.pop() + operands.pop());
                }
                else if (operator.equals("*")) {
                    operands.push(operands.pop() * operands.pop());
                }
            }
            else {
                operands.push(Double.parseDouble(s));
            }
        }
        System.out.println(operands.pop());
    }
}
