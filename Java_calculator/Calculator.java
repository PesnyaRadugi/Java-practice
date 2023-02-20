package Java_calculator;

import java.util.Scanner;


public class Calculator {
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

        int result = 0;
        int currentNumber = 0;
        int previousNumber = 0;

        for (int i = roman.length() - 1; i >= 0; i--)
        {
            switch(roman.charAt(i))
            {
                case 'O' -> currentNumber = 0;
                case 'I' -> currentNumber = 1;
                case 'V' -> currentNumber = 5;
                case 'X' -> currentNumber = 10;
                default -> throw new Exception("Incorrect data format");
            }
            if (currentNumber < previousNumber)
            {
                result -= currentNumber;
            }
            else
            {
                result += currentNumber;
            }
            previousNumber = currentNumber;
        }

        if (result > 10)
        {
            throw new Exception("Element of equasion is beyond 10");
        }
        else
        {
            return result;
        }
    }

    public static String calc(String input) throws Exception
    {
        String[] expression = input.split(" "); // Я не знаю, можно ли так делать по условию, в нём не уточняется, но я просто попросил вводить всё через пробел и 
        int val1, val2; // разбил строку на массив из подстрок, с которыми уже работаю.
        String operator = expression[1];

        if (expression.length != 3)
        {
            throw new Exception("Invalid number of elements in equasion, make sure all elements are separated by whitespace");
        }
        
        if (isNumeric(expression[0]) && isNumeric(expression[2]))
        {
            val1 = Integer.parseInt(expression[0]);
            val2 = Integer.parseInt(expression[2]);
            
            if (Math.abs(val1) > 10 || Math.abs(val2) > 10)
            {
                throw new Exception("Equasion element is beyond 10"); // В этом месте, если ввод был в арабской системе - исключение отрабатывает
            }

            switch(operator)
            {
                case "+":
                    return Integer.toString(val1 + val2);
                case "-":
                    return Integer.toString(val1 - val2);
                case "*":
                    return Integer.toString(val1 * val2);
                case "/":
                    try 
                    {
                        return Integer.toBinaryString(val1 / val2);   
                    } 
                    catch (Exception e)
                    {
                        throw new Exception("Can't divide by 0");
                    }
                default:
                    throw new Exception("Invalid operation");
            }
        }
        else if (!isNumeric(expression[0]) && !isNumeric(expression[2]))
        {
            val1 = romansToArabic(expression[0]);
            val2 = romansToArabic(expression[2]);

            switch(operator)
            {
                case "+":
                    return arabicToRoman(val1 + val2);
                case "-":
                    return arabicToRoman(val1 - val2);
                case "*":
                    return arabicToRoman(val1 * val2);

                case "/":
                    try 
                    {
                        return arabicToRoman(val1 / val2);    
                    }
                    catch (Exception e)
                    {
                        throw new Exception("Can't divide by 0");
                    }
                default:
                    throw new Exception("Invalid operation");
                }
        }
        else
        {
            throw new Exception("Aboba");
        }
    }
}
