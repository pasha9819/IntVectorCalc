package ru.pasha.pt.lab2;

import javax.xml.bind.DataBindingException;
import java.util.Scanner;

public class App {
    private static final String ERROR_TOKEN_PARSE_PATTERN = "Error! Unexpected token: %s";
    private static final String MESSAGE_TRY_AGAIN = "Try again >>>";

    private Scanner sc;

    public App() {
        sc = new Scanner(System.in);
    }

    public void run(){

        System.out.println("#####\tInteger vector calculator\t#####");
        System.out.print("Initial state: ");
        System.out.println(StateManager.getState());

        boolean cont = true;
        String input;

        while (cont){
            System.out.print("Input an operator (+ or *) >>> ");
            input = sc.next();

            if (!checkOperator(input)){
                System.out.println("Incorrect operator! Try again");
                continue;
            }

            try{
                State s;
                if ("*".equals(input)){
                    System.out.print("Input scalar alpha:\nalpha = ");
                    int alpha = readInt();
                    s = StateManager.getState().multiply(alpha);
                }else {
                    System.out.print("Input vector (a, b):\na = ");
                    int a = readInt();
                    System.out.print("b = ");
                    int b = readInt();
                    s = StateManager.getState().add(a, b);
                }
                System.out.print("Current state: ");
                System.out.println(s);
                StateManager.setState(s);
            }
            catch (DataBindingException e) {
                System.out.println("XML binding error! XML state file may be corrupted.");
                return;
            } catch (ArithmeticException e) {
                System.out.println(String.format("Arithmetic Error: %s", e.getMessage()));
                continue;
            }

            cont = readContinue();
        }
    }

    private boolean checkOperator(String str){
        return "*".equals(str) || "+".equals(str);
    }

    private int readInt(){
        while (true) {
            String token = sc.next();
            try {
                return Integer.parseInt(token);
            } catch (NumberFormatException e) {
                System.out.println(String.format(ERROR_TOKEN_PARSE_PATTERN, token));
                System.out.print(MESSAGE_TRY_AGAIN);
            }
        }
    }

    private boolean readContinue() {
        System.out.print("Continue? (y/n) >>>");
        while (true) {
            String token = sc.next();
            if ("y".equalsIgnoreCase(token)) {
                return true;
            }
            if ("n".equalsIgnoreCase(token)) {
                return false;
            }
            System.out.println(String.format(ERROR_TOKEN_PARSE_PATTERN, token));
            System.out.print(MESSAGE_TRY_AGAIN);
        }
    }
}
