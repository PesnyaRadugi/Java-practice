package Java_calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) 
    {
        System.out.println("Welcome to calculator, enter an equasion, make sure to separate it's elements with whitespace");
        System.out.println("You are allowed to use only values from 0 to 10 in roman system or arabic system");
        try 
        {
            System.out.println(calc(scanner.nextLine()));
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }

        // System.out.println(isNumeric(""));
    }

    private static boolean isNumeric(String string)
    {
        char[] characters = string.toCharArray();
        for (char character: characters)
        {
            if (!Character.isDigit(character))
            {
                return false;
            }
        }
        return true;
    }

    private static String arabicToRoman(int numberArabic)
    {
        if (numberArabic < 0)
        {
            try
            {
                throw new Exception("Roman values cannot be < 0");
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        String[] romans = 
        {
            "O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
            "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
            "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
            "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
            "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
            "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
            "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };

        return romans[numberArabic];
    }

    private static int romansToArabic(String roman) throws Exception
    {
        try
        {
            if (roman.equals("I")) {
                return 1;
            } else if (roman.equals("II")) {
                return 2;
            } else if (roman.equals("III")) {
                return 3;
            } else if (roman.equals("IV")) {
                return 4;
            } else if (roman.equals("V")) {
                return 5;
            } else if (roman.equals("VI")) {
                return 6;
            } else if (roman.equals("VII")) {
                return 7;
            } else if (roman.equals("VIII")) {
                return 8;
            } else if (roman.equals("IX")) {
                return 9;
            } else if (roman.equals("X")) {
                return 10;
            }
            else
            {
                throw new Exception("Incorrect data format");
                break;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return -1;
    }

    public static String calc(String input) throws Exception
    {
        String result = null;
        String[] expression = input.split(" ");
        
        if (expression.length != 3)
        {
            throw new Exception("Invalid number of elements in equasion, make sure all elements are separated by whitespace");
        }
        int val1, val2;
        String operator = expression[1];
        
        if (isNumeric(expression[0]) && isNumeric(expression[2]))
        {
            val1 = Integer.parseInt(expression[0]);
            val2 = Integer.parseInt(expression[2]);
            switch(operator)
            {
                case "+":
                    result = Integer.toString(val1 + val2);
                    break;
                case "-":
                    result = Integer.toString(val1 - val2);
                    break;
                case "*":
                    result = Integer.toString(val1 * val2);
                    break;
                case "/":
                    try 
                    {
                        result = Integer.toBinaryString(val1 / val2);   
                    } catch (Exception e)
                    {
                        throw new Exception("Can't divide by 0");
                    }
            }
        }
        else if (!isNumeric(expression[0]) && !isNumeric(expression[2]))
        {
            val1 = romansToArabic(expression[0]);
            val2 = romansToArabic(expression[2]);
            switch(operator)
            {
                case "+":
                    result = arabicToRoman(val1 + val2);
                    break;
                case "-":
                    result = arabicToRoman(val1 - val2);
                    break;
                case "*":
                    result = arabicToRoman(val1 * val2);
                    break;
                case "/":
                    try 
                    {
                        result = arabicToRoman(val1 / val2);    
                    } catch (Exception e)
                    {
                        throw new Exception("Can't divide by 0");
                    }
                    break;
            }
        }
        else
        {
            try
            {
                throw new Exception("Both values must be of same type");
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        return result;
    }
}
