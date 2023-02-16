package Java_calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) 
    {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(calc(scanner.nextLine()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String calc(String input) throws Exception
    {
        String result = null;
        String[] expression = input.split(" ");
        if (expression.length != 3)
        {
            throw new Exception("Invalid number of elements in equasion, make sure all elements are separated by whitespace");
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
                if (Integer.parseInt(expression[2]) != 0)
                {
                    result = Integer.toString(Integer.parseInt(expression[0]) / Integer.parseInt(expression[2]));
                }
                else
                {
                    throw new Exception("Can't divide by 0");
                }
                break;
            default:
                throw new Exception("Invalid operation");
            }
       
        return result;
    }
}
