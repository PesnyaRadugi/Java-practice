package Java_calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) 
    {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(calc(scanner.nextLine()));
        }
    }

    public static String calc(String input)
    {
        String result = null;
        String[] expression = input.split(" ");
        if (expression.length != 3)
        {
            try {
                throw new Exception("Invalid number of elements in equasion, make sure all elements are separated by whitespace");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        switch(expression[1])
        {
            case "+":
                result = Integer.toString(Integer.parseInt(expression[0]) + Integer.parseInt(expression[2]));
                break;       
            case "-":
                result = Integer.toString(Integer.parseInt(expression[0]) - Integer.parseInt(expression[2]));
                break;
            case "*":
                result = Integer.toString(Integer.parseInt(expression[0]) * Integer.parseInt(expression[2]));
                break;
            case "/":
                result = Integer.toString(Integer.parseInt(expression[0]) / Integer.parseInt(expression[2]));
                break;
            default:
                try {
                    throw new Exception("Invalid operation");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
       
        return result;
    }
}
