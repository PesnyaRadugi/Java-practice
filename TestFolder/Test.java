package TestFolder;

class Solution {

    public static void main(String[] args) {
        System.out.println(romanToInt("IV"));
    }

    public static int romanToInt(String s) {
        
        int result = 0;
        int currentNumber = 0;
        int previousNumber = 0;

        for (int i = s.length() - 1; i >= 0; i--)
        {
            switch(s.charAt(i))
            {
                case 'M' -> currentNumber = 1000;
                case 'D' -> currentNumber = 500;
                case 'C' -> currentNumber = 100;
                case 'L' -> currentNumber = 50;
                case 'X' -> currentNumber = 10;
                case 'V' -> currentNumber = 5;
                case 'I' -> currentNumber = 1;
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

        return result;
    }
}