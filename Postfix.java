import java.util.Stack;


public class Postfix<E> {
    // Static method that will return a double
    public static double calculate(String postfix) {
        // Create stack
        Stack<Double> numbers = new Stack<>();
        // Split whitespaces
        String[] splittedPostfix = postfix.split(" ");
        for (String str : splittedPostfix) {
            // If first character is digit
            if (Character.isDigit(str.charAt(0))) {
                // Get the double value of a string, push to numbers stack
                Double dblToPush = Double.valueOf(str).doubleValue();
                numbers.push(dblToPush);
            } 
            // If first character not digit
            else {
                // Get 2 last numbers
                double firstNumber = numbers.pop();
                double secondNumber = numbers.pop();
                // Switch the first char of str and make a calculation
                switch (str.charAt(0)) {
                    case '+':
                        numbers.push(secondNumber + firstNumber);
                        break;
                    case '-':
                        numbers.push(secondNumber - firstNumber);
                        break;

                    case '*':
                        numbers.push(secondNumber * firstNumber);
                        break;

                    case '/':
                        numbers.push(secondNumber / firstNumber);
                        break;
                }
            }
        }
        return numbers.pop();
    }
}
