import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num;
        double number;

             while (true) {
            System.out.print("How many numbers? ");
            if (scanner.hasNextDouble()) {
                num = scanner.nextDouble();
                if (isInteger(num) && num >= 1) {
                    break;
                } else {
                    System.out.println("YOU STUPID MUSTARDBLUD, PUT IN AN INTEGER GREATER THAN 1");
                }
            } else {
                System.out.println("GRRRR");
                scanner.next();
            }
        }
        int i = (int) num;
        double answer = 0.0;

        while (true) {
            System.out.print("Enter a number: ");
            if (scanner.hasNextDouble()) {
                number = scanner.nextDouble();
                break; 
            } else {
                System.out.println("I'm gonna touch you if you keep acting up");
                scanner.next();
            }
        }
        answer = number;

        for (int j = 1; j < i; j++) {
            String operation;
            while (true) {
                System.out.println("Select a function: +, -, *, /");
                operation = scanner.next();
                if (operation.equals("+") || operation.equals("-") || operation.equals("*") || operation.equals("/")) {
                    break;
                } else {
                    System.out.println("Oopsies woopsies you made a fucko boingo you GODDAMN IDIOT HOW HARD IS IT!!!!");
                }
            }

            while (true) {
                System.out.print("Enter a number: ");
                if (scanner.hasNextDouble()) {
                    number = scanner.nextDouble();
                    break; 
                } else {
                    System.out.println("That's it you're getting touched...");
                    scanner.next(); 
                }
            }

            switch (operation) {
                case "+":
                    answer += number;
                    break;
                case "-":
                    answer -= number;
                    break;
                case "*":
                    answer *= number;
                    break;
                case "/":
                    if (number != 0) {
                        answer /= number;
                    } else {
                        System.out.println("Cannot divide by zero.");
                    }
                    break;
            }
            System.out.println("Answer: " + answer);
        }

        scanner.close();
    }

    // Helper function to check if a number is an integer
    public static boolean isInteger(double numbre) {
        return numbre == (int) numbre;
    }
}